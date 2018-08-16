/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/19
 * @name ProductControllerTest.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controllertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.fa.topgun.shoppingcart.controller.ProductController;
import edu.fa.topgun.shoppingcart.dto.CategoryDto;
import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.repository.ProductRepository;
import edu.fa.topgun.shoppingcart.service.CategoryService;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;
import edu.fa.topgun.shoppingcart.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

  @InjectMocks
  private ProductController controller;
  
  @Mock
  private ProductService service;

  /**
   * mockMvc.
   */
  private MockMvc mockMvc;
  
  @Mock
  private CategoryService categoryService;
  
  @Mock
  private OrderDetailService orderDetailService;
  
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    service.insertProduct(mockProductDto());
  }
  
  @MockBean
  private ProductRepository prodRepo;

  private ProductDto mockProductDto() {
    CategoryDto category = new CategoryDto();
    category.setName("Electronic");
    category.setDescription("Using Voltage 220");
    
    ProductDto dto = new ProductDto();
    dto.setName("IphoneX");
    dto.setPrice(25);
    dto.setQuantity(300);
    dto.setDescripion("this ");
//    dto.setCategory(1);
    return dto;
  }
  
  @Test
  public void getAllProduct() throws Exception {
    String uri = "/api/product/get-all";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andReturn();
  }
  
  @Test
  public void getByCategoryId() throws Exception {
    String uri = "/api/product/get-by-category-id?id=2";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
       .andExpect(MockMvcResultMatchers.status().isOk())
       .andReturn();
  }
  
  @Test
  public void getByOrderId() throws Exception {
    String uri = "/api/product/find-by-orderid?id=1";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
       .andExpect(MockMvcResultMatchers.status().isOk())
       .andReturn();
  }
  
  @Test
  public void getByName() throws Exception {
    String uri = "/api/product/find-by-name?productName='Iphone 8'";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
       .andExpect(MockMvcResultMatchers.status().isOk())
       .andReturn();
  }
  
  @Test
  public void createProduct() throws Exception {
    String uri = "/api/product/create";
    mockMvc.perform(post(uri)
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(mockProductDto())))
        .andExpect(status().isOk())
        .andReturn();
  }
  
  /*  @Test
  public void getProductsByOrderId() throws Exception {
    String uri = "/productsByOrderId/1";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
    .andExpect(MockMvcResultMatchers.status().isOk())
         .andReturn();
  }*/
}
