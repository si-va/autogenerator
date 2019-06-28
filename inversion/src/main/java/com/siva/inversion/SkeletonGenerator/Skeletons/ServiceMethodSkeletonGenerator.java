package com.siva.inversion.SkeletonGenerator.Skeletons;

import com.siva.inversion.Constants.Names;
import com.siva.inversion.Constants.Type;
import com.siva.inversion.Utility.Utility;

public class ServiceMethodSkeletonGenerator {

    public String serviceMethodSkeleton(String methodName, String microServiceName){
        String skeleton = "\t";
        skeleton +=
                serviceResponseInit(methodName) +
                Utility.newLineAndTab(skeleton) +
                "//Logic Here" +
                Utility.newLineAndTab(skeleton) +
                returnStatement(methodName) +
                "\n}";
        return skeleton;
    }

    String serviceResponseInit (String methodName){
        String instruction;
        String facadeResponseClass =
                Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Response.value();
        String facadeResponseName =
                methodName +
                        Names.Service.value() +
                        Type.Response.value();
        String methodCall =
                "generateServiceResponse";
        String parameter =
                "(" +
                        Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Response.value() +
                        ".class" +
                        "," +
                        "request" +
                        ");";
        instruction = facadeResponseClass + " " + facadeResponseName + " = " + methodCall + parameter;
        return instruction;
    }

    String returnStatement (String methodName){
        String instruction;
        String returnWord = "return";
        String methodCall =
                methodName +
                        Names.Facade.value() +
                        Type.Response.value();
        instruction = returnWord + " " + methodCall;
        return instruction;
    }
}
