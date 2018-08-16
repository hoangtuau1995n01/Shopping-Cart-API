/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author TranNTH1
 * @date 2018/07/17
 * @name CategoryDto.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.dto;

import javax.validation.constraints.NotNull;

public class CategoryDto {

  private int idcategory;
  @NotNull(message = "fulfill the description")
  private String description;

  private String name;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getIdcategory() {
    return idcategory;
  }

  public void setIdcategory(int idcategory) {
    this.idcategory = idcategory;
  }

  @Override
  public String toString() {
    return "CategoryDTO [description=" + description + ", name=" + name + "]";
  }

}
