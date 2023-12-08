package com.example.projets7.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="company_table")
public class Company {

    @Column(name="global_income")
    private static double globalIncome = 0;

    @Column(name="global_cost")
    private static double globalCosts = 0;

    private static double capital = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private List<Product> listProduct;

    // Empty constructor
    public Company() {
    }

    // Getter for globalIncome
    public static double getGlobalIncome() {
        return globalIncome;
    }

    // Setter for globalIncome
    public static void setGlobalIncome(double globalIncome) {
        Company.globalIncome = globalIncome;
    }

    // Getter for globalCosts
    public static double getGlobalCosts() {
        return globalCosts;
    }

    // Setter for globalCosts
    public static void setGlobalCosts(double globalCosts) {
        Company.globalCosts = globalCosts;
    }

    // Getter for capital
    public static double getCapital() {
        return capital;
    }

    // Setter for capital
    public static void setCapital(double capital) {
        Company.capital = capital;
    }




    public static void getCompanyCapital() {
        capital += globalIncome - globalCosts;
        System.out.println("The capital of the company is " + capital + " €");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}

