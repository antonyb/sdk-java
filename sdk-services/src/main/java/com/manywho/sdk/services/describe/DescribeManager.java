package com.manywho.sdk.services.describe;

import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;

import javax.inject.Inject;

public class DescribeManager {
    private final DescribeService describeService;
    private final DescribeTypeService describeTypeService;
    private final DescribeActionService describeActionService;

    @Inject
    public DescribeManager(DescribeService describeService, DescribeTypeService describeTypeService, DescribeActionService describeActionService) {
        this.describeService = describeService;
        this.describeTypeService = describeTypeService;
        this.describeActionService = describeActionService;
    }

    public DescribeServiceResponse describe(DescribeServiceRequest request) {
        DescribeServiceBuilder builder = new DescribeServiceBuilder();

        // If the service contains any controllers that extend AbstractDataController, then we support Database calls
        if (describeService.anyDataControllersExist()) {
            builder.setProvidesDatabase(true);
        }

        // If the service contains any controllers that extend AbstractFileController, then we support Files
        if (describeService.anyFileControllersExist()) {
            builder.setProvidesFiles(true);
        }

        // If the service contains any controllers that extend AbstractIdentityController, then we support Identity
        if (describeService.anyIdentityControllersExist()) {
            builder.setProvidesIdentity(true);
        }

        // If the service contains any controllers that extend AbstractListenerController, then we support Listening
        if (describeService.anyListenerControllersExist()) {
            builder.setProvidesListening(true);
        }

        // If the service contains any controllers that extend AbstractSocialController, then we support Social
        if (describeService.anySocialControllersExist()) {
            builder.setProvidesSocial(true);
        }

        if (describeService.anyActionsDefined()) {
            builder.setProvidesLogic(true);

            builder.setActions(describeActionService.createActions());
        }

        if (describeService.anyTypesDefined()) {
            builder.setTypes(describeTypeService.createTypes());
        }

        if (describeService.anyConfigurationValuesExist()) {
            builder.setConfigurationValues(describeService.createConfigurationValues());
        }

        return builder.createDescribeServiceResponse();
    }
}