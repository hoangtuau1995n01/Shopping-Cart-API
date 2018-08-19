/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/17
 * @name OrderDetailService.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.service;

import edu.fa.topgun.shoppingcart.dto.OrderItemDto;
import edu.fa.topgun.shoppingcart.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {

  /**
   * findAll.
   * 
   * @return
   */
  public List<OrderItemDto> findAll();

  /**
   * findByOrderId.
   * 
   * @param id id
   * @return
   */
  public List<OrderItemDto> findByOrderId(int id);

  /**
   * findByProductId.
   * 
   * @param id id
   * @return
   */
  public List<OrderItemDto> findByProductId(int id);

  /**
   * findByOrder.
   * 
   * @param id id
   * @return
   */
  public List<OrderDetail> findByOrder(int id);
}
