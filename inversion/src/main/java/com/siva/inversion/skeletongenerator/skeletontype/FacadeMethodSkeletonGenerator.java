package com.siva.inversion.skeletongenerator.skeletontype;

import com.siva.inversion.constants.Extra;
import com.siva.inversion.constants.FileExtension;
import com.siva.inversion.utility.Utility;
import com.siva.inversion.constants.Names;
import com.siva.inversion.constants.Type;

public class FacadeMethodSkeletonGenerator {
    public String facadeMethodSkeleton(String methodName, String microService){
        String skeleton = "\t";
        skeleton +=
            serviceRequestInit(methodName) +
            Utility.newLineAndTab(skeleton) +
            serviceResponseInit(methodName, microService) +
            Utility.newLineAndTab(skeleton) +
            facadeResponseInit(methodName) +
            Utility.newLineAndTab(skeleton) +
            returnStatement(methodName) +
            "\n}";
        return skeleton;
    }

    String serviceRequestInit (String methodName){
        String instruction = "";
        String facadeRequestClass =
                Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Request.value();
        String facadeRequestName =
                Utility.getNormalName(methodName) +
                        Names.Service.value() +
                        Type.Request.value();
        String methodCall = "generateServiceRequest";
        String parameter =
                "(" +
                        "request," +
                        Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Request +
                        ".class" +
                        ");";
        instruction = facadeRequestClass + " " + facadeRequestName + " = " + methodCall + parameter;
        return instruction;
    }

    String serviceResponseInit (String methodName, String microService){
        String instruction = "";
        String facadeResponseClass =
                Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Response.value();
        String facadeResponseName =
                Utility.getNormalName(methodName) +
                        Names.Service.value() +
                        Type.Response.value();
        String methodCall =
                Utility.getNormalName(microService) +
                        Names.Service.value() +
                        "." +
                        Utility.getNormalName(methodName);
        String parameter =
                "(" +
                        Utility.getNormalName(methodName) +
                        Names.Service.value() +
                        Type.Request.value() +
                        ");";
        instruction = facadeResponseClass + " " + facadeResponseName + " = " + methodCall + parameter;
        return instruction;
    }

    String facadeResponseInit (String methodName){
        String instruction;
        String payloadResponseClass =
                Utility.getClassName(methodName) +
                        Names.Facade.value() +
                        Type.Response.value();
        String payloadResponseName =
                Utility.getNormalName(methodName) +
                        Names.Facade.value() +
                        Type.Response.value();
        String methodCall =
                Utility.getNormalName(methodName) +
                        "generateFacadeResponse";
        String parameter =
                "(" +
                        Utility.getClassName(methodName) +
                        Names.Facade.value() +
                        Type.Response.value() +
                        FileExtension.DOT_CLASS +
                        Extra.COMMA +
                        Utility.getNormalName(Type.Request.value()) +
                        ");";
        instruction = payloadResponseClass + " " + payloadResponseName + " = " + methodCall + parameter;
        return instruction;
    }

    String returnStatement (String methodName){
        String instruction = "";
        String returnWord = "return";
        String methodCall =
                Utility.getNormalName(methodName) +
                        Names.Facade.value() +
                        Type.Response.value();
        instruction = returnWord + " " + methodCall;
        return instruction;
    }
}

