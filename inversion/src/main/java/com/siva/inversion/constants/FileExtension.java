package com.siva.inversion.constants;

public enum FileExtension {

    FILE_EXTENSION(".java"),

    DOT_CLASS(".class");

    private String name;

    FileExtension(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
