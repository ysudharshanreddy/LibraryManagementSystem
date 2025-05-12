package com.vcube.Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/batch49";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
