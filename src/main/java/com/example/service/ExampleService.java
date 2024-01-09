package com.example.service;

import com.example.entity.InfoEntity;
import com.example.entity.UserEntity;
import com.example.model.User;

import java.util.List;

/**
 * @author Gary.Tsai
 */
public interface ExampleService {

    List<User> findUsers();

    List<UserEntity> findExample1Data();

    InfoEntity findExample2Data();

    void findDb2Data();

    UserEntity findByNativeSQL(String name);

    String testException();
}
