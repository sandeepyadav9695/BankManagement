package bank.management.system;
import java.sql.*;

public class Connect {
    Connection conn;
    Statement sat;

    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep", "root", "Sand@123"); 
            sat = conn.createStatement();
        } catch (Exception e) {
        	System.out.println("Database connection error: " + e);
        }
    }
    public Statement getStatement() {
        return sat;
    }
}