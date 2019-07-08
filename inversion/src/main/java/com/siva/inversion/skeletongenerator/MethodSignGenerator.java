package com.siva.inversion.skeletongenerator;

import com.siva.inversion.constants.*;
import com.siva.inversion.utility.Utility;

public class MethodSignGenerator {

    public String methodSignatureGenerator(String methodName, String methodType, Boolean isInterface) {
        String sign = "";
        if(!isInterface) {
            sign += Annotations.Override.value();
        }
        sign += "\n";
        switch(methodType){
            case "Payload":
                if(isInterface) {
                    sign += endpointMethodSignature(methodName);
                }
                sign += controllerMethodSignature(methodName,isInterface);
                break;
            case "Facade":
                sign += facadeMethodSignature(methodName,isInterface);
                break;
            case "Service":
                sign += serviceMethodSignature(methodName,isInterface);
                break;
            default:
                //Exception here
                break;
        }

        if(isInterface) {
            sign += Extra.SEMICOLON.value();
        }

        return sign;
    }

    public String controllerMethodSignature(String methodName, Boolean isInterface){
        String controllerSign;
        String visibility;

        if(isInterface){
            visibility = "" ;
        }else{
            visibility = "public" ;
        }
        String response = "ResponseEntity" +
                "<" +
                Utility.getClassName(methodName) +
                Names.Payload.value() +
                Type.Response.value() +
                ">";
        String parameters =
                "(" +
                    Annotations.Valid.value() + " " +
                    Annotations.RequestBody.value() + " " +
                    Utility.getClassName(methodName) +
                    Names.Payload.value() +
                    Type.Request.value() + " " +
                    "request" +
                ")";

        String exception =
                "throws " +
                ExceptionsType.MicroServiceException.value();

        controllerSign = visibility + " " + response + " " + Utility.getNormalName(methodName) + parameters + " " + exception;
        return controllerSign;
    }

    public String facadeMethodSignature(String methodName, Boolean isInterface) {
        String facadeSign;
        String visibility;

        if(isInterface){
            visibility = "" ;
        }else{
            visibility = "public" ;
        }

        String response =
                Utility.getClassName(methodName) +
                Names.Facade.value() +
                Type.Response.value();
        String parameters =
                "(" +
                    Utility.getClassName(methodName) +
                    Names.Facade.value() +
                    Type.Request.value() +
                    " " +
                    "request" +
                ")";

        String exception =
                "throws " +
                ExceptionsType.MicroServiceException.value();

        facadeSign = visibility + " " + response + " " + Utility.getNormalName(methodName) + parameters + " " + exception;
        return facadeSign;
    }

    public String serviceMethodSignature(String methodName, Boolean isInterface) {
        String serviceSign;
        String visibility;

        if(isInterface){
            visibility = "" ;
        }else{
            visibility = "public" ;
        }

        String response =
                Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Response.value()
                ;
        String parameters =
                "(" +
                    Utility.getClassName(methodName) +
                    Names.Service.value() +
                    Type.Request.value() + " " +
                    "request" +
                ")";

        String exception =
                "throws " +
                ExceptionsType.MicroServiceException.value();

        serviceSign = visibility + " " + response + " " + Utility.getNormalName(methodName) + parameters + " " + exception;
        return serviceSign;
    }

    public String endpointMethodSignature(String methodName) {
        String endpointSign;
        endpointSign =
                Annotations.RequestBody.value() +
                Extra.OPENNING_BRACKET.value() +
                    "value = " +
                    "\"" +
                        Utility.getEndpointName(methodName) +
                    "\"" +
                    Extra.COMMA.value() +
                    "method = " +
                        Annotations.RequestMethod.value() +
                        FileExtension.POST.value() +
                Extra.CLOSING_BRACKET.value() +
                Extra.NEW_LINE.value();
        return endpointSign;
    }

}


