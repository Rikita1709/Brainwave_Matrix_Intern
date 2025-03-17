package com.hms.patient; // Correct package declaration

import java.sql.*;

public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String gender;
    private String contactInfo;
    private String medicalHistory;

    // Constructor
    public Patient(String patientId, String name, int age, String gender, String contactInfo, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.medicalHistory = medicalHistory;
    }

    // Getters and Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    // Methods
    public void registerPatient() {
        String sql = "INSERT INTO patient (patient_id, name, age, gender, contact_info, medical_history) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patientId);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, gender);
            pstmt.setString(5, contactInfo);
            pstmt.setString(6, medicalHistory);
            pstmt.executeUpdate();
            System.out.println("Patient Registered: " + name);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Database Connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
    }
}