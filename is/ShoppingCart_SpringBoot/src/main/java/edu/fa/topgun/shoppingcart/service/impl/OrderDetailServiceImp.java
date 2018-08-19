/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/17
 * @name OrderDetailServiceImp.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

import edu.fa.topgun.shoppingcart.dto.OrderItemDto;
import edu.fa.topgun.shoppingcart.entity.OrderDetail;
import edu.fa.topgun.shoppingcart.entity.Orders;
import edu.fa.topgun.shoppingcart.entity.Product;
import edu.fa.topgun.shoppingcart.exception.OrderDetailException;
import edu.fa.topgun.shoppingcart.repository.OrderDetailRepository;
import edu.fa.topgun.shoppingcart.repository.OrderRepository;
import edu.fa.topgun.shoppingcart.repository.ProductRepository;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

  /**
   * orderDetailRepository.
   */
  @Autowired
  OrderDetailRepository orderDetailRepository;

  /**
   * orderRepository.
   */
  @Autowired
  OrderRepository orderRepository;

  @Autowired
  ModelMapper modelMapper;
  /**
   * productRepository.
   */
  @Autowired
  ProductRepository productRepository;

  java.lang.reflect.Type targetListType = new TypeToken<List<OrderItemDto>>() {

    private static final long serialVersionUID = 1L;
  }.getType();

  /**
   * findAll.
   */
  @Override
  public List<OrderItemDto> findAll() {
    try {

      List<OrderItemDto> listOrderItem = modelMapper
          .map(orderDetailRepository.findAll(), targetListType);

      return listOrderItem;
    } catch (Exception e) {
      throw new OrderDetailException(e.getMessage());
    }
  }

  /**
   * findByOrderId.
   */
  @Override
  public List<OrderItemDto> findByOrderId(int id) {
    try {

      Orders orders = orderRepository.findOne(id);

      List<OrderItemDto> listOrderItem = modelMapper
          .map(orderDetailRepository.findByOrders(orders), targetListType);

      return listOrderItem;
    } catch (Exception e) {
      throw new OrderDetailException(e.getMessage());
    }
  }

  /**
   * findByOrderId.
   */
  @Override
  public List<OrderDetail> findByOrder(int id) {
    try {

      Orders orders = orderRepository.findOne(id);

      return orderDetailRepository.findByOrders(orders);
    } catch (Exception e) {
      throw new OrderDetailException(e.getMessage());
    }
  }

  /**
   * findByProductId.
   */
  @Override
  public List<OrderItemDto> findByProductId(int id) {
    try {

      Product product = productRepository.findOne(id);

      List<OrderItemDto> listOrderItem = modelMapper
          .map(orderDetailRepository.findByProduct(product), targetListType);
      return listOrderItem;
    } catch (Exception e) {
      throw new OrderDetailException(e.getMessage());
    }
  }
}
