/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/19
 * @name OrderDetailControllerTest.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controllertest;

import edu.fa.topgun.shoppingcart.controller.OrderDetailController;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class OrderDetailControllerTest {

  @InjectMocks
  private OrderDetailController controller;
  
  @Mock
  private OrderDetailService orderDetailService;
  
  /**
   * mockMvc.
   */
  private MockMvc mockMvc;
  
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
  }
  
  @Test
  public void findAll() throws Exception {
    String uri = "/api/order-detail/get-all";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andReturn();
  }
  
  @Test
  public void findByOrderId() throws Exception {
    String uri = "/api/order-detail/get-by-id?id=1";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andReturn();
  }
  
  @Test
  public void findByProductId() throws Exception {
    String uri = "/api/order-detail/get-by-productid?id=1";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andReturn();
  }
  
}
