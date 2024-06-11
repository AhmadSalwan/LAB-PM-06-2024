package com.example.tugas3;

public class ProfileModel {
    private int ivLogo, ivFeed;
    private String tvPosts,tvFollowers,tvFollowing,tvUsername,tvBio;

    public ProfileModel(int ivLogo, int ivFeed, String tvPosts, String tvFollowers, String tvFollowing, String tvUsername, String tvBio) {
        this.ivLogo = ivLogo;
        this.ivFeed = ivFeed;
        this.tvPosts = tvPosts;
        this.tvFollowers = tvFollowers;
        this.tvFollowing = tvFollowing;
        this.tvUsername = tvUsername;
        this.tvBio = tvBio;
    }

    public int getIvLogo() {
        return ivLogo;
    }

    public int getIvFeed() {
        return ivFeed;
    }

    public String getTvPosts() {
        return tvPosts;
    }

    public String getTvFollowers() {
        return tvFollowers;
    }

    public String getTvFollowing() {
        return tvFollowing;
    }

    public String getTvUsername() {
        return tvUsername;
    }

    public String getTvBio() {
        return tvBio;
    }

}
