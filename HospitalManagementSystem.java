package com.hms;

import com.hms.appointment.Appointment;
import com.hms.billing.Billing;
import com.hms.ehr.EHR;
import com.hms.inventory.Inventory;
import com.hms.patient.Patient;
import com.hms.staff.Staff;
import java.util.Scanner;

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Patient Registration");
            System.out.println("2. Appointment Scheduling");
            System.out.println("3. Electronic Health Records");
            System.out.println("4. Billing and Invoicing");
            System.out.println("5. Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Patient patient = new Patient("P001", "John Doe", 30, "Male", "123-456-7890", "None");
                    patient.registerPatient();
                    break;
                case 2:
                    Appointment appointment = new Appointment("A001", "P001", "D001", "2023-10-15", "10:00 AM", "Scheduled");
                    appointment.scheduleAppointment();
                    break;
                case 3:
                    EHR ehr = new EHR("E001", "P001", "Fever", "Paracetamol", "Normal");
                    ehr.addRecord();
                    break;
                case 4:
                    Billing bill = new Billing("B001", "P001", 100.50, "2023-10-15", "Pending");
                    bill.generateBill();
                    break;
                case 5:
                    Inventory supply = new Inventory("S001", "Bandages", 100, "2024-12-31");
                    supply.addSupply();
                    break;
                case 6:
                    Staff staff = new Staff("ST001", "Dr. Smith", "Doctor", "987-654-3210", 5000.00);
                    staff.addStaff();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}