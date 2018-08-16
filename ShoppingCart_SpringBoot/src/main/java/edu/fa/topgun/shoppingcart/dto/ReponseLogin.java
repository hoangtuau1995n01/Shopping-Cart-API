package edu.fa.topgun.shoppingcart.dto;

public class ReponseLogin {

  private String userName;

  private boolean successful;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public boolean isSuccessful() {
    return successful;
  }

  public void setSuccessful(boolean successful) {
    this.successful = successful;
  }
}
