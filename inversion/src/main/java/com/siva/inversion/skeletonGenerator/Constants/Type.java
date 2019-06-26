package com.siva.inversion.skeletonGenerator.Constants;

public enum Type {
    Response("Response"),
    Request("Request"),
    Implementation("Impl"),
    Mapper("Mapper");

    private String name;

    Type(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
