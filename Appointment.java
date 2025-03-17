package com.hms.appointment;

import java.sql.*;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String date;
    private String time;
    private String status;

    // Constructor
    public Appointment(String appointmentId, String patientId, String doctorId, String date, String time, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    // Getters and Setters
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Database Connection
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
    }

    // Schedule Appointment
    public void scheduleAppointment() {
        String sql = "INSERT INTO appointment (appointment_id, patient_id, doctor_id, date, time, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, appointmentId);
            pstmt.setString(2, patientId);
            pstmt.setString(3, doctorId);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.setString(6, status);
            pstmt.executeUpdate();
            System.out.println("Appointment Scheduled: " + appointmentId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
