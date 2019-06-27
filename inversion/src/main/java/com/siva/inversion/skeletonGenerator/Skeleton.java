package com.siva.inversion.skeletonGenerator;

import com.siva.inversion.Utility.Utility;
import com.siva.inversion.skeletonGenerator.Constants.Annotations;
import com.siva.inversion.skeletonGenerator.Constants.ExceptionsType;
import com.siva.inversion.skeletonGenerator.Constants.Names;
import com.siva.inversion.skeletonGenerator.Constants.Type;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class Skeleton{

    public static void main(String args[]){
        MethodSignGenerator methodSignGenerator = new MethodSignGenerator();
        System.out.println(methodSignGenerator.methodSignatureGenerator("generateUniqueNumberOtp","Controller"));
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

/*
 @Override
    public ResponseEntity<GenerateUniqueNumberOtpPayloadResponse> generateUniqueNumberOtp(@Valid @RequestBody GenerateUniqueNumberOtpPayloadRequest request) throws Exception {
        GenerateUniqueNumberOtpFacadeRequest generateUniqueNumberOtpFacadeRequest = generateFacadeRequest(request,GenerateUniqueNumberOtpFacadeRequest.class);

        LoginFacade loginFacade = adapterFactory.getSpecificAdapterFromDefault(LoginFacadeDefault.class);

        GenerateUniqueNumberOtpFacadeResponse generateUniqueNumberOtpFacadeResponse = loginFacade.generateUniqueNumberOtp(generateUniqueNumberOtpFacadeRequest);

        GenerateUniqueNumberOtpResponseMapper responseMapper = adapterFactory.getSpecificAdapterFromDefault(GenerateUniqueNumberOtpResponseMapper.class);
        responseMapper.saveInSession(generateUniqueNumberOtpFacadeResponse);

        GenerateUniqueNumberOtpPayloadResponse responsePayload = responseMapper.map(generateUniqueNumberOtpFacadeResponse);

        return generateControllerResponse(responsePayload, HttpStatus.OK);
    }
 */

