package com.example.webservice;

import com.zipe.model.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.Map;

@WebService(targetNamespace = "http://service.example.com/")
public interface ExampleUserService {

    @WebMethod//標注該方法為webservice暴露的方法,用於向外公布，它修飾的方法是webservice方法，去掉也沒影響的，類似一個注釋信息。
    public User getUser(@WebParam(name = "name", targetNamespace = "http://service.example.com/") String name);

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    public String getUserId(@WebParam(name = "name", targetNamespace = "http://service.example.com/") String name);

    @WebMethod
    @WebResult(name = "Map")
    public Map<String, User> getAllUserData();
}
