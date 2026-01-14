package com.college.admission.dao;

import com.college.admission.model.Fees;
import com.college.admission.util.DBConnection;
import java.sql.*;

public class FeesDAO {
    
    public void addFees(Fees fees) {
        String sql = "INSERT INTO FEES (student_id, total_fees, paid, balance) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, fees.getStudentId());
            pstmt.setInt(2, fees.getTotalFees());
            pstmt.setInt(3, fees.getPaid());
            pstmt.setInt(4, fees.getBalance());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
