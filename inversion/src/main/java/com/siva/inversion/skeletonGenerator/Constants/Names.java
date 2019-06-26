package com.siva.inversion.skeletonGenerator.Constants;

public enum Names {
    Controller("Payload"),
    Facade("Facade"),
    Service("Service");

    private String name;

    Names(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
