package com.example.employeemanagementsystem;

public class Claims {

    private String userid, title, content, amount, status;

    public Claims() {

    }

    public Claims(String userid, String title, String content, String amount, String status) {
        this.userid = userid;
        this.title = title;
        this.content = content;
        this.amount = amount;
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
