package com.example.android.afif_updated_apps_1212017;

/**
 * Created by android on 12/01/2017.
 */

public class Lessons {
    private String title,date;

    public  Lessons(){}
    public  Lessons(String title, String date){
        this.title=title;
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

