package com.bbd.modisa.data;

import java.sql.DriverManager;

public class ConnectionConfig {
    public static java.sql.Connection getConnection(){
        java.sql.Connection connection = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankingApp", "root",
                    "root");
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
