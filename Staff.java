package com.hms.staff;

import java.sql.*;

public class Staff {
    private String staffId;
    private String name;
    private String role;
    private String contactInfo;
    private double salary;

    // Constructor
    public Staff(String staffId, String name, String role, String contactInfo, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
        this.contactInfo = contactInfo;
        this.salary = salary;
    }

    // Getters and Setters
    public String getStaffId() { return staffId; }
    public void setStaffId(String staffId) { this.staffId = staffId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    // Database Connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
    }

    // Add Staff
    public void addStaff() {
        String sql = "INSERT INTO staff (staff_id, name, role, contact_info, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffId);
            pstmt.setString(2, name);
            pstmt.setString(3, role);
            pstmt.setString(4, contactInfo);
            pstmt.setDouble(5, salary);
            pstmt.executeUpdate();
            System.out.println("Staff Added: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}