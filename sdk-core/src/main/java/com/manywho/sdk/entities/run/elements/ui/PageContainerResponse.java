package com.manywho.sdk.entities.run.elements.ui;

import java.util.HashMap;

public class PageContainerResponse {
    private String id;
    private String containerType;
    private String developerName;
    private String label;
    private PageContainerResponseCollection pageContainerResponses;
    private int order;
    private HashMap<String, String> attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PageContainerResponseCollection getPageContainerResponses() {
        return pageContainerResponses;
    }

    public void setPageContainerResponses(PageContainerResponseCollection pageContainerResponses) {
        this.pageContainerResponses = pageContainerResponses;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }
}
