package edu.fa.topgun.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;

import edu.fa.topgun.shoppingcart.entity.CountingProductView;

public interface CountingProductViewRepository
    extends CrudRepository<CountingProductView, Integer> {

}
