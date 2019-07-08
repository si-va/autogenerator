package com.siva.inversion.skeletongenerator.skeletontype;

import com.siva.inversion.constants.Extra;
import com.siva.inversion.constants.Names;
import com.siva.inversion.constants.Type;
import com.siva.inversion.utility.Utility;

public class ServiceMethodSkeletonGenerator {

    public String serviceMethodSkeleton(String methodName){
        String skeleton = Extra.TAB.value();
        skeleton +=
            serviceResponseInit(methodName) +
            Utility.newLineAndTab(skeleton) +
            "//Logic Here" +
            Utility.newLineAndTab(skeleton) +
            returnStatement(methodName) +
            Extra.NEW_LINE.value();
        return skeleton;
    }

    String serviceResponseInit (String methodName){
        String instruction;
        String facadeResponseClass =
                Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Response.value();
        String facadeResponseName =
                Utility.getNormalName(methodName) +
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
                Utility.getNormalName(methodName) +
                        Names.Service.value() +
                        Type.Response.value();
        instruction = returnWord + " " + methodCall;
        return instruction;
    }
}
