package com.example.employeemanagementsystem;

public class Leaves {

    private String username, startDate, endDate, noOfDay, type, reason, status;

    public Leaves(){

    }

    public Leaves(String username, String startDate, String endDate, String noOfDay, String type, String reason) {
        this.username = username;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfDay = noOfDay;
        this.type = type;
        this.reason = reason;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNoOfDay() {
        return noOfDay;
    }

    public void setNoOfDay(String noOfDay) {
        this.noOfDay = noOfDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}



