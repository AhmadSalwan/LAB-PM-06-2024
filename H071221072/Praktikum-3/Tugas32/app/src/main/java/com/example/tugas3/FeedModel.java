package com.example.tugas3;
public class FeedModel {
    private int ivlogo;
    private int ivfeed;
    private String username;

    public FeedModel(int ivlogo, int ivfeed, String username) {
        this.ivlogo = ivlogo;
        this.ivfeed = ivfeed;
        this.username = username;

    }
    public int getIvlogo() {
        return ivlogo;
    }

    public int getIvfeed() {
        return ivfeed;
    }

    public String getUsername() {
        return username;
    }
}

