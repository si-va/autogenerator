package com.siva.inversion.constants;

public enum Annotations {
    Override("@Override"),
    Valid("@Valid"),
    RequestBody("@RequestBody"),
    RequestMapping("@RequestMapping"),
    RequestMethod("RequestMethod"),
    COMPONENT("@Component");

    private String name;

    Annotations(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
