package database;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Database connection class
 * Used to connect Java with MySQL database
 */

public class DBConnection {

    // Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/school_result_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    // MySQL username
    private static final String USERNAME = "root";

    // MySQL password
    private static final String PASSWORD = "Samiksha5335";

    // Method to establish connection
    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD);
            System.out.println("Database Connection Successful!");

        } catch (Exception e) {

            System.out.println("Database Connection Failed!");
            e.printStackTrace();
        }

        return connection;
    }
}