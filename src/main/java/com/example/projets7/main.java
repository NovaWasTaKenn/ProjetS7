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


        Clothes product = new Clothes("clothes4", 1.0, 1.0, 1.0, 10, 36);
        Clothes product1 = new Clothes("clothes5", 1.0, 1.0, 1.0, 10, 44);
        Shoes product2 = new Shoes("shoe6", 1.0, 1.0, 1.0, 10, 42);
        Shoes product3 = new Shoes("shoe7", 1.0, 1.0, 1.0, 10, 44);


        System.out.println(product);
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);


        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            // save the book objects
            transaction = session.beginTransaction();
            session.persist(product);
            session.persist(product1);
            session.persist(product2);
            session.persist(product3);
            transaction.commit();
            // commit transaction

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

            transaction = session.beginTransaction();
            for (Product item: books) {
                session.remove(item);
            }
            transaction.commit();

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
