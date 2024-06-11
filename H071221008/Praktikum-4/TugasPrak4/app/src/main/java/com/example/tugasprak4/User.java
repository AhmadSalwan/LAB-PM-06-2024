package com.example.tugasprak4;
// get dan setter utk ambil data dri profilefrag
import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private String name;
    private int profileImg;
    private String username;

    public User(String name2, String username2, int profileImg2) {
        this.name = name2;
        this.username = username2;
        this.profileImg = profileImg2;
    }

    protected User(Parcel in) {
        this.name = in.readString();
        this.username = in.readString();
        this.profileImg = in.readInt();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username2) {
        this.username = username2;
    }

    public int getProfileImg() {
        return this.profileImg;
    }

    public void setProfileImg(int profileImg2) {
        this.profileImg = profileImg2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.username);
        parcel.writeInt(this.profileImg);
    }
}
