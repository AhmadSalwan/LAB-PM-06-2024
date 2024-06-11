package com.example.tugasprak4;
// utk mngmbil data yg di post
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Post implements Parcelable {
    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>() {
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
    private String description;
    private Uri img;
    private User user;

    public Post(Uri img2, String description2, User user2) {
        this.img = img2;
        this.description = description2;
        this.user = user2;
    }

    protected Post(Parcel in) {
        this.img = (Uri) in.readParcelable(Uri.class.getClassLoader());
        this.description = in.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.img, i);
        parcel.writeString(this.description);
    }

    public Uri getImg() {
        return this.img;
    }

    public void setImg(Uri img2) {
        this.img = img2;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description2) {
        this.description = description2;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }
}