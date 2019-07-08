package com.siva.inversion.classgenerator.dto.request;

import java.util.Map;

public class ServiceRequest {


    private String microServiceName;

    private String serviceName;

    private Map<String, String> requestBodyParameters;

    private Map<String, String> responseBodyParameters;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMicroServiceName() {
        return microServiceName;
    }

    public void setMicroServiceName(String microServiceName) {
        this.microServiceName = microServiceName;
    }

    public Map<String, String> getRequestBodyParameters() {
        return requestBodyParameters;
    }

    public void setRequestBodyParameters(Map<String, String> requestBodyParameters) {
        this.requestBodyParameters = requestBodyParameters;
    }

    public Map<String, String> getResponseBodyParameters() {
        return responseBodyParameters;
    }

    public void setResponseBodyParameters(Map<String, String> responseBodyParameters) {
        this.responseBodyParameters = responseBodyParameters;
    }
}
