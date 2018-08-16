/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/19
 * @name CategoryControllerTest.java
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import edu.fa.topgun.shoppingcart.controller.CategoryController;
import edu.fa.topgun.shoppingcart.dto.CategoryDto;
import edu.fa.topgun.shoppingcart.service.CategoryService;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {
  @InjectMocks
  private CategoryController controller;

  /**
   * mockMvc.
   */
  private MockMvc mockMvc;
  
  @Mock
  private CategoryService service;
  
  /**
   * setup.
   */
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
    service.createCategory(mockCategory());
  }
  
  private CategoryDto mockCategory() {
    CategoryDto category = new CategoryDto();
    category.setName("Electronic");
    category.setDescription("Using Voltage 220");
    return category;
  }
  
  @Test
  public void getAllCategory() throws Exception {
    String uri = "/api/category/get-all";
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
  }
  
  @Test
  public void createCategory() throws Exception {
    String uri = "/api/category/create";
    mockMvc.perform(post(uri)
        .contentType(TestUtil.APPLICATION_JSON_UTF8)
        .content(TestUtil.convertObjectToJsonBytes(mockCategory())))
        .andExpect(status().isOk())
        .andReturn();
  }
}
