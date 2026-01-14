package com.college.admission.dao;

import com.college.admission.model.Documents;
import com.college.admission.util.DBConnection;
import java.sql.*;

public class DocumentsDAO {
    
    public void addDocuments(Documents documents) {
        String sql = "INSERT INTO DOCUMENTS (student_id, aadhar_no, tenth_marksheet, twelfth_marksheet, photo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, documents.getStudentId());
            pstmt.setString(2, documents.getAadharNo());
            pstmt.setString(3, documents.getTenthMarksheet());
            pstmt.setString(4, documents.getTwelfthMarksheet());
            pstmt.setString(5, documents.getPhoto());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
