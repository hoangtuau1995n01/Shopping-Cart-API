/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/17
 * @name ProductService.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.entity.Category;
import edu.fa.topgun.shoppingcart.entity.OrderDetail;
import edu.fa.topgun.shoppingcart.entity.Product;
import edu.fa.topgun.shoppingcart.exception.ProductException;
import edu.fa.topgun.shoppingcart.repository.CategoryRepository;
import edu.fa.topgun.shoppingcart.repository.ProductRepository;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;
import edu.fa.topgun.shoppingcart.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
  @Value("${page.size}")
  private int size;

  /**
   * productRepository.
   */
  @Autowired
  ProductRepository productRepository;
  /**
   * categoryRepository.
   */
  @Autowired
  CategoryRepository categoryRepository;
  /**
   * modelMapper.
   */
  @Autowired
  ModelMapper modelMapper;
  /**
   * orderDetailService.
   */
  @Autowired
  OrderDetailService orderDetailService;

  Sort sort = null;

  java.lang.reflect.Type targetListType = new TypeToken<List<ProductDto>>() {

    private static final long serialVersionUID = 1L;
  }.getType();

  /**
   * listProduct.
   */
  @Override
  public List<ProductDto> listProduct(int page, String sortDirection) {
    if ("desc".equals(sortDirection)) {
      sort = new Sort(new Sort.Order(Direction.DESC, "price"));
    } else {
      sort = new Sort(new Sort.Order(Direction.ASC, "price"));
    }
    Pageable pageable = new PageRequest(page - 1, size, sort);

    List<Product> listProduct = productRepository.findAll(pageable)
        .getContent();
    try {
      List<ProductDto> listProductDto = modelMapper.map(listProduct,
          targetListType);

      for (int i = 0; i < listProductDto.size(); i++) {
        listProductDto.get(i)
            .setIdcategory(listProduct.get(i).getCategory().getIdcategory());
      }

      return listProductDto;
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }

  /**
   * insertProduct.
   */
  @Override
  public boolean insertProduct(ProductDto productDto) {
    try {
      Product product = modelMapper.map(productDto, Product.class);

      Category category = categoryRepository
          .findOne(productDto.getIdcategory());
      product.setCategory(category);

      return productRepository.save(product) != null;
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }

  /**
   * findByName.
   */
  @Override
  public List<ProductDto> findByName(String productName) {
    try {

      List<ProductDto> listProductDto = modelMapper.map(
          productRepository.findByNameContaining(productName), targetListType);

      return listProductDto;
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }

  /**
   * findByCategoryId.
   */
  @Override
  public List<ProductDto> findByCategoryId(Category category, int page,
      String sortDirection) {
    if ("desc".equals(sortDirection)) {
      sort = new Sort(new Sort.Order(Direction.DESC, "price"));
    } else {
      sort = new Sort(new Sort.Order(Direction.ASC, "price"));
    }
    Pageable pageable = new PageRequest(page - 1, size, sort);
    List<Product> listProduct;
    List<ProductDto> listProductDto;
    try {
      if (category == null) {
        listProduct = productRepository.findAll(pageable).getContent();
        listProductDto = modelMapper.map(listProduct, targetListType);
      } else {
        listProduct = productRepository.findByCategory(category, pageable);
        listProductDto = modelMapper.map(listProduct, targetListType);
      }

      for (int i = 0; i < listProductDto.size(); i++) {
        listProductDto.get(i)
            .setIdcategory(listProduct.get(i).getCategory().getIdcategory());
      }

      return listProductDto;
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }

  /**
   * getTotalPage.
   */
  @Override
  public int getTotalPage(Category category) {
    int count = 0;
    int totalPage = 1;
    try {
      if (category == null) {
        count = productRepository.findAll().size();
      } else {
        count = productRepository.findByCategory(category).size();
      }

      if (count != 0) {
        totalPage = count / size;

        if (count % size != 0) {
          totalPage += 1;
        }
      }
      return totalPage;
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }

  /**
   * findByOrderId.
   */
  @Override
  public List<ProductDto> findByOrderId(int id) {
    try {
      List<OrderDetail> listOrderDetail = orderDetailService.findByOrder(id);
      ArrayList<Product> listProduct = new ArrayList<Product>();
      for (OrderDetail orderDetail : listOrderDetail) {
        listProduct.add(orderDetail.getProduct());
      }
      List<ProductDto> listProductDto = modelMapper.map(listProduct,
          targetListType);
      return listProductDto;
    } catch (Exception e) {
      throw new ProductException(e.getMessage());
    }
  }

}
