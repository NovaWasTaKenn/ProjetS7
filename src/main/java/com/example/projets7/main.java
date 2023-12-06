package com.example.projets7;

import com.example.projets7.entity.Accessories;
import com.example.projets7.entity.Clothes;
import com.example.projets7.entity.Product;
import com.example.projets7.entity.Shoes;
import com.example.projets7.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {


        Clothes product = new Clothes("clothes3", 1.0, 1.0, 1.0, 10, 36);
        Clothes product1 = new Clothes("clothes2", 1.0, 1.0, 1.0, 10, 44);
        Shoes product2 = new Shoes("shoe1", 1.0, 1.0, 1.0, 10, 42);
        Shoes product3 = new Shoes("shoe2", 1.0, 1.0, 1.0, 10, 44);


        System.out.println(product);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the book objects
            session.persist(product);
            session.persist(product1);
            session.persist(product2);
            session.persist(product3);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        ArrayList<Product> books = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            books = (ArrayList<Product>) session.createQuery("from Product", Product.class).list();

            System.out.println(books);

        } catch (Exception e) {
            System.out.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            for (Product item: books) {
                session.remove(item);
            }

        } catch (Exception e) {
            System.out.println(e);
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        //session.flush() synbchronise avec la db
        //session.clear() clear le cache force de nouvelles query
        //Importants
    }


}
