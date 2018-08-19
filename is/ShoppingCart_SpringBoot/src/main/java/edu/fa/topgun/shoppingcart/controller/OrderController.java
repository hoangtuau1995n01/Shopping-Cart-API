/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author ToanTQ6
 * @date 2018/07/17
 * @name OrderController.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fa.topgun.shoppingcart.dto.OrderDto;
import edu.fa.topgun.shoppingcart.dto.ProductDto;
import edu.fa.topgun.shoppingcart.service.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {
  @Autowired
  OrderService orderService;

  @CrossOrigin()
  @PutMapping("/create")
  public boolean createOrder(@Valid @RequestBody OrderDto orderDto) {
    return orderService.createOrder(orderDto);
  }

  @GetMapping("/get-all")
  public List<OrderDto> getAllOrder() {
    return orderService.listOrder();
  }

  @GetMapping("/get-all-order-by-user")
  public List<ProductDto> getAllOrderByUser(
      @RequestParam(name = "userName") String userName) {
    return orderService.getAllOrderByUser(userName);
  }

}
