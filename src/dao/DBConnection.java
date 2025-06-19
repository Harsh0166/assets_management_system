/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author ACER
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/ams";
            String user = "root"; 
            String password = "root123"; 

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
        } 
        catch (SQLException e) {
            System.out.println(e);
   
        }

        return conn;
    }
}

