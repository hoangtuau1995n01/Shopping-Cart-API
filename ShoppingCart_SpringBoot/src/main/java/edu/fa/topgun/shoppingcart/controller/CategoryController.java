/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author DatCT
 * @date 2018/07/16
 * @name CategoryController.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fa.topgun.shoppingcart.dto.CategoryDto;
import edu.fa.topgun.shoppingcart.service.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
  @Autowired
  CategoryService categoryService;
  @Autowired
  ModelMapper modelMapper;
  private static final Logger logger = LoggerFactory
      .getLogger(CategoryController.class);

  @GetMapping("get-all")
  public List<CategoryDto> getAllCategory() {
    logger.info("getAllCategory");
    return categoryService.listCategory();
  }

  @PutMapping("create")
  public boolean createCategory(@Valid @RequestBody CategoryDto categoryDto) {
    logger.info("createCategory");
    return categoryService.createCategory(categoryDto);
  }
}
