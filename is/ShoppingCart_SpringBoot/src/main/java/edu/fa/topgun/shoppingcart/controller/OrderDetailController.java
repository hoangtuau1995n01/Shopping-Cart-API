/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/17
 * @name OrderDetailController.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.fa.topgun.shoppingcart.dto.OrderItemDto;
import edu.fa.topgun.shoppingcart.service.OrderDetailService;

@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailController {
  /**
   * orderDetailService.
   */
  @Autowired
  OrderDetailService orderDetailService;

  /**
   * findAll.
   * 
   * @return
   */
  @GetMapping("/get-all")
  public List<OrderItemDto> findAll() {
    return orderDetailService.findAll();
  }

  /**
   * findByOrderId.
   * 
   * @param id
   *          id
   * @return
   */
  @GetMapping("/get-by-id")
  public List<OrderItemDto> findByOrderId(@RequestParam(
      name = "id", required = true) int id) {
    return orderDetailService.findByOrderId(id);
  }

  /**
   * findByProductId.
   * 
   * @param id
   *          id
   * @return
   */
  @GetMapping("/get-by-productid")
  public List<OrderItemDto> findByProductId(@RequestParam(
      name = "id", required = true) int id) {
    return orderDetailService.findByProductId(id);
  }
}
