package com.siva.inversion.skeletongenerator;

import com.siva.inversion.constants.Extra;
import com.siva.inversion.constants.Names;
import com.siva.inversion.constants.Type;
import com.siva.inversion.customexceptions.FailedOperationException;
import com.siva.inversion.skeletongenerator.skeletontype.ControllerMethodSkeletonGenerator;
import com.siva.inversion.skeletongenerator.skeletontype.FacadeMethodSkeletonGenerator;
import com.siva.inversion.skeletongenerator.skeletontype.ServiceMethodSkeletonGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MethodGenerator {

    public void skeletonGenerator(String name, String microService) throws FailedOperationException {
        MethodSignGenerator methodSignGenerator = new MethodSignGenerator();
        ControllerMethodSkeletonGenerator controllerMethodSkeletonGenerator = new ControllerMethodSkeletonGenerator();
        FacadeMethodSkeletonGenerator facadeMethodSkeletonGenerator = new FacadeMethodSkeletonGenerator();
        ServiceMethodSkeletonGenerator serviceMethodSkeletonGenerator = new ServiceMethodSkeletonGenerator();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(name));

            String line =
                    methodSignGenerator.methodSignatureGenerator(name , Names.Payload.value()) +
                    Extra.NEW_LINE.value() +
                    controllerMethodSkeletonGenerator.controllerMethodSkeleton(name ,microService) +
                    Extra.NEW_LINE.value() +
                    Extra.NEW_LINE.value() +
                    methodSignGenerator.methodSignatureGenerator(name,Names.Facade.value()) +
                    Extra.NEW_LINE.value() +
                    facadeMethodSkeletonGenerator.facadeMethodSkeleton(name) +
                    Extra.NEW_LINE.value() +
                    Extra.NEW_LINE.value() +
                    methodSignGenerator.methodSignatureGenerator(name, Names.Service.value()) +
                    Extra.NEW_LINE.value() +
                    serviceMethodSkeletonGenerator.serviceMethodSkeleton(name);

            //Writing every element of the String List into the file
            writer.write(line);

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




