package com.college.admission.model;

public class Address {
    private int addressId;
    private int studentId;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address() {}

    public Address(int addressId, int studentId, String houseNo, String street, String city, String state, String pincode) {
        this.addressId = addressId;
        this.studentId = studentId;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public int getAddressId() { return addressId; }
    public void setAddressId(int addressId) { this.addressId = addressId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getHouseNo() { return houseNo; }
    public void setHouseNo(String houseNo) { this.houseNo = houseNo; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }
}
