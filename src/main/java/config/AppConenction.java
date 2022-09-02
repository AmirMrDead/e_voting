package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppConenction {
    private static Connection connection;

    static {
        try {
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/e_voiting",
                            "postgres",
                            "qazwsx123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

