package com.siva.inversion.classgenerator.constants;

public enum BaseClasses {

    //ServiceRequest
    PAYLOAD_REQUEST("NexiBasePayloadRequest"),
    FACADE_REQUEST("NexiBaseFacadeRequest"),
    SERVICE_REQUEST("NexiBaseServiceRequest"),




    //response
    PAYLOAD_RESPONSE("NexiBasePayloadResponse"),
    FACADE_RESPONSE("NexiBaseFacadeResponse"),
    SERVICE_RESPONSE("NexiBaseServiceResponse"),

    PAYLOAD_RESPONSE_MAPPER("PayloadResponseMapper");
    private String name;

    BaseClasses(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
