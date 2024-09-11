package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/demo_crud";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void exampleQuery() {
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
