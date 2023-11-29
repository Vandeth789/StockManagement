package com.vanndeth.utils;

import java.sql.*;

public class MainDB {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dbbanking";
        String username = "postgres";
        String password = "root101001";
        try {
            // Register driver
            Class.forName("org.postgresql.Driver");

            // Established Connection
            try (Connection connection = DriverManager.getConnection(url, username, password);){
                System.out.println("Established Connection");
                System.out.println(connection.getSchema());

                // Create statement object
                PreparedStatement statement = connection.prepareStatement("SELECT  * FROM account WHERE account_id = ? AND accounts_name = ?");

                statement.setLong(1,25);
                statement.setString(2, "VIP DCoder Panda");

                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()){
                    System.out.println(resultSet.getLong("account_id"));
                    System.out.println(resultSet.getString("accounts_name"));
                    System.out.println(resultSet.getDate("date_opened"));
                }
            }
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
