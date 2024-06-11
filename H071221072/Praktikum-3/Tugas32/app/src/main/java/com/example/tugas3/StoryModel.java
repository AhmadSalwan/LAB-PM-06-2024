package com.example.tugas3;
public class StoryModel {
    private int imageResource;
    private String username;

    public StoryModel(int imageResource, String username) {
        this.imageResource = imageResource;
        this.username = username;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getUsername() {
        return username;
    }
}


