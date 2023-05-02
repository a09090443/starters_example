package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {

  @Override
  public String sayHello(String name) {
    return "Hello,  " + name + "!";
  }
}
