package com.college.admission.model;

import java.sql.Date;

public class Admission {
    private int studentId;
    private String name;
    private String fatherName;
    private Date dob;
    private String gender;
    private int courseId;
    private String mobile;

    public Admission() {}

    public Admission(int studentId, String name, String fatherName, Date dob, String gender, int courseId, String mobile) {
        this.studentId = studentId;
        this.name = name;
        this.fatherName = fatherName;
        this.dob = dob;
        this.gender = gender;
        this.courseId = courseId;
        this.mobile = mobile;
    }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFatherName() { return fatherName; }
    public void setFatherName(String fatherName) { this.fatherName = fatherName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
}

