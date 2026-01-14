package com.college.admission.dao;

import com.college.admission.model.Address;
import com.college.admission.util.DBConnection;
import java.sql.*;

public class AddressDAO {
    
    public void addAddress(Address address) {
        String sql = "INSERT INTO ADDRESS (student_id, house_no, street, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, address.getStudentId());
            pstmt.setString(2, address.getHouseNo());
            pstmt.setString(3, address.getStreet());
            pstmt.setString(4, address.getCity());
            pstmt.setString(5, address.getState());
            pstmt.setString(6, address.getPincode());
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

