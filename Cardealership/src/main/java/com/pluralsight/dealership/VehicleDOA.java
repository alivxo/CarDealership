package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDOA {
    private BasicDataSource dataSource;

    public VehicleDOA(String username, String password) {

        this.dataSource = new BasicDataSource();

        // Configure the datasource
        dataSource.setUrl("jdbc:mysql://localhost:3306/dealershipdatabase");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxTotal(25);
    }

    public List<Vehicle> searchVehiclesByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE price BETWEEN ? AND ?";
        Connection connection = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, minPrice);
            pstmt.setDouble(2, maxPrice);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vehicles.add(new Vehicle(rs.getInt("id"), rs.getString("make"), rs.getString("model"), rs.getInt("year"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Additional methods for other search criteria can be similarly implemented
    // Example for make/model search
    public List<Vehicle> searchVehiclesByMakeAndModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?";
        Connection connection = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, make);
            pstmt.setString(2, model);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                vehicles.add(new Vehicle(rs.getInt("id"), rs.getString("make"), rs.getString("model"), rs.getInt("year"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // You should close the connection when it's no longer needed
    public void closeConnection() {
        try {
            if (dataSource != null && !dataSource.isClosed()) {
                dataSource.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


