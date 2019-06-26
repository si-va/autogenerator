package com.siva.inversion.createfiles;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateClasses {

    private String className;

    //EnrollPayloadResponseFromFacadeMapper

    //All dtos
    private String payloadRequestFileName;
    private String payloadResponseFileName;
    private String facadeRequestFileName;
    private String facadeResponseFileName;
    private String serviceRequestFileName;
    private String serviceResponseFileName;
    private String responseMapper;

    //all methods
    private String controllerLayer;
    private String facadeLayer;
    private String serviceLayer;

    //Layers name
    private final String payloadRequest="PayloadRequest";
    private final String payloadResponse = "PayloadResponse";
    private final String facadeRequest = "FacadeRequest";
    private final String facadeResponse = "FacadeResponse";
    private final String serviceRequest = "ServiceRequest";
    private final String serviceResponse = "ServiceResponse";
    private final String facadeMapper = "FromFacadeMapper";


    //Create all the files
    public CreateClasses(String name){
        className= name;

        //All dtos
        payloadRequestFileName = "D:\\test\\"+className+payloadRequest+".java";
        payloadResponseFileName = "D:\\test\\"+className+payloadResponse+".java";
        facadeRequestFileName = "D:\\test\\"+className+facadeRequest+".java";
        facadeResponseFileName = "D:\\test\\"+className+facadeResponse+".java";
        serviceRequestFileName = "D:\\test\\"+className+serviceRequest+".java";
        serviceResponseFileName = "D:\\test\\"+className+serviceResponse+".java";

        //Response Mapper
        responseMapper = "D:\\test\\"+className+payloadResponse+facadeMapper+".java";




        controllerLayer = "D:\\test\\"+className+serviceRequest+".java";
    }



    public void createPayloadRequest() throws IOException {

        String tempClassName = className+payloadRequest;
        File file = new File(payloadRequestFileName);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }


        FileWriter writer = new FileWriter(file);
        writer.write("public class "+tempClassName+" extends NexiBasePayloadRequest"+"{\n \n \n \n \n \n  }");
        writer.close();
    }
    public void createPayloadResponse() throws IOException {

        String tempClassName = className+payloadResponse;
        File file = new File(payloadResponseFileName);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("public class "+tempClassName+" extends NexiBasePayloadResponse"+"{ \n \n \n \n \n \n }");
        writer.close();
    }

    public void createFacadeRequest() throws IOException {

        String tempClassName = className+facadeRequest;
        File file = new File(facadeRequestFileName);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("public class "+tempClassName+" extends NexiBaseFacadeRequest"+"{\n \n \n \n \n \n}");
        writer.close();
    }

    public void createFacadeResponse() throws IOException {

        String tempClassName = className+facadeResponse;
        File file = new File(facadeResponseFileName);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("public class "+tempClassName+" extends NexiBaseFacadeResponse"+"{\n \n \n \n \n \n}");
        writer.close();
    }

    public void createServiceRequest() throws IOException {

        String tempClassName = className+serviceRequest;
        File file = new File(serviceRequestFileName);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("public class "+tempClassName+"extends NexiBaseServiceRequest"+"{\n \n \n \n \n \n}");
        writer.close();
    }

    public void createServiceResponse() throws IOException {

        String tempClassName = className+ serviceResponse;
        File file = new File(serviceResponseFileName);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }

        FileWriter writer = new FileWriter(file);
        writer.write("public class "+tempClassName+"extends NexiBaseServiceResponse"+"{\n \n \n \n \n \n}");
        writer.close();
    }

    public void createFacadeResponseMapper() throws IOException {
        final String facadeMapperclassName=className+payloadResponse+facadeMapper;
        final String tempFacadeResponse = className+facadeResponse;
        final String tempPayloadResponse = className+payloadResponse;

        File file = new File(responseMapper);

        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }

        FileWriter writer = new FileWriter(file);

        writer.write("@Component(\""+facadeMapperclassName+"\")\npublic class "+facadeMapperclassName+" extends "+"PayloadResponseMapper<"+tempFacadeResponse+","+tempPayloadResponse+">"+"{\n \n \n \n \n \n}");
        writer.close();
    }

    public void create() throws IOException {
        this.createPayloadRequest();
        this.createPayloadResponse();
        this.createFacadeRequest();
        this.createFacadeResponse();
        this.createServiceRequest();
        this.createServiceResponse();
        this.createFacadeResponseMapper();
    }

}
