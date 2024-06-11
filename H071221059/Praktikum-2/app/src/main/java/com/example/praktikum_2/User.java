package com.example.praktikum_2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class User implements Parcelable {
    private Uri imageProfile;
    private String name;
    private String username;

    public User(String name, String username, Uri imageProfile){
        this.imageProfile = imageProfile;
        this.name = name;
        this.username = username;
    }

    public User(Uri imageProfile){
        this.imageProfile = imageProfile;
    }

    protected User(Parcel in) {
        imageProfile = in.readParcelable(Uri.class.getClassLoader());
        name = in.readString();
        username = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Uri getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(Uri imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeParcelable(imageProfile, flags);
        dest.writeString(name);
        dest.writeString(username);
    }
}
