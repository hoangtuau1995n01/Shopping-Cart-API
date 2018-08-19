/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/17
 * @name OrderItemDto.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.dto;

public class OrderItemDto {

  private int idorderDetail;

  private String amount;

  private long price;

  private int quantity;

  private int idorder;

  private int idproduct;

  public int getIdproduct() {
    return idproduct;
  }

  public void setIdproduct(int idproduct) {
    this.idproduct = idproduct;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getIdorder() {
    return idorder;
  }

  public void setIdorder(int idorder) {
    this.idorder = idorder;
  }

  public int getIdorderDetail() {
    return idorderDetail;
  }

  public void setIdorderDetail(int idorderDetail) {
    this.idorderDetail = idorderDetail;
  }

  @Override
  public String toString() {
    return "OrderItemDto [idorderDetail=" + idorderDetail + ", amount=" + amount
        + ", price=" + price + ", quantity=" + quantity + ", idorder=" + idorder
        + ", idproduct=" + idproduct + "]";
  }

}
