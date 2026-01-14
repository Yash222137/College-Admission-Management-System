package com.college.admission.model;

public class Qualification {
    private int qId;
    private int studentId;
    private String examName;
    private String board;
    private int passingYear;
    private float percentage;

    public Qualification() {}

    public Qualification(int qId, int studentId, String examName, String board, int passingYear, float percentage) {
        this.qId = qId;
        this.studentId = studentId;
        this.examName = examName;
        this.board = board;
        this.passingYear = passingYear;
        this.percentage = percentage;
    }

    public int getQId() { return qId; }
    public void setQId(int qId) { this.qId = qId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }

    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }

    public int getPassingYear() { return passingYear; }
    public void setPassingYear(int passingYear) { this.passingYear = passingYear; }

    public float getPercentage() { return percentage; }
    public void setPercentage(float percentage) { this.percentage = percentage; }
}
