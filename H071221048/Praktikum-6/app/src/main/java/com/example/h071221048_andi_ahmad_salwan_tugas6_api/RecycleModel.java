package com.example.h071221048_andi_ahmad_salwan_tugas6_api;

import android.net.Uri;

import retrofit2.http.Url;

public class RecycleModel {
    String avatar,first_name,last_name,email;
    int id;

    public RecycleModel(String avatar, String first_name,String last_name, String email) {
        this.avatar = avatar;
        this.first_name = first_name;
        this.last_name=last_name;
        this.email = email;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String lname) {
        this.first_name = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return avatar;
    }

    public void setImage(String avatar) {
        this.avatar = avatar;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String name) {
        this.first_name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
