/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author DatCT
 * @date 2018/07/16
 * @name CategoryServiceImp.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

import edu.fa.topgun.shoppingcart.dto.CategoryDto;
import edu.fa.topgun.shoppingcart.entity.Category;
import edu.fa.topgun.shoppingcart.exception.CategoryException;
import edu.fa.topgun.shoppingcart.repository.CategoryRepository;
import edu.fa.topgun.shoppingcart.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;
  @Autowired
  ModelMapper modelMapper;

  @Override
  public List<CategoryDto> listCategory() {
    try {
      java.lang.reflect.Type targetListType = 
          new TypeToken<List<CategoryDto>>() {
        private static final long serialVersionUID = 1L;
      }.getType();
      List<CategoryDto> categoryDto = modelMapper
          .map(categoryRepository.findAll(), targetListType);

      return categoryDto;
    } catch (Exception e) {
      throw new CategoryException(e.getMessage());
    }
  }

  @Override
  public boolean createCategory(CategoryDto categoryDto) {
    try {
      Category category = modelMapper.map(categoryDto, Category.class);
      return categoryRepository.save(category) != null;
    } catch (Exception e) {
      throw new CategoryException(e.getMessage());
    }
  }

  @Override
  public Category findByCategoryId(int id) {
    try {
      return categoryRepository.findOne(id);
    } catch (Exception e) {
      throw new CategoryException(e.getMessage());
    }
  }
}
