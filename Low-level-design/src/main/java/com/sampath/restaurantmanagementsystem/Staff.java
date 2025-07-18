package com.sampath.restaurantmanagementsystem;

public class Staff {
    private int empId;
    private String name;
    private String role;
    private String contactNumber;

    public Staff(int empId, String name, String role, String contactNumber) {
        this.empId = empId;
        this.name = name;
        this.role = role;
        this.contactNumber = contactNumber;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }
}
