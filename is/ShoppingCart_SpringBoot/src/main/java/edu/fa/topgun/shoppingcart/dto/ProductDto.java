/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/17
 * @name ProductDto.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.dto;

import java.util.Date;

public class ProductDto {

  private int idproduct;

  private Date createDate;

  private String descripion;

  private String name;

  private long price;

  private int quantity;

  private int idcategory;
  

  public int getIdcategory() {
    return idcategory;
  }

  public void setIdcategory(int idcategory) {
    this.idcategory = idcategory;
  }

  public String getDescripion() {
    return descripion;
  }

  public void setDescripion(String descripion) {
    this.descripion = descripion;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public int getIdproduct() {
    return idproduct;
  }

  public void setIdproduct(int idproduct) {
    this.idproduct = idproduct;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  public String toString() {
    return "ProductDto [idproduct=" + idproduct + ", createDate=" + createDate
        + ", descripion=" + descripion + ", name=" + name + ", price=" + price
        + ", quantity=" + quantity + ", idcategory=" + idcategory + "]";
  }

}
