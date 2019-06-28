package com.siva.inversion.constants;

public enum ClassNames {

    Controller("Payload"),
    Facade("Facade"),
    Service("Service");

    private String name;

    ClassNames(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
