package com.manywho.sdk.entities.run.state;

public class StateValueFault {

    private String valueElementId;
    private String typeElementId;
    private String faultCode;
    private String faultMessage;

    public String getValueElementId() {
        return valueElementId;
    }

    public void setValueElementId(String valueElementId) {
        this.valueElementId = valueElementId;
    }

    public String getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(String typeElementId) {
        this.typeElementId = typeElementId;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultMessage() {
        return faultMessage;
    }

    public void setFaultMessage(String faultMessage) {
        this.faultMessage = faultMessage;
    }
}
