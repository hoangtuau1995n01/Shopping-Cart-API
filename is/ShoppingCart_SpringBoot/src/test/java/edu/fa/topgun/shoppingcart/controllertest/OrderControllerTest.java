/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/19
 * @name OrderControllerTest.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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

import edu.fa.topgun.shoppingcart.controller.OrderController;
import edu.fa.topgun.shoppingcart.dto.OrderDto;
import edu.fa.topgun.shoppingcart.dto.OrderItemDto;
import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
  
  @InjectMocks
  private OrderController controller;
  
  @Mock
  private OrderService orderService;
  
  /**
   * mockMvc.
   */
  private MockMvc mockMvc;
  
  /**
   * List Order Item.
   */
  private List<OrderItemDto> listOrderItem;
  
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
  }
  
  private OrderDto mockOrder() {

    listOrderItem = mockListOrderDetails();

    OrderDto order = new OrderDto();
    order.setAmount("123");
    order.setOrderAddress("Order Address");
    order.setOrderEmail("Email@gmail.com");
    order.setOrderName("Order Name");
    order.setOrderPhone("01234567");
    order.setOrderDetails(listOrderItem);

    return order;
  }
  
  private List<OrderItemDto> mockListOrderDetails() {
    listOrderItem = new ArrayList<OrderItemDto>();
    
    ProductDto productDto = new ProductDto();

    OrderItemDto orderItem1 = new OrderItemDto();
    orderItem1.setAmount("2");
//    orderItem1.setProduct(productDto);
    orderItem1.setPrice(100);
    orderItem1.setQuantity(2);
    listOrderItem.add(orderItem1);

    OrderItemDto orderItem2 = new OrderItemDto();
    orderItem2.setAmount("3");
//    orderItem2.setProduct(productDto);
    orderItem2.setPrice(200);
    orderItem2.setQuantity(3);
    listOrderItem.add(orderItem2);

    return listOrderItem;
  }
  
  @Test
  public void getAllOrder() throws Exception {
    String uri = "/api/order/get-all";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andReturn();
  }
  
  @Test
  public void createOrder() throws Exception {
    String uri = "/api/order/create";
    mockMvc.perform(post(uri)
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(mockOrder())))
        .andExpect(status().isOk())
        .andReturn();
  }
 
}
