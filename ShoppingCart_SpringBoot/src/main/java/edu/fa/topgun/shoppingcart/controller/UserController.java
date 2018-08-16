package edu.fa.topgun.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fa.topgun.shoppingcart.dto.ReponseLogin;
import edu.fa.topgun.shoppingcart.dto.UserDto;
import edu.fa.topgun.shoppingcart.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  UserService userService;
  
  @CrossOrigin()
  @PostMapping("/login")
  public ReponseLogin login(@RequestBody UserDto user) {
    ReponseLogin reponseLogin = new ReponseLogin();
    if (userService.login(user.getUserName(), user.getPassword())) {
      reponseLogin.setUserName(user.getUserName());
      reponseLogin.setSuccessful(true);
    }
    return reponseLogin;
  }


}
