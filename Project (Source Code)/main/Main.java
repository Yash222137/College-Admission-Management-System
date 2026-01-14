package com.college.admission.main;

import com.college.admission.dao.*;
import com.college.admission.model.*;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CourseDAO courseDAO = new CourseDAO();
    private static AdmissionDAO admissionDAO = new AdmissionDAO();
    private static AddressDAO addressDAO = new AddressDAO();
    private static QualificationDAO qualificationDAO = new QualificationDAO();
    private static FeesDAO feesDAO = new FeesDAO();
    private static DocumentsDAO documentsDAO = new DocumentsDAO();

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   COLLEGE ADMISSION MANAGEMENT SYSTEM    ");
        System.out.println("==========================================");

        while (true) {
            System.out.println("\nMAIN MENU:");
            System.out.println("1. New Admission");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Student (Not Implemented in UI Demo)");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            
            int choice = readInt();

            switch (choice) {
                case 1:
                    performAdmission();
                    break;
                case 2:
                    viewCourses();
                    break;
                case 3:
                    System.out.println("Feature coming soon...");
                    break;
                case 4:
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void viewCourses() {
        List<Course> courses = courseDAO.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available or Database connection failed.");
            return;
        }
        System.out.println("\n--- Available Courses ---");
        for (Course c : courses) {
            System.out.println(c);
        }
    }

    private static void performAdmission() {
        System.out.println("\n--- NEW ADMISSION FORM ---");
        
        // 1. Course Selection
        viewCourses();
        System.out.print("Enter Course ID to apply for: ");
        int courseId = readInt();
        Course selectedCourse = courseDAO.getCourseById(courseId);
        
        if (selectedCourse == null) {
            System.out.println("Invalid Course ID. Aborting Admission.");
            return;
        }

        // 2. Personal Details
        System.out.println("Enter Personal Details:");
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Father's Name: ");
        String fatherName = scanner.nextLine();
        System.out.print("Date of Birth (YYYY-MM-DD): ");
        Date dob = readDate();
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Mobile Number: ");
        String mobile = scanner.nextLine();

        Admission admission = new Admission(0, name, fatherName, dob, gender, courseId, mobile);
        int studentId = admissionDAO.addStudent(admission);

        if (studentId == -1) {
            System.out.println("Error saving student details. Aborting.");
            return;
        }
        System.out.println("Student Basic Details Saved. ID generated: " + studentId);

        // 3. Address Details
        System.out.println("\nEnter Address Details:");
        System.out.print("House No: ");
        String houseNo = scanner.nextLine();
        System.out.print("Street: ");
        String street = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Pincode: ");
        String pincode = scanner.nextLine();

        Address address = new Address(0, studentId, houseNo, street, city, state, pincode);
        addressDAO.addAddress(address);

        // 4. Qualification Details
        System.out.println("\nEnter 10th Standard Details:");
        System.out.print("Board: ");
        String board10 = scanner.nextLine();
        System.out.print("Passing Year: ");
        int year10 = readInt();
        System.out.print("Percentage: ");
        float pct10 = readFloat();
        qualificationDAO.addQualification(new Qualification(0, studentId, "10th", board10, year10, pct10));

        System.out.println("Enter 12th Standard Details:");
        System.out.print("Board: ");
        String board12 = scanner.nextLine();
        System.out.print("Passing Year: ");
        int year12 = readInt();
        System.out.print("Percentage: ");
        float pct12 = readFloat();
        qualificationDAO.addQualification(new Qualification(0, studentId, "12th", board12, year12, pct12));

        // 5. Fees Details
        System.out.println("\nFees Payment:");
        System.out.println("Total Fees for " + selectedCourse.getCourseName() + ": " + selectedCourse.getFees());
        System.out.print("Enter Amount Paying Now: ");
        int paid = readInt();
        int balance = selectedCourse.getFees() - paid;
        
        Fees fees = new Fees(0, studentId, selectedCourse.getFees(), paid, balance);
        feesDAO.addFees(fees);

        // 6. Documents
        System.out.println("\nDocument Submission (Enter Filenames):");
        System.out.print("Aadhaar Number: ");
        String aadhar = scanner.nextLine();
        System.out.print("10th Marksheet Filename: ");
        String doc10 = scanner.nextLine();
        System.out.print("12th Marksheet Filename: ");
        String doc12 = scanner.nextLine();
        System.out.print("Photo Filename: ");
        String photo = scanner.nextLine();

        Documents docs = new Documents(0, studentId, aadhar, doc10, doc12, photo);
        documentsDAO.addDocuments(docs);

        System.out.println("\n========================================");
        System.out.println("   ADMISSION COMPLETED SUCCESSFULLY!    ");
        System.out.println("========================================");
    }

    // --- Helper Methods for Input Validation ---

    private static int readInt() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid integer: ");
            }
        }
    }

    private static float readFloat() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Please enter a valid decimal: ");
            }
        }
    }

    private static Date readDate() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Date.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid date format (YYYY-MM-DD). Try again: ");
            }
        }
    }
}

