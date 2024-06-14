package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dealershipdatabase";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "YUm15510n";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

    static BasicDataSource dataSource;

    static {
        // Initialize the DataSource
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);

        dataSource = ds;
    }
}
