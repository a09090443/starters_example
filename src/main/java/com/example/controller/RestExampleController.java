package com.example.controller;

import com.example.dto.CommonMessageReq;
import com.example.service.ExampleService;
import com.zipe.annotation.ResponseResultBody;
import com.zipe.util.time.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@Slf4j
@RestController
@ResponseResultBody
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestExampleController {
    private final ExampleService exampleService;

    RestExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        log.info("Timestamp:{}", Timestamp.valueOf(DateTimeUtils.getDateNow()));
        return "Hello, " + name + "!";
    }

    @GetMapping("/getUsers")
    public ResponseEntity getUsers() {
        return ResponseEntity.ok().body(exampleService.findUsers());
    }

    @GetMapping("/getDataUsers")
    public ResponseEntity getDataUsers() {
        return ResponseEntity.ok().body(exampleService.findExample1Data());
    }

    @GetMapping("/getDataInfos")
    public ResponseEntity getDataInfos() {
        return ResponseEntity.ok().body(exampleService.findExample2Data());
    }

    @GetMapping("/getDb2Test")
    public String getDb2TestData() {
        exampleService.findDb2Data();
        return HttpStatus.OK.getReasonPhrase();
    }

    @GetMapping("/getJdbcData")
    public ResponseEntity getJdbcData(@RequestParam String name) {
        return ResponseEntity.ok().body(exampleService.findByNativeSQL(name));
    }

    @PostMapping(value = "/passXml", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonMessageReq passXml(@RequestBody CommonMessageReq request) {
        log.info("ToUserName:{}", request.getToUserName());
        log.info("FromUserName:{}", request.getFromUserName());
        log.info("MsgType:{}", request.getMsgType());
        return request;
    }

    @GetMapping("err")
    public int err() {
        exampleService.testException();
        return 1;
    }
}
