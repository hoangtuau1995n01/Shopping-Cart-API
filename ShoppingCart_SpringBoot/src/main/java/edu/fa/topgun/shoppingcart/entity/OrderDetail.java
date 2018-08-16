/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author NghiaTT8
 * @date 2018/07/17
 * @name OrderDetail.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the order_detail database table.
 * 
 */
@Entity
@Table(name = "order_detail")
@NamedQuery(name = "OrderDetail.findAll", query = "SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "idorder_detail")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idorderDetail;

  private String amount;

  private long price;

  private int quantity;

  // bi-directional many-to-one association to TableOrder
  @ManyToOne
  @JoinColumn(name = "idorder")
  private Orders orders;

  // bi-directional many-to-one association to Product
  @ManyToOne
  @JoinColumn(name = "idproduct")
  private Product product;

  public OrderDetail() {
  }

  public int getIdorderDetail() {
    return this.idorderDetail;
  }

  public void setIdorderDetail(int idorderDetail) {
    this.idorderDetail = idorderDetail;
  }

  public String getAmount() {
    return this.amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public long getPrice() {
    return this.price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Orders getOrders() {
    return this.orders;
  }

  public void setOrders(Orders orders) {
    this.orders = orders;
  }

  public Product getProduct() {
    return this.product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

}