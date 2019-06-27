package com.siva.inversion.skeletonGenerator.Constants;

public enum ExceptionsType {
    Exception("Exception"),
    MicroServiceException("MicroServiceException");

    private String name;

    ExceptionsType(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
