package com.sampath.lockersystem;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String contact;

    public Customer(String customerId, String name, String email, String contact) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
