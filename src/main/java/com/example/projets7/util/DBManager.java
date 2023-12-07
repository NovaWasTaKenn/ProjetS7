package com.example.projets7.util;

import com.example.projets7.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {


        private String databaseName = "projet_s7";
        private String user = "root";
        private String password = "admin1";

        public List<Product> loadProduct(){
            List<Product> studentAll= new ArrayList<Product>();
            Connection myConn= this.Connector();
            try {
                Statement myStmt= myConn.createStatement();
                String sql = "select * from produt_table";
                ResultSet myRs= myStmt.executeQuery(sql);
                while (myRs.next()) {
                    //Product product= new Product(myRs.getInt("id"),myRs.getString("name"),
                      //      myRs.getString("gender"));
                    //studentAll.add(s);
                }
                this.close(myConn, myStmt, myRs);
                return studentAll;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        public Connection Connector(){
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/"+databaseName+"?serverTimezone=Europe%2FParis",
                        user,
                        password);
                return connection;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
            try {
                if (myStmt != null)
                    myStmt.close();
                if (myRs != null)
                    myRs.close();
                if (myConn != null)
                    myConn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


}
