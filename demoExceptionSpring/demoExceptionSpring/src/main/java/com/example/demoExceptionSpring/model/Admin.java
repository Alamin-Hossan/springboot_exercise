package com.example.demoExceptionSpring.model;

public class Admin {
    private int id;
    private String adminName;


    public Admin( int id, String adminName) {
        this.id = id;
        this.adminName = adminName;
    }

    public Admin(String adminName) {
        this.adminName = adminName;
    }

    public Admin() {
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
