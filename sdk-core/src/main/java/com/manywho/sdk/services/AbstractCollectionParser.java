package com.manywho.sdk.services;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.ContentValueAware;
import com.manywho.sdk.entities.ObjectDataAware;
import com.manywho.sdk.entities.ValueAware;
import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.types.TypeParser;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class AbstractCollectionParser {
    protected TypeParser typeParser;

    public abstract <T> T parse(ValueAware properties, Class<T> tClass) throws Exception;
    public abstract <T> T parse(ValueAware properties, String id, Class<T> tClass) throws Exception;

    protected static void validate(Object entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    protected void setListField(Field field, String annotationValue, ObjectDataAware properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotationValue);
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            Class fieldClass = (Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
            if (fieldClass.isAnnotationPresent(TypeElement.class)) {
                field.set(entity, typeParser.parseList(nestedPropertyCollection, fieldClass));
            } else {
                List<Object> list = new ArrayList<>();

                nestedPropertyCollection.forEach(Throwing.consumer(object -> {
                    list.add(parse(object.getProperties(), object.getExternalId(), fieldClass));
                }));

                field.set(entity, list);
            }
        }
    }

    protected void setObjectField(Field field, String annotationValue, ObjectDataAware properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotationValue);
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            MObject object = nestedPropertyCollection.get(0);

            // If the field is annotated with @TypeElement, parse the incoming data using TypeParser
            if (field.getType().isAnnotationPresent(TypeElement.class)) {
                field.set(entity, typeParser.parseObject(object, field.getType()));
            } else {
                field.set(entity, parse(object.getProperties(), object.getExternalId(), field.getType()));
            }
        }
    }

    protected void setScalarField(Field field, String annotationValue, ContentValueAware properties, Object entity) throws IllegalAccessException, ParseException {
        String propertyValue = properties.getContentValue(annotationValue);

        Class<?> fieldType = field.getType();
        if (fieldType.equals(long.class)) {
            field.set(entity, Long.parseLong(propertyValue));
        } else if (fieldType.equals(boolean.class)) {
            field.set(entity, parseBoolean(propertyValue));
        } else if (fieldType.equals(int.class)) {
            field.set(entity, Integer.parseInt(propertyValue));
        } else if (fieldType.equals(float.class)) {
            field.set(entity, Float.parseFloat(propertyValue));
        } else if (fieldType.equals(DateTime.class)) {
            if (StringUtils.isNotEmpty(propertyValue)) {
                field.set(entity, DateTime.parse(propertyValue));
            }
        } else if (fieldType.equals(Date.class)) {
            // TODO: Check if this date format is sent the same from everywhere
            if (StringUtils.isNotEmpty(propertyValue)) {
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy H:m:s a");
                dateFormat.setLenient(true);

                try {
                    field.set(entity, dateFormat.parse(propertyValue));
                } catch (ParseException exception) {
                    field.set(entity, null);
                }
            }
        } else {
            field.set(entity, propertyValue);
        }
    }

    private boolean parseBoolean(String value) {
        return value.equalsIgnoreCase("1") || !value.equalsIgnoreCase("0") && Boolean.parseBoolean(value);
    }
}
