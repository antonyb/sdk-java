package com.manywho.sdk.entities.run.elements.type;

public class ListFilterWhere {
    private String columnName;
    private String criteriaType;
    /**
     * @deprecated use {@link #contentValue} instead
     */
    @Deprecated
    private String value;
    private String contentValue;
    private ObjectCollection objectData;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(String criteriaType) {
        this.criteriaType = criteriaType;
    }

    /**
     * @deprecated use {@link #getContentValue()} instead
     */
    @Deprecated
    public String getValue() {
        return value;
    }

    /**
     * @deprecated use {@link #setContentValue(String)} instead
     */
    @Deprecated
    public void setValue(String value) {
        this.value = value;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }
}
