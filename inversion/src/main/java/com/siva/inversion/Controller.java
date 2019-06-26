package com.siva.inversion;


import com.siva.inversion.createfiles.CreateClasses;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    @RequestMapping(value = "generate", method = {RequestMethod.POST})
    public String create(@RequestBody ClassToCreate className) throws IOException {

        CreateClasses createClasses = new CreateClasses(className.getClassName());
        createClasses.create();
    return "Created";
    }
}
