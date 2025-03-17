package com.hms.inventory;

import java.sql.*;

public class Inventory {
    private String supplyId;
    private String name;
    private int quantity;
    private String expiryDate;

    // Constructor
    public Inventory(String supplyId, String name, int quantity, String expiryDate) {
        this.supplyId = supplyId;
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters
    public String getSupplyId() { return supplyId; }
    public void setSupplyId(String supplyId) { this.supplyId = supplyId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    // Database Connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
    }

    // Add Supply
    public void addSupply() {
        String sql = "INSERT INTO inventory (supply_id, name, quantity, expiry_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, supplyId);
            pstmt.setString(2, name);
            pstmt.setInt(3, quantity);
            pstmt.setString(4, expiryDate);
            pstmt.executeUpdate();
            System.out.println("Supply Added: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
