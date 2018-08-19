package edu.fa.topgun.shoppingcart.dto;

/**
 * The persistent class for the user database table.
 * 
 */
public class UserDto {
 
  private String password;
  
  private String userName;

  public UserDto() {
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}