package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {


    public static Connection createConnection() {
        String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=AdventureWorksOBP;encrypt=true;trustServerCertificate=true";
        String user = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Uspješno povezivanje s bazom!");
            }

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}