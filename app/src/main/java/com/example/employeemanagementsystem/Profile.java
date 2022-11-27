package com.example.employeemanagementsystem;

public class Profile {

    private String userid, department, username;

    public Profile() {

    }

    public Profile(String userid, String department, String username) {
        this.userid = userid;
        this.department = department;
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
