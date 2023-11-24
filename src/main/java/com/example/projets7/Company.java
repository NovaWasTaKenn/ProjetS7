package com.example.projets7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {

    static double globalIncome = 0;
    static double globalCosts = 0;
    static double capital = 0;
    static HashMap<String, Integer> stock = new HashMap<String, Integer>();
    static void getglobalIncome(ArrayList<Product> l1){
        for(Product q : l1){
            globalIncome+=q.income;
        }
        System.out.println("Global income of the company is "+globalCosts+" €");
    }
    static void getglobalCosts(ArrayList<Product> l1){
        for(Product q: l1){
            globalCosts+=q.cost;
        }
        System.out.println("Global cost of the company is "+globalCosts+" €");
    }
    static void getCapital(ArrayList<Product> l1){
        getglobalIncome(l1);
        getglobalCosts(l1);
        System.out.println("The capital of the company is "+(globalIncome-globalCosts)+" €");
    }

}
