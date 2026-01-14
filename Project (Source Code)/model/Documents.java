package com.college.admission.model;

public class Documents {
    private int docId;
    private int studentId;
    private String aadharNo;
    private String tenthMarksheet;
    private String twelfthMarksheet;
    private String photo;

    public Documents() {}

    public Documents(int docId, int studentId, String aadharNo, String tenthMarksheet, String twelfthMarksheet, String photo) {
        this.docId = docId;
        this.studentId = studentId;
        this.aadharNo = aadharNo;
        this.tenthMarksheet = tenthMarksheet;
        this.twelfthMarksheet = twelfthMarksheet;
        this.photo = photo;
    }

    public int getDocId() { return docId; }
    public void setDocId(int docId) { this.docId = docId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getAadharNo() { return aadharNo; }
    public void setAadharNo(String aadharNo) { this.aadharNo = aadharNo; }

    public String getTenthMarksheet() { return tenthMarksheet; }
    public void setTenthMarksheet(String tenthMarksheet) { this.tenthMarksheet = tenthMarksheet; }

    public String getTwelfthMarksheet() { return twelfthMarksheet; }
    public void setTwelfthMarksheet(String twelfthMarksheet) { this.twelfthMarksheet = twelfthMarksheet; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
}
