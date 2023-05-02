package com.example.controller;

import com.example.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Gary Tsai
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

    private ExampleService exampleService;

    @Autowired
    public RestController(ExampleService exampleService){
        this.exampleService = exampleService;
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam String name){
        return exampleService.sayHello(name);
    }
}
