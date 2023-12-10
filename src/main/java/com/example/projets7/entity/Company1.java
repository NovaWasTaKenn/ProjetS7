package com.example.projets7.entity;

import java.util.ArrayList;
import java.util.List;


public class Company1 {
    public List<Product> lprod;
    public static double Capital;
    public static double globalIncome;
    public static double globalCost;
    public Company1(){
        this.lprod=new ArrayList<Product>();
        this.Capital=20000;
        this.globalIncome=0;
        this.globalCost=0;
    }
    public  double getGlobalIncome() {
        return globalIncome;
    }

    // Setter for globalIncome
    public void setGlobalIncome(double globalIncome) {Company1.globalIncome = Math.round(globalIncome*1000.0)/1000.0;}



    // Getter for globalCosts
    public  double getGlobalCost() {
        return globalCost;
    }

    // Setter for globalCosts
    public void setGlobalCosts(double globalCosts) {Company1.globalCost = Math.round(globalCosts*1000.0)/1000.0;}



    // Getter for capital
    public  double getCapital() {
        return Capital;
    }

    // Setter for capital
    public  void setCapital(double capital) {Company1.Capital = Math.round((Company1.Capital+ capital)*1000.0)/1000.0;}


}
