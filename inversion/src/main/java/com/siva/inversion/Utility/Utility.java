package com.siva.inversion.Utility;

public class Utility {

    public static String getClassName (String string){
        if(string != null && !string.isEmpty()) {
            string = string.substring(0,1).toUpperCase() + string.substring(1);
        }
        return string;
    }
}