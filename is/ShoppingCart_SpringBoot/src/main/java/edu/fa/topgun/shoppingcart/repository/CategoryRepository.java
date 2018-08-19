/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author DatCT
 * @date 2018/07/16
 * @name CategoryRepository.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.topgun.shoppingcart.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
