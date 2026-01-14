package com.college.admission.dao;

import com.college.admission.model.Course;
import com.college.admission.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM COURSE";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Course course = new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_name"),
                    rs.getInt("duration"),
                    rs.getInt("fees")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public Course getCourseById(int courseId) {
        String sql = "SELECT * FROM COURSE WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, courseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Course(
                        rs.getInt("course_id"),
                        rs.getString("course_name"),
                        rs.getInt("duration"),
                        rs.getInt("fees")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
