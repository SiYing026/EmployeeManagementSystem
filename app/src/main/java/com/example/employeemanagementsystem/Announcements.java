package com.example.employeemanagementsystem;

public class Announcements {
    private String title, content;

    public Announcements() {

    }

    //Constructor
    public Announcements(String title, String content) {
        this.title = title;
        this.content = content;
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
}
