package com.siva.inversion.utility;

import com.siva.inversion.customexceptions.ExceptionBuilder;
import com.siva.inversion.customexceptions.FailedOperationException;

public class Utility {
    public static final String stringNullException = "The parameter String is Null or Empty";

    public static String getClassName (String string) {
        try {
            if (string != null && !string.isEmpty()) {
                string = string.substring(0, 1).toUpperCase() + string.substring(1);
            } else {
                throw new FailedOperationException();
            }
        }
        catch(FailedOperationException e){
            ExceptionBuilder.customMessageException(e, stringNullException);

        }
        return string;
    }

    public static String getNormalName (String string) {
        try {
            if (string != null && !string.isEmpty()) {
                string = string.substring(0, 1).toLowerCase() + string.substring(1);
            } else {
                throw new FailedOperationException();
            }
        }
        catch(FailedOperationException e){
            ExceptionBuilder.customMessageException(e, stringNullException);

        }
        return string;
    }

    public static String getGetter(String string) {
        try {
            if (string != null && !string.isEmpty()) {
                string = "get" + string.substring(0, 1).toUpperCase() + string.substring(1);
            } else {
                throw new FailedOperationException();
            }
        } catch (FailedOperationException e) {
            ExceptionBuilder.customMessageException(e, stringNullException);

        }
        return string;
    }

    public static String getSetter(String string) {
        try {
            if (string != null && !string.isEmpty()) {
                string = "set" + string.substring(0, 1).toUpperCase() + string.substring(1);
            } else {
                throw new FailedOperationException();
            }
        } catch (FailedOperationException e) {
            ExceptionBuilder.customMessageException(e, stringNullException);

        }
        return string;
    }
    public static String newLineAndTab(String string){
        try {
            if (string != null && !string.isEmpty()) {
                string += "\n" + "\t";
            } else {
                throw new FailedOperationException();
            }
        }catch (FailedOperationException e){
            ExceptionBuilder.customMessageException(e, stringNullException);
        }

        return string;
    }

    public static String getEndpointName (String string) {
        try {
            if (string != null && !string.isEmpty()) {

                string = Utility.getNormalName(string);

                for(int i = 1; i < string.length(); i++){
                    if(Character.isUpperCase(string.charAt(i))){
                        String temp = string.substring(0, i);
                        string = string.substring(i);
                        string = string.replace(String.valueOf(string.charAt(0)) , "-" + Character.toLowerCase(string.charAt(0)));
                        string = temp + string;
                    }
                }

                string = "/" + string;
            } else {
                throw new FailedOperationException();
            }
        }
        catch(FailedOperationException e){
            ExceptionBuilder.customMessageException(e, stringNullException);

        }
        return string;
    }
}