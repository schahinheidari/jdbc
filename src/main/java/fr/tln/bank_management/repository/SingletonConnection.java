package fr.tln.bank_management.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SingletonConnection {
    static String DB_URL = null;
    static String USERNAME = null;
    static String PASSWORD = null;
    private static Connection connection = null;
    private SingletonConnection() {

    }
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        DB_URL = resourceBundle.getString("DB_URL");
        USERNAME = resourceBundle.getString("USERNAME");
        PASSWORD = resourceBundle.getString("PASSWORD");

        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

        return connection;
    }
}