/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author DatCT
 * @date 2018/07/16
 * @name CategoryService.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service;

import java.util.List;

import edu.fa.topgun.shoppingcart.dto.CategoryDto;
import edu.fa.topgun.shoppingcart.entity.Category;

public interface CategoryService {

  public List<CategoryDto> listCategory();

  public boolean createCategory(CategoryDto categoryDto);

  public Category findByCategoryId(int id);
}
