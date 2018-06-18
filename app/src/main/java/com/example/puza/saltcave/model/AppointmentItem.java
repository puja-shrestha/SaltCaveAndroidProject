package com.example.puza.saltcave.model;

public class AppointmentItem {
    private int Image;
    private String name;

    public AppointmentItem(int image, String name) {
        Image = image;
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
