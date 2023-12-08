package com.example.projets7.entity;

import jakarta.persistence.*;

@Entity
@Table(name="clothes_table")
@PrimaryKeyJoinColumn(name = "product_id")
public class Clothes extends Product {

  private int size;

  // Empty constructor
  public Clothes() {
    super("", 0.0, 0.0, 0.0, 0);
  }

  public Clothes(String name, double price, double cost, double income, int nbItems, int size) {
    super(name, price, cost, income, nbItems);
    setSize(size);
  }

  // Getter for size
  public int getSize() {
    return size;
  }

  // Setter for size with validation
  public void setSize(int size) throws IllegalArgumentException {
    if (size >= 36 && size <= 50) {
      this.size = size;
    } else {
      throw new IllegalArgumentException("Size is not valid");
    }
  }

  @Override
  public String toString() {
    return "Clothes{" + super.toString() +
            ", size=" + size +
            '}';
  }

  @Override
  public void applyDiscount() {
    this.setPrice(Math.round(this.getPrice() * (1 - DISCOUNT_CLOTHES)*1000.0)/1000.0);
    this.setDiscount(true);
  }

  @Override
  public void stopDiscount() {
    this.setPrice(Math.round(this.getPrice() / (1 - DISCOUNT_CLOTHES)*1000.0)/1000.0);
    this.setDiscount(false);
  }
}

