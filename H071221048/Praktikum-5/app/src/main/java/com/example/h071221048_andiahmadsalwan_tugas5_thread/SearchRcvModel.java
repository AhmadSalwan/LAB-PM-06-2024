package com.example.h071221048_andiahmadsalwan_tugas5_thread;

import android.net.Uri;

public class SearchRcvModel {
    Uri pf_image;
    String name,bio;

    public SearchRcvModel(Uri pf_image, String name, String bio) {
        this.pf_image = pf_image;
        this.name = name;
        this.bio = bio;
    }

    public Uri getPf_image() {
        return pf_image;
    }

    public void setPf_image(Uri pf_image) {
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
}
