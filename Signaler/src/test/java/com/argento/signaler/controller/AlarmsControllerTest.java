package com.argento.signaler.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AlarmsControllerTest {

    @LocalServerPort
    private int port;

   // @Autowired
   // private TestRestTemplate restTemplate; only for other tests
	
    @Autowired
    private MockMvc mockMvc;
    
	@Autowired
	AlarmsController alarmsController;
	
	
	
  @Test
  public void createAlarm() {
    
  }

  @Test
  public void deletedAlarm() {
    
  }

  @Test
  public void getAlarms() throws Exception {
	  this.mockMvc.perform(get("/alarms")).andDo(print()).andExpect(status().isOk())
      .andExpect(content().string(containsString("Hello World")));
  }

  @Test
  public void updateAlarm() {
    
  }
}
