package com.hms.ehr;

import java.sql.*;

public class EHR {
    private String recordId;
    private String patientId;
    private String diagnosis;
    private String prescriptions;
    private String testResults;

    // Constructor
    public EHR(String recordId, String patientId, String diagnosis, String prescriptions, String testResults) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.prescriptions = prescriptions;
        this.testResults = testResults;
    }

    // Getters and Setters
    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getPrescriptions() { return prescriptions; }
    public void setPrescriptions(String prescriptions) { this.prescriptions = prescriptions; }

    public String getTestResults() { return testResults; }
    public void setTestResults(String testResults) { this.testResults = testResults; }

    // Database Connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
    }

    // Add EHR
    public void addRecord() {
        String sql = "INSERT INTO ehr (record_id, patient_id, diagnosis, prescriptions, test_results) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recordId);
            pstmt.setString(2, patientId);
            pstmt.setString(3, diagnosis);
            pstmt.setString(4, prescriptions);
            pstmt.setString(5, testResults);
            pstmt.executeUpdate();
            System.out.println("EHR Added: " + recordId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
