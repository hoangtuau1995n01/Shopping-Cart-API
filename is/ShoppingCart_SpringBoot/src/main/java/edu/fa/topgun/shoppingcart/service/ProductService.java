/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/17
 * @name ProductService.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service;

import java.util.List;

import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.entity.Category;

public interface ProductService {
  /**
   * listProduct.
   * 
   * @return list
   */
  public List<ProductDto> listProduct(int page, String sort);

  /**
   * insertProduct.
   * 
   * @param productDto ProductDto
   * 
   * @return true : insert success , false : insert fail
   */
  public boolean insertProduct(ProductDto productDto);

  /**
   * findByName.
   * 
   * @param productName String
   * @return list
   */
  public List<ProductDto> findByName(String productName);

  /**
   * findByCategoryId.
   * 
   * @param category Category
   * @return list
   */
  public List<ProductDto> findByCategoryId(Category category, int page,
      String sortDirection);
  
  /**
   * getTotalPage.
   * @param category
   * @return
   */
  public int getTotalPage(Category category);

  /**
   * findByOrderId.
   * 
   * @param id int
   * @return list
   */
  public List<ProductDto> findByOrderId(int id);
}
