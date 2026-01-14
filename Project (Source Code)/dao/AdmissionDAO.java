package com.college.admission.dao;

import com.college.admission.model.Admission;
import com.college.admission.util.DBConnection;
import java.sql.*;

public class AdmissionDAO {
    
    public int addStudent(Admission admission) {
        String sql = "INSERT INTO ADMISSION (name, father_name, dob, gender, course_id, mobile) VALUES (?, ?, ?, ?, ?, ?)";
        int studentId = -1;
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, admission.getName());
            pstmt.setString(2, admission.getFatherName());
            pstmt.setDate(3, admission.getDob());
            pstmt.setString(4, admission.getGender());
            pstmt.setInt(5, admission.getCourseId());
            pstmt.setString(6, admission.getMobile());
            
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        studentId = generatedKeys.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentId;
    }

    public Admission getStudentById(int studentId) {
        String sql = "SELECT * FROM ADMISSION WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
             pstmt.setInt(1, studentId);
             ResultSet rs = pstmt.executeQuery();
             if (rs.next()) {
                 return new Admission(
                     rs.getInt("student_id"),
                     rs.getString("name"),
                     rs.getString("father_name"),
                     rs.getDate("dob"),
                     rs.getString("gender"),
                     rs.getInt("course_id"),
                     rs.getString("mobile")
                 );
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
