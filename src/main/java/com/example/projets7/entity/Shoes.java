package com.example.projets7.entity;

import jakarta.persistence.*;

@Entity
@Table(name="shoes_table")
@PrimaryKeyJoinColumn(name = "product_id")
public class Shoes extends Product {

  private int shoeSize;

  // Empty constructor
  public Shoes() {
    super("", 0.0, 0.0, 0.0, 0);
  }

  public Shoes(String name, double price, double income, double cost, int nbItems, int shoeSize) {
    super(name, price, income, cost, nbItems);
    this.shoeSize = shoeSize;
  }

  // Getter for shoeSize
  public int getShoeSize() {
    return shoeSize;
  }

  // Setter for shoeSize
  public void setShoeSize(int shoeSize) {
    this.shoeSize = shoeSize;
  }

  @Override
  public String toString() {
    return "Shoes{" + super.toString() +
            ", product_id=" +
            ", shoeSize=" + shoeSize +
            '}';
  }

  @Override
  public void applyDiscount() {
    this.setPrice(this.getPrice() * (1 - DISCOUNT_SHOES));
  }

  @Override
  public void stopDiscount() {
    this.setPrice(this.getPrice() / (1 - DISCOUNT_SHOES));
  }
}



