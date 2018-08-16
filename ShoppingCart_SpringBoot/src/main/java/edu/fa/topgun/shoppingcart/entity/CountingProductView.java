package edu.fa.topgun.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "counting_product")
public class CountingProductView implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @Column(
      name = "idproduct")
  private int idproduct;
  @NotNull
  @Column(
      name = "count")
  private String myViewName;

  public int getIdproduct() {
    return idproduct;
  }

  public void setIdproduct(int idproduct) {
    this.idproduct = idproduct;
  }

  public String getMyViewName() {
    return myViewName;
  }

  public void setMyViewName(String myViewName) {
    this.myViewName = myViewName;
  }

}
