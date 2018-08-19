/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/16
 * @name ProductRepository.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.topgun.shoppingcart.entity.Category;
import edu.fa.topgun.shoppingcart.entity.Product;

public interface ProductRepository
    extends JpaRepository<Product, Integer> {
  public List<Product> findByCategory(Category category, Pageable pageable);

  public List<Product> findByNameLike(String productName);
  public List<Product> findByNameContaining(String productName);
  

  public List<Product> findByCategory(Category category);

}
