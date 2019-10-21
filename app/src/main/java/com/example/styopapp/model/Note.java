package com.example.styopapp.model;

import java.util.Date;

public class Note {
    private long id;
    private Date date;
    private String text;
    private String title;
    private int drawableIdRes;

    public Note(long id, Date date, String text, String title, int drawableIdRes) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.title = title;
        this.drawableIdRes = drawableIdRes;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public int getDrawableIdRes() {
        return drawableIdRes;
    }
}
