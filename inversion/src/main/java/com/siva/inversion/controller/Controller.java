package com.siva.inversion.controller;


import com.siva.inversion.customexceptions.FailedOperationException;
import com.siva.inversion.utility.Utility;
import com.siva.inversion.classgenerator.DtoGenerator;
import com.siva.inversion.classgenerator.dto.request.ServiceRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @RequestMapping(value = "generate", method = {RequestMethod.POST})

    public String create(@RequestBody ServiceRequest serviceRequest) throws Exception, FailedOperationException {

        String microServiceName = Utility.getClassName(serviceRequest.getMicroServiceName());
        String serviceName = Utility.getClassName(serviceRequest.getServiceName());
        Map<String, String> paramters = serviceRequest.getParamters();
        DtoGenerator dtoGenerator = new DtoGenerator(microServiceName,serviceName);
        dtoGenerator.create();
    return "Created";
    }
}
