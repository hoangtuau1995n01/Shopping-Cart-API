/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author ToanTQ6
 * @date 2018/07/17
 * @name OrderServiceImp.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

import edu.fa.topgun.shoppingcart.dto.OrderDto;
import edu.fa.topgun.shoppingcart.dto.OrderItemDto;
import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.entity.CountingProductView;
import edu.fa.topgun.shoppingcart.entity.OrderDetail;
import edu.fa.topgun.shoppingcart.entity.Orders;
import edu.fa.topgun.shoppingcart.entity.Product;
import edu.fa.topgun.shoppingcart.entity.User;
import edu.fa.topgun.shoppingcart.exception.OrderException;
import edu.fa.topgun.shoppingcart.repository.CountingProductViewRepository;
import edu.fa.topgun.shoppingcart.repository.OrderDetailRepository;
import edu.fa.topgun.shoppingcart.repository.OrderRepository;
import edu.fa.topgun.shoppingcart.repository.ProductRepository;
import edu.fa.topgun.shoppingcart.repository.UserRepository;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;
import edu.fa.topgun.shoppingcart.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  OrderDetailRepository orderDetailRepository;
  @Autowired
  OrderDetailService orderDetailService;
  @Autowired
  CountingProductViewRepository countingProductViewRepository;
  @Autowired
  UserRepository userRepository;

  @Override
  public boolean createOrder(OrderDto orderDto) {
    try {

      List<OrderItemDto> listOrderItem = orderDto.getOrderDetails();

      Orders order = modelMapper.map(orderDto, Orders.class);
      order.setOrderDetails(null);

      if (orderRepository.save(order) == null) {
        return false;
      }

      return createOrderDetail(listOrderItem, order);
    } catch (Exception e) {
      throw new OrderException(e.getMessage());
    }
  }

  /**
   * createOrderDetail.
   * 
   * @param listOrderItem
   * @param order
   * @return
   */
  private boolean createOrderDetail(List<OrderItemDto> listOrderItem,
      Orders order) {
    try {

      List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();

      for (int i = 0; i < listOrderItem.size(); i++) {
        Product product = productRepository
            .findOne(listOrderItem.get(i).getIdproduct());

        OrderDetail orderDetail = modelMapper.map(listOrderItem.get(i),
            OrderDetail.class);
        orderDetail.setProduct(product);
        orderDetail.setOrders(order);

        listOrderDetail.add(orderDetail);
      }

      return orderDetailRepository.save(listOrderDetail) != null;
    } catch (Exception e) {
      throw new OrderException(e.getMessage());
    }
  }

  @Override
  public List<OrderDto> listOrder() {
    try {

      java.lang.reflect.Type targetListType = new TypeToken<List<OrderDto>>() {

        private static final long serialVersionUID = 1L;
      }.getType();

      List<Orders> listOrders = orderRepository.findAll();
      List<OrderDetail> listOrderDetail = null;
      for (Orders order : listOrders) {
        listOrderDetail = orderDetailService.findByOrder(order.getIdorder());
        order.setOrderDetails(listOrderDetail);
      }

      List<OrderDto> listOrderDto = modelMapper.map(listOrders, targetListType);

      for (int i = 0; i < listOrderDto.size(); i++) {
        for (int j = 0; j < listOrderDto.get(i).getOrderDetails().size(); j++) {
          listOrderDto.get(i).getOrderDetails().get(j).setIdproduct(listOrders
              .get(i).getOrderDetails().get(j).getProduct().getIdproduct());
        }
      }

      return listOrderDto;
    } catch (Exception e) {
      System.out.println(e.toString());
      throw new OrderException(e.getMessage());
    }
  }

  @Override
  public List<ProductDto> getTopSaleProduct() {
    List<ProductDto> result = new ArrayList<>();
    List<CountingProductView> countingProductViews = (List<CountingProductView>) countingProductViewRepository
        .findAll();

    for (int i = 0; i < countingProductViews.size(); i++) {
      Product p = productRepository
          .findOne(countingProductViews.get(i).getIdproduct());
      result.add(modelMapper.map(p, ProductDto.class));
    }
    return result;
  }

  @Override
  public List<ProductDto> getOrderByUser(String userName) {
    List<User> users = userRepository.findByUserName(userName);
    List<ProductDto> productDtos = null;
    java.lang.reflect.Type targetListType = new TypeToken<List<OrderItemDto>>() {

      private static final long serialVersionUID = 1L;
    }.getType();
    for (User user : users) {
      List<OrderDetail> products = orderDetailRepository
          .findByOrders(user.getOrder());
      List<OrderItemDto> orderIterm = modelMapper.map(products, targetListType);
    }
    return null;
  }

  @Override
  public List<ProductDto> getOrderByUser(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<ProductDto> getAllOrderByUser(String userName) {
    try {

      ArrayList<ProductDto> productDtos = new ArrayList<>();
      List<Orders> orders = orderRepository.findByIduser(userName);
      if (orders == null || orders.isEmpty()) {
        return null;
      }

      for (Orders order : orders) {
        List<OrderDetail> orderDetails = order.getOrderDetails();
        if (orderDetails!=null || orderDetails.isEmpty()) {
          for (OrderDetail orderDetail : orderDetails) {
            productDtos
                .add(modelMapper.map(orderDetail.getProduct(), ProductDto.class));
          }
        }
       
      }

      return productDtos;
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
      return null;
    }

  }
}
