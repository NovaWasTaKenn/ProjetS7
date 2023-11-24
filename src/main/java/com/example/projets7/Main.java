package com.example.projets7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Product p1 = new Shoes("s1", 10.0, 10, 38);
            Product p2 = new Clothes("c1", 20.0, 20, 36);
            Product[] tab = new Product[]{p1, p2};
            Product[] var4 = tab;
            int var5 = tab.length;

            int var6;
            Product p;
            for(var6 = 0; var6 < var5; ++var6) {
                p = var4[var6];
                System.out.println(p);
            }

            p1.sell(9);
            p2.purchase(10);
            System.out.println(Product.getIncome());
            p1.applyDiscount();
            p2.applyDiscount();
            var4 = tab;
            var5 = tab.length;

            for(var6 = 0; var6 < var5; ++var6) {
                p = var4[var6];
                System.out.println(p);
            }

            System.out.println();
            List<Product> productList = new ArrayList();
            productList.add(p2);
            productList.add(p1);
            System.out.println(productList);
            productList.sort((Comparator)null);
            System.out.println(productList);
        } catch (IllegalArgumentException var8) {
            System.out.println(var8.getMessage());
        }

    }
}
