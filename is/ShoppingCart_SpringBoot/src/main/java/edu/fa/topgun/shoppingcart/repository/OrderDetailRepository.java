/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/17
 * @name OrderDetailRepository.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.repository;

import edu.fa.topgun.shoppingcart.entity.OrderDetail;
import edu.fa.topgun.shoppingcart.entity.Orders;
import edu.fa.topgun.shoppingcart.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository
    extends JpaRepository<OrderDetail, Integer> {

  /**
   * findByOrders.
   * 
   * @param orders orders
   * @return
   */
  public List<OrderDetail> findByOrders(Orders orders);

  /**
   * findByProduct.
   * 
   * @param product product
   * @return
   */
  public List<OrderDetail> findByProduct(Product product);
}
