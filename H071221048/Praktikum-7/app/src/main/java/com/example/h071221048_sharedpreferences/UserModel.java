package com.example.h071221048_sharedpreferences;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    String pw,nim;
    boolean isDark;

    public UserModel(){};

    protected UserModel(Parcel in) {
        this.pw=in.readString();
        this.nim=in.readString();
        this.isDark=in.readByte()!=0;

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pw);
        dest.writeString(nim);
        dest.writeInt((byte)(isDark?1:0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel source) {
            return new UserModel(source);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public boolean isDark() {
        return isDark;
    }

    public void setDark(boolean dark) {
        isDark = dark;
    }
}
