package com.siva.inversion.constants;

public enum Extra {


    PUBLIC_CLASS("public class"),

    EXTENDS("extends"),

    OPENING_PARANETHESIS("{"),

    CLOSING_PARANETHESIS("}"),

    NEW_LINE("\n"),

    OPENNING_BRACKET("("),

    CLOSING_BRACKET(")"),

    COMMA(","),

    LESS_SIGN("<"),

    GREATER_SIGN(">");

    private String name;

    Extra(String value) {
        this.name = value;
    }

    public String value() {
        return name;
    }
}
