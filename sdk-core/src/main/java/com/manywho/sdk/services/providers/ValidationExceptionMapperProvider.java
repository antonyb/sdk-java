package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.ServiceProblem;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.engine.path.PathImpl;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionMapperProvider implements ExceptionMapper<ConstraintViolationException> {
    @Inject
    private ObjectMapper objectMapper;

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String message = "Validation errors occurred: ";

        Map<String, String> validationErrors = exception.getConstraintViolations().stream()
            .collect(Collectors.toMap(
                    error -> ((PathImpl)error.getPropertyPath()).getLeafNode().getName(),
                    error -> error.getMessage()
            ));

        message = message + StringUtils.join(validationErrors, ", ");

        if (message.length() > 500) {
            message = message.substring(0, 500);
        }

        ServiceProblem serviceProblem = new ServiceProblem(uriInfo.getRequestUri().getPath(), 400, message);

        try {
            return Response.status(400)
                    .entity(objectMapper.writeValueAsString(serviceProblem))
                    .header("X-ManyWho-Service-Problem-Kind", serviceProblem.getKind())
                    .build();
        } catch (JsonProcessingException e1) {
            return Response.status(400).build();
        }
    }
}
