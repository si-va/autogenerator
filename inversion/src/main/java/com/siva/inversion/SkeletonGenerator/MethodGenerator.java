package com.siva.inversion.SkeletonGenerator;

import com.siva.inversion.Constants.Type;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class MethodGenerator {

    public static void main(String args[]){
        MethodSignGenerator methodSignGenerator = new MethodSignGenerator();
        ControllerMethodSkeletonGenerator controllerMethodSkeletonGenerator = new ControllerMethodSkeletonGenerator();
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Payload"));
        System.out.println(controllerMethodSkeletonGenerator.controllerMethodSkeleton("generateUniqueNumberOtp","Login"));
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Facade"));
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Service"));
    }

    public void skeletonGenerator(String name){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name + Type.Implementation.value()));

            //Writing every element of the String List into the file
            writer.write("asd" + "\n");

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
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




