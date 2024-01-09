package com.example.service.impl;

import com.example.entity.AmlWhiteListEntity;
import com.example.entity.InfoEntity;
import com.example.entity.UserEntity;
import com.example.jdbc.ExampleJdbc;
import com.example.model.User;
import com.example.repository.AmlWhiteListRepository;
import com.example.repository.InfoRepository;
import com.example.repository.UserRepository;
import com.example.service.ExampleService;
import com.zipe.base.annotation.DS;
import com.zipe.enums.ResourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gary.Tsai
 */
@Slf4j
@Service
public class ExampleServiceImpl implements ExampleService {

    private final UserRepository userRepository;
    private final InfoRepository infoRepository;
    private final AmlWhiteListRepository amlWhiteListRepository;

    private final ExampleJdbc exampleJdbc;

    ExampleServiceImpl(UserRepository userRepository,
                       InfoRepository infoRepository,
                       AmlWhiteListRepository amlWhiteListRepository,
                       ExampleJdbc exampleJdbc) {
        this.userRepository = userRepository;
        this.infoRepository = infoRepository;
        this.amlWhiteListRepository = amlWhiteListRepository;
        this.exampleJdbc = exampleJdbc;
    }

    @Override
    public List<User> findUsers() {
        return new ArrayList<>(
                Arrays.asList(
                        new User("Gary", "M"),
                        new User("Mary", "F"),
                        new User("Cindy", "F"),
                        new User("Johnson", "M"),
                        new User("Fiona", "F")
                )
        );
    }

    @DS(value = "example1")
    public List<UserEntity> findExample1Data() {
        List<UserEntity> list = userRepository.findAll();
        list.forEach(data -> log.debug(data.toString()));
        return list;
    }

    @DS(value = "example2")
    public InfoEntity findExample2Data() {
        InfoEntity info = infoRepository.findByGender("M");
        log.info(info.toString());
        return info;
    }

    @Override
    public void findDb2Data() {
        List<AmlWhiteListEntity> list = amlWhiteListRepository.findAll();
        list.forEach(data -> log.debug(data.toString()));
    }

    @Override
    @DS(value = "example2")
    public UserEntity findByNativeSQL(String name) {
        ResourceEnum resource = ResourceEnum.SQL.getResource("FIND_USER_BY_NAME");
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        UserEntity user = exampleJdbc.queryForBean(resource, params, UserEntity.class);
        log.debug(user.toString());
        return user;
    }

    @Override
    public String testException() {
        throw new RuntimeException("拋出一個異常");
    }
}
