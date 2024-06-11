package com.example.tugaspraktikum2;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    private String nama;
    private String uname;
    private String title;
    private String content;
    private Uri imageUri; // Menyimpan URI gambar

    public Data(String nama, String uname, String title, String content) {
        this.nama = nama;
        this.uname = uname;
        this.title = title;
        this.content = content;
        this.imageUri = imageUri;
    }

    protected Data(Parcel in) {
        nama = in.readString();
        uname = in.readString();
        title = in.readString();
        content = in.readString();
        imageUri = in.readParcelable(Uri.class.getClassLoader()); // Baca URI gambar dari Parcel
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(uname);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeParcelable(imageUri, flags); // Tulis URI gambar ke Parcel
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getUname() {
        return uname;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}