package com.siva.inversion.controller;


import com.siva.inversion.classgenerator.DtoGenerator;
import com.siva.inversion.classgenerator.dto.request.ServiceRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "generate", method = {RequestMethod.POST})
    public String create(@RequestBody ServiceRequest serviceRequest) throws Exception {

        DtoGenerator dtoGenerator = new DtoGenerator(serviceRequest.getServiceName());
        dtoGenerator.create();
    return "Created";
    }
}
