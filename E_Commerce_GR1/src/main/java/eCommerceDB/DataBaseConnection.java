package eCommerceDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/gadgetdb"; 
    private static final String USERNAME = "root"; 
    private static final String PASSWORD = "";     
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Success: Connected to the MySQL Database!");
            
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MySQL JDBC Driver not found!");
        } catch (SQLException e) {
            System.out.println("Error: Failed to connect to the database server.");
        }
        return connection;
    }
}