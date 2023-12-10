package com.example.projets7.entity;


import jakarta.persistence.*;

@Entity
@Table(name="accesories_table")
@PrimaryKeyJoinColumn(name = "product_id")
public class Accessories extends Product {

  // Empty constructor
  public Accessories() {
    super("", 0.0, 0.0, 0.0, 0);
  }

  public Accessories(String name, double price, double income, double cost, int nbItems) {
    super(name, price, income, cost, nbItems);
  }

  public Accessories(int id, String name, double price, double income, double cost, int nbItems) {
    super(id, name, price, income, cost, nbItems);
  }

  @Override
  public String toString() {
    return "Accessories{" + super.toString() +
            '}';
  }

  @Override
  public void applyDiscount() {
    this.setPrice(Math.round(this.getPrice() * (1 - DISCOUNT_ACCESSORIES)*1000.0)/1000.0);
    this.setDiscount(true);
  }

  @Override
  public void stopDiscount() {
    this.setPrice(Math.round(this.getPrice() / (1 - DISCOUNT_SHOES)*1000.0)/1000.0);
    this.setDiscount(false);
  }
}

