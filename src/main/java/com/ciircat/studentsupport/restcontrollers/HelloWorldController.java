package com.ciircat.studentsupport.restcontrollers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-world")
    @CrossOrigin(origins = "http://localhost:3000")
    public String helloWorld(){
        return "Hello world";

    }

    @GetMapping(value = "/hello-world-bean")
    @ResponseBody()
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("DEMENTE");

    }
}
