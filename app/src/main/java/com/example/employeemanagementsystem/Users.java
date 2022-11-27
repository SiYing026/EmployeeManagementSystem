package com.example.employeemanagementsystem;

public class Users {

    //singleton declaration
    private static Users instance = null;

    //variable declaration and initialization
    private String userID = "";
    private String userName = "";
    private String password = "";
    private String department = "";

    private Users(){
        userID = "";
        userName = "";
        password = "";
        department = "";
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    //get singleton instance
    public static Users getInstance(){
        if (instance == null) {
            instance = new Users();
        }
        return instance;
    }
}
