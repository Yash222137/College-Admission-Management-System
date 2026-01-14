package com.college.admission.dao;

import com.college.admission.model.Qualification;
import com.college.admission.util.DBConnection;
import java.sql.*;

public class QualificationDAO {
    
    public void addQualification(Qualification qualification) {
        String sql = "INSERT INTO QUALIFICATION (student_id, exam_name, board, passing_year, percentage) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, qualification.getStudentId());
            pstmt.setString(2, qualification.getExamName());
            pstmt.setString(3, qualification.getBoard());
            pstmt.setInt(4, qualification.getPassingYear());
            pstmt.setFloat(5, qualification.getPercentage());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
