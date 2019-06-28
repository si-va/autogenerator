package com.siva.inversion.SkeletonGenerator.Skeletons;

import com.siva.inversion.Utility.Utility;
import com.siva.inversion.Constants.Names;
import com.siva.inversion.Constants.Type;

public class FacadeMethodSkeletonGenerator {
    public String facadeMethodSkeleton(String methodName, String microServiceName){
        String skeleton = "\t";
        skeleton +=
            serviceRequestInit(methodName) +
            Utility.newLineAndTab(skeleton) +
            serviceResponseInit(methodName) +
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
                methodName +
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

    String serviceResponseInit (String methodName){
        String instruction = "";
        String facadeResponseClass =
                Utility.getClassName(methodName) +
                        Names.Service.value() +
                        Type.Response.value();
        String facadeResponseName =
                methodName +
                        Names.Service.value() +
                        Type.Response.value();
        String methodCall =
                methodName +
                        Names.Service.value() +
                        "." +
                        methodName;
        String parameter =
                "(" +
                        methodName +
                        Names.Service.value() +
                        Type.Request.value() +
                        ");";
        instruction = facadeResponseClass + " " + facadeResponseName + " = " + methodCall + parameter;
        return instruction;
    }

    String facadeResponseInit (String methodName){
        String instruction = "";
        String payloadResponseClass =
                Utility.getClassName(methodName) +
                        Names.Facade.value() +
                        Type.Response.value();
        String payloadResponseName =
                methodName +
                        Names.Facade.value() +
                        Type.Response.value();
        String methodCall =
                methodName +
                        "generateFacadeResponse";
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
                        Names.Facade.value() +
                        Type.Response.value();
        instruction = returnWord + " " + methodCall;
        return instruction;
    }
}

/*
    @Override
    public GenerateUniqueNumberOtpFacadeResponse generateUniqueNumberOtp(GenerateUniqueNumberOtpFacadeRequest request) throws MicroServiceException {
        //Generating OTP
        GenerateUniqueOtpServiceRequest generateUniqueOtpServiceRequest = generateServiceRequest(request, GenerateUniqueOtpServiceRequest.class);

        loginService.generateUniqueNumberOtp(generateUniqueOtpServiceRequest);

        GenerateUniqueNumberOtpFacadeResponse generateUniqueNumberOtpFacadeResponse = generateFacadeResponse(GenerateUniqueNumberOtpFacadeResponse.class, request);

        return generateUniqueNumberOtpFacadeResponse;
    }
 */

