package com.springboot.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class getController {

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public String getHello(){

        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){

        return "Yung JungHyun !!";
    }
}
