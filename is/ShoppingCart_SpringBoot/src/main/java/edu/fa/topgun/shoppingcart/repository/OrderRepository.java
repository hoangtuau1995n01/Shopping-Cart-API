/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author ToanTQ6
 * @date 2018/07/17
 * @name OrderRepository.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.topgun.shoppingcart.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
  
  public List<Orders> findByIduser(String userName);

}
