package com.scaler.practiceproject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    public String sayhello(){
       return "Hello I am Dipesh";
    }

    @RequestMapping(value ="/hello/{id}", method = RequestMethod.GET)
    public String sayhello(@PathVariable("id") String id ){
        return "Hello my name is " + id ;
    }
}
//RestController
//RequestMapping
//RequestMethod
//PathVariable
