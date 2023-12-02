package com.example.projets7.entity;

public class Accessories extends Product {

  public Accessories(String name, double price, int nbItems) {
    super(name, price, nbItems);
  }

  @Override
  public String toString() {
    return "Accessories{"+ super.toString()+"}";
  }

  @Override
  public void applyDiscount() {
    this.setPrice(this.getPrice()*(1-DISCOUNT_ACCESSORIES));

  }
  @Override
  public void stopDiscount(){
    this.setPrice(this.getPrice()/(1-DISCOUNT_ACCESSORIES));
  }
}
