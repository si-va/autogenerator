package com.siva.inversion.skeletongenerator.skeletontype;

import com.siva.inversion.utility.Utility;
import com.siva.inversion.constants.Names;
import com.siva.inversion.constants.Type;

import javax.rmi.CORBA.Util;

public class ControllerMethodSkeletonGenerator {
    public String controllerMethodSkeleton(String methodName, String microServiceName){
        String skeleton = "\t";
        skeleton +=
                microServiceClassInit(microServiceName) +
                Utility.newLineAndTab(skeleton) +
                facadeRequestInit(methodName) +
                Utility.newLineAndTab(skeleton) +
                facadeResponseInit(methodName,microServiceName) +
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
                Utility.getNormalName(microServiceName) +
                Names.Facade.value();
        String methodCall = "adapterFactory.getSpecificAdapterFromDefault";
        String parameter =
                "(" +
                Utility.getClassName(microServiceName) +
                Names.Facade.value() +
                "Default" +
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
                Utility.getNormalName(methodName) +
                Names.Facade.value() +
                Type.Request.value();
        String methodCall = "generateFacadeRequest";
        String parameter =
                "(" +
                    "request," +
                    Utility.getClassName(methodName) +
                    Names.Facade.value() +
                    Type.Request.value() +
                    ".class" +
                ");";
        instruction = facadeRequestClass + " " + facadeRequestName + " = " + methodCall + parameter;
        return instruction;
    }

    String facadeResponseInit (String methodName, String microServiceName){
        String instruction = "";
        String facadeResponseClass =
                Utility.getClassName(methodName) +
                Names.Facade.value() +
                Type.Response.value();
        String facadeResponseName =
                Utility.getNormalName(methodName) +
                Names.Facade.value() +
                Type.Response.value();
        String methodCall =
                Utility.getNormalName(microServiceName) +
                Names.Facade.value() +
                "." +
                Utility.getNormalName(methodName);
        String parameter =
                "(" +
                        Utility.getNormalName(methodName) +
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
                Names.FromFacadeMapper.value();
        String mapperName =
                Utility.getNormalName(methodName) +
                Names.Mapper.value();
        String methodCall =
                "adapterFactory.getSpecificAdapterFromDefault";
        String parameter =
                "(" +
                        Utility.getClassName(methodName) +
                        Names.Payload +
                        Type.Response.value() +
                        Names.FromFacadeMapper.value() +
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
                Utility.getNormalName(methodName) +
                Names.Payload.value() +
                Type.Response.value();
        String methodCall =
                Utility.getNormalName(methodName) +
                Names.Mapper.value() +
                "." +
                "map";
        String parameter =
                "(" +
                    Utility.getNormalName(methodName) +
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
                "generate" +
                Names.Controller.value() +
                Type.Response.value();
        String parameter =
                "(" +
                        Utility.getNormalName(methodName) +
                        Names.Payload.value() +
                        Type.Response.value() +
                        "," +
                        "HttpStatus.OK" +
                ");";
        instruction = returnWord + " " + methodCall + parameter;
        return instruction;
    }
}
