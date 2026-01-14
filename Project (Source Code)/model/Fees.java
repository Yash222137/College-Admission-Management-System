package com.college.admission.model;

public class Fees {
    private int feeId;
    private int studentId;
    private int totalFees;
    private int paid;
    private int balance;

    public Fees() {}

    public Fees(int feeId, int studentId, int totalFees, int paid, int balance) {
        this.feeId = feeId;
        this.studentId = studentId;
        this.totalFees = totalFees;
        this.paid = paid;
        this.balance = balance;
    }

    public int getFeeId() { return feeId; }
    public void setFeeId(int feeId) { this.feeId = feeId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getTotalFees() { return totalFees; }
    public void setTotalFees(int totalFees) { this.totalFees = totalFees; }

    public int getPaid() { return paid; }
    public void setPaid(int paid) { this.paid = paid; }

    public int getBalance() { return balance; }
    public void setBalance(int balance) { this.balance = balance; }
}
