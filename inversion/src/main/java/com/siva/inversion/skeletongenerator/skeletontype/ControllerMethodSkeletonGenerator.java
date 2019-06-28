package com.siva.inversion.skeletongenerator.skeletontype;

import com.siva.inversion.utility.Utility;
import com.siva.inversion.constants.Names;
import com.siva.inversion.constants.Type;

public class ControllerMethodSkeletonGenerator {
    public String controllerMethodSkeleton(String methodName, String microServiceName){
        String skeleton = "\t";
        skeleton +=
                microServiceClassInit(microServiceName) +
                Utility.newLineAndTab(skeleton) +
                facadeRequestInit(methodName) +
                Utility.newLineAndTab(skeleton) +
                facadeResponseInit(methodName) +
                Utility.newLineAndTab(skeleton) +
                responseMapperInit(methodName) +
                Utility.newLineAndTab(skeleton) +
                controllerResponseInit(methodName) +
                Utility.newLineAndTab(skeleton) +
                returnStatement(methodName) +
                "\n}";
        return skeleton;
    }

    String microServiceClassInit (String microServiceName){
        String instruction = "";
        String microServiceClass =
                Utility.getClassName(microServiceName) +
                Names.Facade.value();
        String microServiceClassName =
                microServiceName +
                Names.Facade.value();
        String methodCall = "adapterFactory.getSpecificAdapterFromDefault";
        String parameter =
                "(" +
                Utility.getClassName(microServiceName) +
                ".class" +
                ");";
        instruction = microServiceClass + " " + microServiceClassName + " = " + methodCall + parameter;
        return instruction;
    }

    String facadeRequestInit (String methodName){
        String instruction = "";
        String facadeRequestClass =
                Utility.getClassName(methodName) +
                Names.Facade.value() +
                Type.Request.value();
        String facadeRequestName =
                methodName +
                Names.Facade.value() +
                Type.Request.value();
        String methodCall = "generateFacadeRequest";
        String parameter =
                "(" +
                    "request," +
                    Utility.getClassName(methodName) +
                    ".class" +
                ");";
        instruction = facadeRequestClass + " " + facadeRequestName + " = " + methodCall + parameter;
        return instruction;
    }

    String facadeResponseInit (String methodName){
        String instruction = "";
        String facadeResponseClass =
                Utility.getClassName(methodName) +
                Names.Facade.value() +
                Type.Response.value();
        String facadeResponseName =
                methodName +
                Names.Facade.value() +
                Type.Response.value();
        String methodCall =
                methodName +
                Names.Facade.value() +
                "." +
                methodName;
        String parameter =
                "(" +
                        methodName +
                        Names.Facade.value() +
                        Type.Request.value() +
                ");";
        instruction = facadeResponseClass + " " + facadeResponseName + " = " + methodCall + parameter;
        return instruction;
    }

    String responseMapperInit (String methodName){
        String instruction = "";
        String mapperClass =
                Utility.getClassName(methodName) +
                Type.Response.value() +
                Names.Mapper.value();
        String mapperName =
                methodName +
                Names.Mapper.value();
        String methodCall =
                "adapterFactory.getSpecificAdapterFromDefault";
        String parameter =
                "(" +
                        Utility.getClassName(methodName) +
                        Type.Response.value() +
                        Names.Mapper.value() +
                        ".class" +
                ");";
        instruction = mapperClass + " " + mapperName + " = " + methodCall + parameter;
        return instruction;
    }

    String controllerResponseInit (String methodName){
        String instruction = "";
        String payloadResponseClass =
                Utility.getClassName(methodName) +
                Names.Payload.value() +
                Type.Response.value();
        String payloadResponseName =
                methodName +
                Names.Payload.value() +
                Type.Response.value();
        String methodCall =
                methodName +
                Names.Mapper.value() +
                "." +
                "map";
        String parameter =
                "(" +
                    methodName +
                    Names.Facade.value() +
                    Type.Response.value() +
                ");";
        instruction = payloadResponseClass + " " + payloadResponseName + " = " + methodCall + parameter;
        return instruction;
    }

    String returnStatement (String methodName){
        String instruction = "";
        String returnWord = "return";
        String methodCall =
                methodName +
                Names.Controller.value() +
                Type.Response.value();
        String parameter =
                "(" +
                        methodName +
                        Names.Payload.value() +
                        Type.Response.value() +
                        "," +
                        "HttpStatus.OK" +
                ");";
        instruction = returnWord + " " + methodCall + parameter;
        return instruction;
    }
}
