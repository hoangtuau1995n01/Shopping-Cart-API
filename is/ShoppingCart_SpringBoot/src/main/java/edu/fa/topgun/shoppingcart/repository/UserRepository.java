package edu.fa.topgun.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.topgun.shoppingcart.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  
  public List<User> findByUserName(String userName);
}
