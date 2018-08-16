/*

 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author ToanTQ6
 * @date 2018/07/17
 * @name OrderService.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service;

import java.util.List;

import edu.fa.topgun.shoppingcart.dto.OrderDto;
import edu.fa.topgun.shoppingcart.dto.ProductDto;

public interface OrderService {
  public boolean createOrder(OrderDto orderDto);

  public List<OrderDto> listOrder();

  public List<ProductDto> getTopSaleProduct();
   
  public List<ProductDto> getOrderByUser(int id);

  List<ProductDto> getOrderByUser(String userName);

  public List<ProductDto> getAllOrderByUser(String userName);
  
}
