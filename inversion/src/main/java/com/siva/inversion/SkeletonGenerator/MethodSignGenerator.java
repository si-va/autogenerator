package com.siva.inversion.SkeletonGenerator;

import com.siva.inversion.Utility.Utility;
import com.siva.inversion.SkeletonGenerator.Constants.Annotations;
import com.siva.inversion.SkeletonGenerator.Constants.ExceptionsType;
import com.siva.inversion.SkeletonGenerator.Constants.Names;
import com.siva.inversion.SkeletonGenerator.Constants.Type;

public class MethodSignGenerator {

    public String methodSignatureGenerator(String methodName, String methodType){
        String sign = "";
        sign += Annotations.Override.value();
        sign += "\n";
        switch(methodType){
            case "Payload":
                sign += controllerMethodSignature(methodName);
                break;
            case "Facade":
                sign += facadeMethodSignature(methodName);
                break;
            case "Service":
                sign += serviceMethodSignature(methodName);
                break;
            default:
                //Exception here
                break;
        }

        return sign;
    }

    public String controllerMethodSignature(String methodName){
        String controllerSign;
        String visibility = "public" ;
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
                        ExceptionsType.Exception.value() +
                        " {";

        controllerSign = visibility + " " + response + " " + methodName + parameters + " " + exception;
        return controllerSign;
    }

    public String facadeMethodSignature(String methodName){
        String facadeSign;
        String visibility = "public" ;
        String response =
                Utility.getClassName(methodName) +
                        Names.Facade.value() +
                        Type.Response.value()
                ;
        String parameters =
                "(" +
                        Utility.getClassName(methodName) +
                        Names.Facade.value() +
                        Type.Request.value() + " " +
                        "request" +
                        ")";

        String exception =
                "throws " +
                        ExceptionsType.MicroServiceException.value() +
                        " {";

        facadeSign = visibility + " " + response + " " + methodName + parameters + " " + exception;
        return facadeSign;
    }

    public String serviceMethodSignature(String methodName){
        String serviceSign;
        String visibility = "public" ;
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
                        ExceptionsType.MicroServiceException.value() +
                        " {";

        serviceSign = visibility + " " + response + " " + methodName + parameters + " " + exception;
        return serviceSign;
    }

}


