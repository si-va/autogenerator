package com.siva.inversion.Utility;

import com.siva.inversion.CustomException.ExceptionBuilder;
import com.siva.inversion.CustomException.FailedOperationException;

public class Utility {
    public static final String stringNullException = "The parameter String is Null or Empty";

    public static String getClassName (String string){
        if(string != null && !string.isEmpty()) {
            string = string.substring(0,1).toUpperCase() + string.substring(1);
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
}