package com.vanndeth.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonDB {

    private static String username = "panda";
    private static String password = "panda8888";
    private static Connection connection;

    public static Connection instance(){
        if(connection == null){
            try {
                try {
                    Class.forName("org.postgresql.Driver");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                connection = DriverManager.getConnection("");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
