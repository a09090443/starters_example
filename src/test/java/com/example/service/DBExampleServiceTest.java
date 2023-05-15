package com.example.service;

import com.example.base.TestBase;
import com.example.model.UserMain;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DBExampleServiceTest extends TestBase {

  private DBExampleService dbExampleService;

  @Autowired
  DBExampleServiceTest(DBExampleService dbExampleService){
    this.dbExampleService = dbExampleService;
  }

  @Test
  public void findUserMainByNameTest(){
    UserMain userMain = dbExampleService.getUserMainByName("Gary");
    System.out.println(userMain);
  }
}
