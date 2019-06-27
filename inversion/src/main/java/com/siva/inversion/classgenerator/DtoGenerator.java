package com.siva.inversion.classgenerator;

import com.siva.inversion.classgenerator.constants.BaseClasses;
import com.siva.inversion.classgenerator.constants.Extra;
import com.siva.inversion.classgenerator.constants.FileExtension;
import com.siva.inversion.skeletonGenerator.Constants.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DtoGenerator{


    private String serviceName;


    private final String directoryName = "Autogenerated";
    public DtoGenerator(String serviceName){
        this.serviceName = serviceName;
        new File(directoryName).mkdir();
    }

    public void createPayloadRequest() throws IOException {

        String nameOftheClass = serviceName + Names.Controller.value() + Type.Request.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.PAYLOAD_REQUEST.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }

    public void createPayloadResponse() throws IOException {

        String nameOftheClass = serviceName + Names.Controller.value() + Type.Response.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.PAYLOAD_RESPONSE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();

        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }

    public void createFacadeRequest() throws IOException {

        String nameOftheClass = serviceName + Names.Facade.value() + Type.Request.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+BaseClasses.FACADE_REQUEST.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }

    public void createFacadeResponse() throws IOException {

        String nameOftheClass = serviceName + Names.Facade.value() + Type.Response.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.FACADE_RESPONSE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();

        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }

    public void createServiceRequest() throws IOException {

        String nameOftheClass = serviceName + Names.Service.value() + Type.Request.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+BaseClasses.SERVICE_REQUEST.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }

    public void createServiceResponse() throws IOException {

        String nameOftheClass = serviceName + Names.Service.value() + Type.Response.value();
        String fileName = directoryName + "//" + nameOftheClass  + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.SERVICE_RESPONSE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }

    public void createResponseMapper() throws IOException {

        String nameOftheClass = serviceName + Names.Controller.value() + Type.Response.value()+"From"+Names.Facade.value()+"Mapper";
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Annotations.COMPONENT.value() + Extra.OPENNING_BRACKET.value()
                + "\""+ nameOftheClass + "\""
                + Extra.CLOSING_BRACKET.value()
                + Extra.NEW_LINE.value()
                + Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.PAYLOAD_RESPONSE_MAPPER.value()
                + Extra.LESS_SIGN.value() + serviceName + Names.Facade.value() + Type.Response.value()
                + Extra.COMMA.value() + serviceName + Names.Controller.value() + Type.Response.value()
                + Extra.CLOSING_BRACKET.value()
                + Extra.NEW_LINE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        File file = new File(fileName);
        //Create the file
        if (file.createNewFile())
        {
            System.out.println("Class is created!");
        } else {
            System.out.println("Class already exists.");
        }
        FileWriter writer = new FileWriter(file);
        writer.write(line);
        writer.close();
    }


    public void create() throws IOException {
        createPayloadRequest();
        createPayloadResponse();
        createFacadeRequest();
        createFacadeResponse();
        createServiceRequest();
        createServiceResponse();
        createResponseMapper();
    }
}
