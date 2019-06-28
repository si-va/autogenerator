package com.siva.inversion.constants;

public enum FileExtension {

    FILE_EXTENSION(".java");

    private String name;

    FileExtension(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
