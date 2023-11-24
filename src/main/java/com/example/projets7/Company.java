package com.example.projets7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {

    static double globalIncome = 0;
    static double globalCosts = 0;
    static double capital = 0;
    static List<Product> listProduct=new ArrayList<>();
    static HashMap<String, Integer> stock = new HashMap<String, Integer>();
    static void getglobalIncome(){
        for(Product q : listProduct){
            globalIncome+=q.income;
        }
        System.out.println("Global income of the company is "+globalCosts+" €");
    }
    static void getglobalCosts(){
        for(Product q: listProduct){
            globalCosts+=q.cost;
        }
        System.out.println("Global cost of the company is "+globalCosts+" €");
    }
    static void getCapital(){
        getglobalIncome();
        getglobalCosts();
        capital=globalIncome-globalCosts;
        System.out.println("The capital of the company is "+capital+" €");
    }

}
