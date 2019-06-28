package com.siva.inversion.constants;

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
