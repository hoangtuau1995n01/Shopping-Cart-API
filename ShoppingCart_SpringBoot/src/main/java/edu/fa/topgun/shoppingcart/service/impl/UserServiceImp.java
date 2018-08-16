package edu.fa.topgun.shoppingcart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.topgun.shoppingcart.entity.User;
import edu.fa.topgun.shoppingcart.repository.UserRepository;
import edu.fa.topgun.shoppingcart.service.UserService;

@Service
public class UserServiceImp implements UserService {
  @Autowired
  UserRepository userRepository;

  @Override
  public boolean login(String username, String password) {
    List<User> user = userRepository.findByUserName(username);
    return user != null && !user.isEmpty()
        && user.get(0).getPassword().equals(password);
  }

}
