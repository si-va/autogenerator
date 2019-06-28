package com.siva.inversion.SkeletonGenerator;

import com.siva.inversion.Constants.Type;
import com.siva.inversion.SkeletonGenerator.Skeletons.ControllerMethodSkeletonGenerator;
import com.siva.inversion.SkeletonGenerator.Skeletons.FacadeMethodSkeletonGenerator;
import com.siva.inversion.SkeletonGenerator.Skeletons.ServiceMethodSkeletonGenerator;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class MethodGenerator {

    public static void main(String args[]){
        MethodSignGenerator methodSignGenerator = new MethodSignGenerator();
        ControllerMethodSkeletonGenerator controllerMethodSkeletonGenerator = new ControllerMethodSkeletonGenerator();
        FacadeMethodSkeletonGenerator facadeMethodSkeletonGenerator = new FacadeMethodSkeletonGenerator();
        ServiceMethodSkeletonGenerator serviceMethodSkeletonGenerator = new ServiceMethodSkeletonGenerator();
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Payload"));
        System.out.println(controllerMethodSkeletonGenerator.controllerMethodSkeleton("generateUniqueNumberOtp","Login"));
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Facade"));
        System.out.println(facadeMethodSkeletonGenerator.facadeMethodSkeleton("generateUniqueNumberOtp","Login"));
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Service"));
        System.out.println(serviceMethodSkeletonGenerator.serviceMethodSkeleton("generateUniqueNumberOtp","Login"));
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




