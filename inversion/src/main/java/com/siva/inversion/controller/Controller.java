package com.siva.inversion.controller;


import com.siva.inversion.CustomException.FailedOperationException;
import com.siva.inversion.Utility.Utility;
import com.siva.inversion.classgenerator.DtoGenerator;
import com.siva.inversion.classgenerator.dto.request.ServiceRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "generate", method = {RequestMethod.POST})
    public String create(@RequestBody ServiceRequest serviceRequest) throws Exception, FailedOperationException {

        DtoGenerator dtoGenerator = new DtoGenerator(Utility.getClassName(serviceRequest.getServiceName()));
        dtoGenerator.create();
    return "Created";
    }
}
