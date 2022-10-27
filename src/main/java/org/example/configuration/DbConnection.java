package org.example.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public final Connection connection;

    public DbConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_task",
                                                 "postgres",
                                                 "1234"
        );
    }
    public Connection getConnection() {
        return connection;
    }
}
