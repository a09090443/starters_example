package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.base.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

@Slf4j
@AutoConfigureMockMvc
public class WebControllerTest extends TestBase {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void testThymeleaf() throws Exception {
    this.mockMvc.perform(get("/thymeleaf")).andExpect(status().isOk());
  }
  @Test
  public void testJsp() throws Exception {
    this.mockMvc.perform(get("/jsp")).andExpect(status().isOk());
  }
}
