package com.example.schoolnotes;

import java.io.Serializable;

public class Assignment implements Serializable {
    private String title, dueDate;

    Assignment(String title, String dueDate){
        this.title = title;
        this.dueDate = dueDate;
    }


    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

}
