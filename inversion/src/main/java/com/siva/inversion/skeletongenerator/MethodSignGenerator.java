package com.siva.inversion.skeletongenerator;

import com.siva.inversion.customexceptions.FailedOperationException;
import com.siva.inversion.utility.Utility;
import com.siva.inversion.constants.Annotations;
import com.siva.inversion.constants.ExceptionsType;
import com.siva.inversion.constants.Names;
import com.siva.inversion.constants.Type;

public class MethodSignGenerator {

    public String methodSignatureGenerator(String methodName, String methodType) throws FailedOperationException {
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

    public String controllerMethodSignature(String methodName) throws FailedOperationException {
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
                        ExceptionsType.MicroServiceException.value() +
                        " {";

        controllerSign = visibility + " " + response + " " + Utility.getNormalName(methodName) + parameters + " " + exception;
        return controllerSign;
    }

    public String facadeMethodSignature(String methodName) throws FailedOperationException {
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

        facadeSign = visibility + " " + response + " " + Utility.getNormalName(methodName) + parameters + " " + exception;
        return facadeSign;
    }

    public String serviceMethodSignature(String methodName) throws FailedOperationException {
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

        serviceSign = visibility + " " + response + " " + Utility.getNormalName(methodName) + parameters + " " + exception;
        return serviceSign;
    }

}


