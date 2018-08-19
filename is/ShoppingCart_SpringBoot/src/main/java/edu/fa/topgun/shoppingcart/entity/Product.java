package edu.fa.topgun.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idproduct;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date", insertable = false, updatable = false)
  private Date createDate;

  private String descripion;

  private String name;

  private long price;

  private int quantity;

  // bi-directional many-to-one association to OrderDetail
  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private List<OrderDetail> orderDetails;

  // bi-directional many-to-one association to Category
  @ManyToOne
  @JoinColumn(name = "idcategory")
  private Category category;

  public Product() {
  }

  public int getIdproduct() {
    return this.idproduct;
  }

  public void setIdproduct(int idproduct) {
    this.idproduct = idproduct;
  }

  public Date getCreateDate() {
    return this.createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public String getDescripion() {
    return this.descripion;
  }

  public void setDescripion(String descripion) {
    this.descripion = descripion;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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
    orderDetail.setProduct(this);

    return orderDetail;
  }

  /**
   * Remove Order Detail.
   * @param orderDetail OrderDetail
   * @return
   */
  public OrderDetail removeOrderDetail(OrderDetail orderDetail) {
    getOrderDetails().remove(orderDetail);
    orderDetail.setProduct(null);

    return orderDetail;
  }

  public Category getCategory() {
    return this.category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

}