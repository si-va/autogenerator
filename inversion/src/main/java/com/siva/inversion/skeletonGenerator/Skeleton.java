package com.siva.inversion.skeletonGenerator;

import com.siva.inversion.Utility.Utility;
import com.siva.inversion.skeletonGenerator.Constants.Annotations;
import com.siva.inversion.skeletonGenerator.Constants.Names;
import com.siva.inversion.skeletonGenerator.Constants.Type;


import java.io.BufferedWriter;
import java.io.FileWriter;

public class Skeleton{

    public static void main(String args[]){
        Skeleton skeleton = new Skeleton();
        System.out.println(skeleton.methodSignatureGenerator("generateUniqueNumberOtp"));
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

    public String methodSignatureGenerator(String methodName){
       String controllerImpl;
       String visibility = "public" ;
       String response = "ResponseEntity" +
               "<" +
                   Utility.getClassName(methodName) +
                   Names.Controller.value() +
                   Type.Response.value() +
               ">";
       String parameters =
               "(" +
                   Annotations.Valid.value() + " " +
                   Annotations.RequestBody.value() + " " +
                   Utility.getClassName(methodName) +
                   Names.Controller.value() +
                   Type.Request.value() + " " +
                   "request" +
               ")";

       String exception = "throws Exception {";

       controllerImpl = visibility + " " + response + " " + methodName + parameters + " " + exception;
       return controllerImpl;
    }

}

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