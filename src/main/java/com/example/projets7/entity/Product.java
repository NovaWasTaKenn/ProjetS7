package com.example.projets7.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="product_table")
public class Product implements Discount, Comparable<Product> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="_name", nullable = false)
  private String name;
  private double price;
  private int nbItems;
  private double income;
  private double cost;

  // Empty constructor
  public Product() {
  }

  public Product(Integer id, String name, double price, double income, double cost, int nbItems) {
    this.id = id;
    this.name = name;
    setPrice(price);
    this.income = income;
    this.cost = cost;
    setNbItems(nbItems);
  }

  public Product(String name, double price, double income, double cost, int nbItems) {
    this.name = name;
    //this.price = price;
    setPrice(price);
    this.income = income;
    this.cost = cost;
    setNbItems(nbItems);
  }


  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id=id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getIncome() {
    return this.income;
  }

  public void setIncome(String name) {
    this.income = income;
  }

  public void setCost(String name) {
    this.cost = cost;
  }

  public double getCost() {
    return this.cost;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) throws IllegalArgumentException {
    if (price >= 0) {
      this.price = price;
    } else throw new IllegalArgumentException("Price is negative");
  }

  public int getNbItems() {
    return nbItems;
  }

  public void setNbItems(int nbItems) throws IllegalArgumentException {
    if (nbItems >= 0) {
      this.nbItems = nbItems;
    } else throw new IllegalArgumentException("Stock is negative");
  }


  public void sell(int nbItems) throws IllegalArgumentException {
    if (nbItems < this.nbItems) {
      this.setNbItems(this.nbItems - nbItems);
      income += nbItems * this.price;
      System.out.println("Sell OK");
    } else throw new IllegalArgumentException("Unavailable product");
  }

  public void purchase(int nbItems) throws IllegalArgumentException {
    if (nbItems > 0) {
      this.setNbItems(this.nbItems + nbItems);
      cost += nbItems * this.price;
      System.out.println("Purchase OK");
    } else throw new IllegalArgumentException("Purchase with a negative number!!");
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            ", nbItems=" + nbItems +
            '}';
  }

  @Override
  public int compareTo(Product o) {
    return Double.compare(this.getPrice(), o.getPrice());
  }

  @Override
  public void applyDiscount() {

  }

  @Override
  public void stopDiscount() {

  }
}

