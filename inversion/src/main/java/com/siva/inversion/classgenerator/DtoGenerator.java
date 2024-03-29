package com.siva.inversion.classgenerator;

import com.siva.inversion.constants.*;
import com.siva.inversion.customexceptions.FailedOperationException;
import com.siva.inversion.skeletongenerator.MethodGenerator;
import com.siva.inversion.utility.Utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class DtoGenerator{


    private String microServiceName;
    private String serviceName;
    private Map<String, String> requestParameters;
    private Map<String, String> responseParameters;

    private final String directoryName = "Autogenerated";

    public DtoGenerator(String microServiceName, String serviceName, Map<String, String> requestParameters, Map<String, String> responseParameters) {
        this.microServiceName = microServiceName;
        this.serviceName = serviceName;
        this.requestParameters = requestParameters;
        this.responseParameters = responseParameters;
        new File(directoryName).mkdir();

    }

    public void createPayloadRequest() throws IOException {

        String nameOftheClass = serviceName + Names.Payload.value() + Type.Request.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.PAYLOAD_REQUEST.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(requestParameters)
                + generateGettersAndSetters(requestParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        createFile(fileName, line);
    }

    protected StringBuilder extractParameter(Map<String, String> parameters) {
        StringBuilder string = new StringBuilder();
        parameters.entrySet().stream().forEach(item -> {
            string.append(Extra.NEW_LINE.value());
            string.append("\t" + "private ");
            string.append(item.getValue());
            string.append(" ");
            string.append(item.getKey());
            string.append(";");
            string.append(Extra.NEW_LINE.value());
        });
        return string;
    }

    protected StringBuilder generateGettersAndSetters(Map<String, String> parameters) {
        StringBuilder string = new StringBuilder();
        parameters.entrySet().stream().forEach(item -> {
            string.append(Extra.NEW_LINE.value());
            string.append("\t" + "public ");
            string.append(item.getValue());
            string.append(" ");
            string.append(Utility.getGetter(item.getKey()));
            string.append("(){ return " + item.getKey() + "; }");

            string.append(Extra.NEW_LINE.value());
            string.append(Extra.NEW_LINE.value());
            string.append("\t" + "public ");
            string.append("void");
            string.append(" ");
            string.append(Utility.getSetter(item.getKey()));
            string.append("(" + item.getValue() + " " + item.getKey() + "){" + "this." + item.getKey() + "=" + item.getKey() + "; }");
            string.append(Extra.NEW_LINE.value());
        });
        return string;
    }
    public void createPayloadResponse() throws IOException {

        String nameOftheClass = serviceName + Names.Payload.value() + Type.Response.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.PAYLOAD_RESPONSE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(responseParameters)
                + generateGettersAndSetters(responseParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();

        createFile(fileName, line);
    }

    public void createFacadeRequest() throws IOException {

        String nameOftheClass = serviceName + Names.Facade.value() + Type.Request.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+BaseClasses.FACADE_REQUEST.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(requestParameters)
                + generateGettersAndSetters(requestParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        createFile(fileName, line);
    }

    public void createFacadeResponse() throws IOException {

        String nameOftheClass = serviceName + Names.Facade.value() + Type.Response.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.FACADE_RESPONSE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(responseParameters)
                + generateGettersAndSetters(responseParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();

        createFile(fileName, line);
    }

    public void createServiceRequest() throws IOException {

        String nameOftheClass = serviceName + Names.Service.value() + Type.Request.value();
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+BaseClasses.SERVICE_REQUEST.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(requestParameters)
                + generateGettersAndSetters(requestParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        createFile(fileName, line);
    }

    public void createServiceResponse() throws IOException {

        String nameOftheClass = serviceName + Names.Service.value() + Type.Response.value();
        String fileName = directoryName + "//" + nameOftheClass  + FileExtension.FILE_EXTENSION.value();
        String line = Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.SERVICE_RESPONSE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(responseParameters)
                + generateGettersAndSetters(responseParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        createFile(fileName, line);
    }

    public void createResponseMapper() throws IOException {

        String nameOftheClass = serviceName + Names.Payload.value() + Type.Response.value()+"From"+Names.Facade.value()+"Mapper";
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Annotations.COMPONENT.value() + Extra.OPENNING_BRACKET.value()
                + "\""+ nameOftheClass + "\""
                + Extra.CLOSING_BRACKET.value()
                + Extra.NEW_LINE.value()
                + Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ BaseClasses.PAYLOAD_RESPONSE_MAPPER.value()
                + Extra.LESS_SIGN.value() + serviceName + Names.Facade.value() + Type.Response.value()
                + Extra.COMMA.value() + serviceName + Names.Payload.value() + Type.Response.value()
                + Extra.GREATER_SIGN.value()
                + Extra.NEW_LINE.value()
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(responseParameters)
                + generateGettersAndSetters(responseParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


            createFile(fileName, line);

    }

    public void createRestRequestService() throws IOException {

        String nameOftheClass = serviceName + "RestServiceRequest";
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.NEW_LINE.value()
                + Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ "BaseMicroSoaRestServiceRequest"
                + " "
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(requestParameters)
                + generateGettersAndSetters(requestParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        createFile(fileName, line);

    }

    public void createRestResponseService() throws IOException {

        String nameOftheClass = serviceName + "RestServiceResponse";
        String fileName = directoryName + "//" + nameOftheClass + FileExtension.FILE_EXTENSION.value();
        String line = Extra.NEW_LINE.value()
                + Extra.PUBLIC_CLASS.value()+" "+nameOftheClass + " "
                + Extra.EXTENDS.value() + " "+ "BaseMicroSoaRestServiceResponse"
                + " "
                + Extra.OPENING_PARANETHESIS.value()
                + Extra.NEW_LINE.value()
                + extractParameter(responseParameters)
                + generateGettersAndSetters(responseParameters)
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.NEW_LINE.value()
                + Extra.CLOSING_PARANETHESIS.value();


        createFile(fileName, line);

    }
    protected void createFile(String fileName, String line) throws IOException {
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

    public void create() throws IOException, FailedOperationException {
        createPayloadRequest();
        createPayloadResponse();
        createFacadeRequest();
        createFacadeResponse();
        createServiceRequest();
        createServiceResponse();
        createResponseMapper();
        createRestRequestService();
        createRestResponseService();
        MethodGenerator.skeletonGenerator(directoryName, serviceName, microServiceName);
        MethodGenerator.interfaceGenerator(directoryName, serviceName, microServiceName);
    }
}
