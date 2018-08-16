package edu.fa.topgun.shoppingcart.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(
    name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(
      name = "id_user")
  private int idUser;

  private String password;

  @Column(
      name = "user_name")
  private String userName;

  // bi-directional many-to-one association to Order
  @ManyToOne
  @JoinColumn(
      name = "id_order")
  private Orders order;

  public User() {
  }

  public int getIdUser() {
    return this.idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Orders getOrder() {
    return this.order;
  }

  public void setOrder(Orders order) {
    this.order = order;
  }

}