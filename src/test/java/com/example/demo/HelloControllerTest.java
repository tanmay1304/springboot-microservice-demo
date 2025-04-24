package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testHelloEndpoint() throws Exception {
    mockMvc.perform(get("/hello"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.message").value("Hello, World!"));
  }
}
