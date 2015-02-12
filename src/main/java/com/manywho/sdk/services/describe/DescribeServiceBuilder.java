package com.manywho.sdk.services.describe;

import com.manywho.sdk.entities.describe.DescribeValueCollection;
import com.manywho.sdk.entities.translate.Culture;

public class DescribeServiceBuilder {
    private boolean providesDatabase;
    private boolean providesLogic;
    private boolean providesViews;
    private boolean providesIdentity;
    private boolean providesSocial;
    private boolean providesFiles;
    private Culture culture;
    private DescribeValueCollection configurationValues;

    public DescribeServiceBuilder setProvidesDatabase(boolean providesDatabase) {
        this.providesDatabase = providesDatabase;
        return this;
    }

    public DescribeServiceBuilder setProvidesLogic(boolean providesLogic) {
        this.providesLogic = providesLogic;
        return this;
    }

    public DescribeServiceBuilder setProvidesViews(boolean providesViews) {
        this.providesViews = providesViews;
        return this;
    }

    public DescribeServiceBuilder setProvidesIdentity(boolean providesIdentity) {
        this.providesIdentity = providesIdentity;
        return this;
    }

    public DescribeServiceBuilder setProvidesSocial(boolean providesSocial) {
        this.providesSocial = providesSocial;
        return this;
    }

    public DescribeServiceBuilder setProvidesFiles(boolean providesFiles) {
        this.providesFiles = providesFiles;
        return this;
    }

    public DescribeServiceBuilder setCulture(Culture culture) {
        this.culture = culture;
        return this;
    }

    public DescribeServiceBuilder setConfigurationValues(DescribeValueCollection configurationValues) {
        this.configurationValues = configurationValues;
        return this;
    }

    public DescribeService createDescribeService() {
        return new AbstractDescribeService() {
            @Override
            public boolean getProvidesDatabase() {
                return providesDatabase;
            }

            @Override
            public boolean getProvidesLogic() {
                return providesLogic;
            }

            @Override
            public boolean getProvidesViews() {
                return providesViews;
            }

            @Override
            public boolean getProvidesIdentity() {
                return providesIdentity;
            }

            @Override
            public boolean getProvidesSocial() {
                return providesSocial;
            }

            @Override
            public boolean getProvidesFiles() {
                return providesFiles;
            }

            @Override
            public Culture createCulture() {
                return culture;
            }

            @Override
            public DescribeValueCollection createConfigurationValues() {
                return configurationValues;
            }
        };
    }
}