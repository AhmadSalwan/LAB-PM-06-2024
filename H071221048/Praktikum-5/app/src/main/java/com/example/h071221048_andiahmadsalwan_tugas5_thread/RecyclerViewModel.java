package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.net.Uri;

public class RecyclerViewModel {
    int pf_image;
    String name,bio,comment;
    Uri image;

    public RecyclerViewModel(int pf_image, String name, String bio, String comment, Uri image) {
        this.pf_image = pf_image;
        this.name = name;
        this.bio = bio;
        this.comment = comment;
        this.image = image;
    }

    public int getPf_image() {
        return pf_image;
    }

    public void setPf_image(int pf_image) {
        this.pf_image = pf_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getComment() {
        return comment;
    }

    public void setFulldesc(String comment) {
        this.comment = comment;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
