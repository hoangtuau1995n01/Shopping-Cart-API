package edu.fa.topgun.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the table_order database table.
 * 
 */
@Entity
@Table(name = "orders")
@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
public class Orders implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idorder;

  private String amount;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_time", insertable = false, updatable = false)
  private Date createTime;

  @Column(name = "order_address")
  private String orderAddress;

  @Column(name = "order_email")
  private String orderEmail;

  @Column(name = "order_name")
  private String orderName;

  @Column(name = "order_phone")
  private String orderPhone;
  
  @Column(name = "iduser")
  private String iduser;

  // bi-directional many-to-one association to OrderDetail
  @OneToMany(mappedBy = "orders",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private List<OrderDetail> orderDetails;

  public Orders() {
  }

  public int getIdorder() {
    return this.idorder;
  }

  public String getIduser() {
    return iduser;
  }

  public void setIduser(String iduser) {
    this.iduser = iduser;
  }

  public void setIdorder(int idorder) {
    this.idorder = idorder;
  }

  public String getAmount() {
    return this.amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getOrderAddress() {
    return this.orderAddress;
  }

  public void setOrderAddress(String orderAddress) {
    this.orderAddress = orderAddress;
  }

  public String getOrderEmail() {
    return this.orderEmail;
  }

  public void setOrderEmail(String orderEmail) {
    this.orderEmail = orderEmail;
  }

  public String getOrderName() {
    return this.orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }

  public String getOrderPhone() {
    return this.orderPhone;
  }

  public void setOrderPhone(String orderPhone) {
    this.orderPhone = orderPhone;
  }

  public List<OrderDetail> getOrderDetails() {
    return this.orderDetails;
  }

  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  /**
   * Add Order Detail.
   * @param orderDetail OrderDetail
   * @return
   */
  public OrderDetail addOrderDetail(OrderDetail orderDetail) {
    getOrderDetails().add(orderDetail);
    orderDetail.setOrders(this);

    return orderDetail;
  }

  /**
   * Remove Order Detail.
   * @param orderDetail OrderDetail
   * @return
   */
  public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
    getOrderDetails().remove(orderDetail);
    orderDetail.setOrders(null);

    return orderDetail;
  }
}