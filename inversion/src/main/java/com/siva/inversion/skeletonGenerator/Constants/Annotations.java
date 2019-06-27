package com.siva.inversion.skeletonGenerator.Constants;

public enum Annotations {
    Override("@Override"),
    Valid("@Valid"),
    RequestBody("@RequestBody"),
    COMPONENT("@Component");

    private String name;

    Annotations(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
