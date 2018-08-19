/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/16
 * @name ProductController.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.entity.Category;
import edu.fa.topgun.shoppingcart.service.CategoryService;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;
import edu.fa.topgun.shoppingcart.service.OrderService;
import edu.fa.topgun.shoppingcart.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  ProductService productService;

  @Autowired
  CategoryService categoryService;

  @Autowired
  OrderDetailService orderDetailService;

  @Autowired
  OrderService orderService;

  /**
   * getByCategoryId.
   * 
   * @param id
   *          id
   * @return list Product
   */
  @GetMapping("/get-by-category-id")
  public List<ProductDto> getByCategoryId(@RequestParam(
      name = "id", required = true) int id,
      @RequestParam(
          name = "page", required = true) int page,
      String sort) {
    Category category = categoryService.findByCategoryId(id);
    return productService.findByCategoryId(category, page, sort);
  }
  
  /**
   * getTotalPage.
   * @param id int
   * @return
   */
  @GetMapping("/get-total-page")
  public int getTotalPage(@RequestParam(name = "id", required = true) int id) {
    Category category = categoryService.findByCategoryId(id);
    return productService.getTotalPage(category);
  }

  /**
   * getAllProduct.
   * 
   * @return list Product
   */
  @GetMapping("/get-all")
  public List<ProductDto> getAllProduct(@RequestParam(
      name = "page", required = true) int page, String sort) {
    return productService.listProduct(page, sort);
  }

  /**
   * createProduct.
   * 
   * @param productDto
   *          ProductDto
   * @return true : create success, false: create fail
   */
  @PutMapping("/create")
  public boolean createProduct(@Valid @RequestBody ProductDto productDto) {
    return productService.insertProduct(productDto);
  }

  /**
   * getByName.
   * 
   * @param productName
   *          String
   * @return
   */
  @GetMapping("/find-by-name")
  public List<ProductDto> getByName(
      @RequestParam("productName") String productName) {
    return productService.findByName(productName);
  }

  /**
   * getByOrderId.
   * 
   * @param id
   *          id
   * @return
   */
  @GetMapping("/find-by-orderid")
  public List<ProductDto> getByOrderId(@RequestParam(
      name = "id", required = true) int id) {
    return productService.findByOrderId(id);
  }

  @GetMapping("/get-top-sale")
  public List<ProductDto> getTopSaleProduct(
      @RequestParam("limitNumber") int limitNumber) {
    List<ProductDto> products = orderService.getTopSaleProduct();
    List<ProductDto> result = new ArrayList<>();
    if (products.size() >= limitNumber) {
      for (int i = 0; i < limitNumber; i++) {
        result.add(products.get(i));
      }
      return result;
    }
    return products;
  }

}
