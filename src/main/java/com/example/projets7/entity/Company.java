package com.example.projets7.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company_table")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Transient
    public List<Product> lprod;
    @Column(name = "Capital", nullable = true)
    public double Capital;
    @Column(name = "globalIncome", nullable = true)
    public double globalIncome;
    @Column(name = "globalCost", nullable = true)
    public double globalCost;
    public Company(){
        this.lprod=new ArrayList<Product>();
        this.Capital=20000;
        this.globalIncome=0;
        this.globalCost=0;
    }
    public  double getGlobalIncome() {
        return this.globalIncome;
    }

    // Setter for globalIncome
    public void setGlobalIncome(double globalIncome) {
        this.globalIncome = Math.round(globalIncome*1000.0)/1000.0;}



    // Getter for globalCosts
    public  double getGlobalCost() {
        return globalCost;
    }

    // Setter for globalCosts
    public void setGlobalCosts(double globalCosts) {
        this.globalCost = Math.round(globalCosts*1000.0)/1000.0;}



    // Getter for capital
    public  double getCapital() {
        return this.Capital;
    }

    // Setter for capital
    public  void setCapital(double amount) {
        this.Capital = Math.round((this.Capital+ amount)*1000.0)/1000.0;}


}
