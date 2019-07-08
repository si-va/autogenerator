package com.siva.inversion.skeletongenerator;

import com.siva.inversion.constants.Extra;
import com.siva.inversion.constants.FileExtension;
import com.siva.inversion.constants.Names;
import com.siva.inversion.customexceptions.FailedOperationException;
import com.siva.inversion.skeletongenerator.skeletontype.ControllerMethodSkeletonGenerator;
import com.siva.inversion.skeletongenerator.skeletontype.FacadeMethodSkeletonGenerator;
import com.siva.inversion.skeletongenerator.skeletontype.ServiceMethodSkeletonGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MethodGenerator {

    public static void skeletonGenerator(String directoryName, String name, String microService) throws FailedOperationException {
        MethodSignGenerator methodSignGenerator = new MethodSignGenerator();
        ControllerMethodSkeletonGenerator controllerMethodSkeletonGenerator = new ControllerMethodSkeletonGenerator();
        FacadeMethodSkeletonGenerator facadeMethodSkeletonGenerator = new FacadeMethodSkeletonGenerator();
        ServiceMethodSkeletonGenerator serviceMethodSkeletonGenerator = new ServiceMethodSkeletonGenerator();

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(directoryName+"//"+name+ "Impl" + FileExtension.FILE_EXTENSION.value()));

            String line =
                    "//CONTROLLER" +
                    Extra.NEW_LINE.value() +
                    methodSignGenerator.methodSignatureGenerator(name , Names.Payload.value(),false) +
                    Extra.OPENING_PARANETHESIS.value() +
                    Extra.NEW_LINE.value() +
                    controllerMethodSkeletonGenerator.controllerMethodSkeleton(name ,microService) +
                    Extra.CLOSING_PARANETHESIS.value() +
                    Extra.NEW_LINE.value() +
                    "//FACADE" +
                    Extra.NEW_LINE.value() +
                    methodSignGenerator.methodSignatureGenerator(name,Names.Facade.value(), false) +
                    Extra.OPENING_PARANETHESIS.value() +
                    Extra.NEW_LINE.value() +
                    facadeMethodSkeletonGenerator.facadeMethodSkeleton(name, microService) +
                    Extra.CLOSING_PARANETHESIS.value() +
                    Extra.NEW_LINE.value() +
                    "//SERVICE" +
                    Extra.NEW_LINE.value() +
                    methodSignGenerator.methodSignatureGenerator(name, Names.Service.value(), false) +
                    Extra.OPENING_PARANETHESIS.value() +
                    Extra.NEW_LINE.value() +
                    serviceMethodSkeletonGenerator.serviceMethodSkeleton(name) +
                    Extra.CLOSING_PARANETHESIS.value();
            writer.write(line);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void interfaceGenerator(String directoryName, String name, String microService) {
        MethodSignGenerator methodSignGenerator = new MethodSignGenerator();

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(directoryName+"//"+name+ "Interface" + FileExtension.FILE_EXTENSION.value()));

            String line =
                    "//CONTROLLER" +
                    methodSignGenerator.methodSignatureGenerator(name , Names.Payload.value(),true) +
                    Extra.NEW_LINE.value() +
                    "//FACADE" +
                    methodSignGenerator.methodSignatureGenerator(name,Names.Facade.value(), true) +
                    Extra.NEW_LINE.value() +
                    "//SERVICE" +
                    methodSignGenerator.methodSignatureGenerator(name, Names.Service.value(), true) +
                    Extra.NEW_LINE.value();
            //Writing every element of the String List into the file
            writer.write(line);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


