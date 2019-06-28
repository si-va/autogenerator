package com.siva.inversion.customexceptions;

public class ExceptionBuilder {
    //Colors
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";


    public static void customMessageException(Throwable e, String message){
        System.out.println("\n" + ANSI_YELLOW + message + ANSI_RESET);
        e.printStackTrace();
        System.exit(1);
    }


}



