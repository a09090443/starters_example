package com.example.service;

import com.example.model.UserDetail;
import com.example.model.UserMain;
import com.example.repository.UserDetailRepository;
import com.example.repository.UserMainRepository;
import com.zipe.base.annotation.DS;
import com.zipe.base.annotation.DynamicDS;
import com.zipe.base.database.DataSourceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBExampleServiceImpl implements DBExampleService {

  private final UserMainRepository userMainRepository;
  private final UserDetailRepository userDetailRepository;

  @Autowired
  DBExampleServiceImpl(UserMainRepository userMainRepository, UserDetailRepository userDetailRepository){
    this.userMainRepository = userMainRepository;
    this.userDetailRepository = userDetailRepository;
  }

  @Override
  public UserMain getUserMainByName(String name) {
    String test = DataSourceHolder.getDataSourceName();
    System.out.println(test);
    DataSourceHolder.setDataSourceName("common");
    test = DataSourceHolder.getDataSourceName();
    System.out.println(test);

    DynamicDS altered = new DynamicDS("KungFu Panda");
    return userMainRepository.findUserByName(name);
  }

  @Override
  @DS
  public UserDetail getUserDetailByName(String name) {
    return userDetailRepository.findByName(name);
  }
}
