package com.siva.inversion.Constants;

public enum Names {
    Mapper("Mapper"),
    Controller("Controller"),
    Payload("Payload"),
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
