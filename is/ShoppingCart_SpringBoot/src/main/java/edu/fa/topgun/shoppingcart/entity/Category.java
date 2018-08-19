package edu.fa.topgun.shoppingcart.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The persistent class for the category database table.
 * 
 */
@Entity
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idcategory;

  private String description;

  private String name;

  // bi-directional many-to-one association to Product
  @OneToMany(
      mappedBy = "category")
  private List<Product> products;

  public Category() {
  }

  public int getIdcategory() {
    return this.idcategory;
  }

  public void setIdcategory(int idcategory) {
    this.idcategory = idcategory;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  /**
   * Add Product.
   * @param product Product
   * @return
   */
  public Product addProduct(Product product) {
    getProducts().add(product);
    product.setCategory(this);

    return product;
  }
  
  /**
   * Remove Product.
   * @param product Product
   * @return
   */
  public Product removeProduct(Product product) {
    getProducts().remove(product);
    product.setCategory(null);

    return product;
  }

}