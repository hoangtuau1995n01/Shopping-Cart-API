/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/17
 * @name OrderDto.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.dto;

import java.util.Date;
import java.util.List;

public class OrderDto {

  private int idorder;

  private String amount;

  private Date createTime;

  private String orderAddress;

  private String orderEmail;

  private String orderName;

  private String orderPhone;
  
  private String iduser;

  private List<OrderItemDto> orderDetails;

  public String getAmount() {
    return amount;
  }

  public String getIduser() {
    return iduser;
  }

  public void setIduser(String iduser) {
    this.iduser = iduser;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getOrderAddress() {
    return orderAddress;
  }

  public void setOrderAddress(String orderAddress) {
    this.orderAddress = orderAddress;
  }

  public String getOrderEmail() {
    return orderEmail;
  }

  public void setOrderEmail(String orderEmail) {
    this.orderEmail = orderEmail;
  }

  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  public String getOrderPhone() {
    return orderPhone;
  }

  public void setOrderPhone(String orderPhone) {
    this.orderPhone = orderPhone;
  }

  public List<OrderItemDto> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderItemDto> orderDetails) {
    this.orderDetails = orderDetails;
  }

  public int getIdorder() {
    return idorder;
  }

  public void setIdorder(int idorder) {
    this.idorder = idorder;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "OrderDTO [idorder=" + idorder + ", createTime=" + createTime
        + ", amount=" + amount + ", orderAddress=" + orderAddress
        + ", orderEmail=" + orderEmail + ", orderName=" + orderName
        + ", orderPhone=" + orderPhone + ", orderDetails=" + orderDetails + "]";
  }

}
