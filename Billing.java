package com.hms.billing;

import java.sql.*;

public class Billing {
    private String billId;
    private String patientId;
    private double amount;
    private String date;
    private String status;

    // Constructor
    public Billing(String billId, String patientId, double amount, String date, String status) {
        this.billId = billId;
        this.patientId = patientId;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public String getBillId() { return billId; }
    public void setBillId(String billId) { this.billId = billId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Database Connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
    }

    // Generate Bill
    public void generateBill() {
        String sql = "INSERT INTO billing (bill_id, patient_id, amount, date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, billId);
            pstmt.setString(2, patientId);
            pstmt.setDouble(3, amount);
            pstmt.setString(4, date);
            pstmt.setString(5, status);
            pstmt.executeUpdate();
            System.out.println("Bill Generated: " + billId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
