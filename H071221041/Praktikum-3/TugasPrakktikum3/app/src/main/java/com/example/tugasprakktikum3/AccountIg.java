package com.example.tugasprakktikum3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class AccountIg implements Parcelable {
    private String nama, caption;
    private Integer imageProfile, imageFeed, imageStory, followers, following;

    public AccountIg(String nama, String caption, Integer imageProfile, Integer imageFeed, Integer imageStory, Integer followers, Integer following) {
        this.nama = nama;
        this.caption = caption;
        this.imageProfile = imageProfile;
        this.imageFeed = imageFeed;
        this.imageStory = imageStory;
        this.followers = followers;
        this.following = following;
    }

    protected AccountIg(Parcel in) {
        nama = in.readString();
        caption = in.readString();
        if (in.readByte() == 0) {
            imageProfile = null;
        } else {
            imageProfile = in.readInt();
        }
        if (in.readByte() == 0) {
            imageFeed = null;
        } else {
            imageFeed = in.readInt();
        }
        if (in.readByte() == 0) {
            imageStory = null;
        } else {
            imageStory = in.readInt();
        }
        if (in.readByte() == 0) {
            followers = null;
        } else {
            followers = in.readInt();
        }
        if (in.readByte() == 0) {
            following = null;
        } else {
            following = in.readInt();
        }
    }

    public static final Creator<AccountIg> CREATOR = new Creator<AccountIg>() {
        @Override
        public AccountIg createFromParcel(Parcel in) {
            return new AccountIg(in);
        }

        @Override
        public AccountIg[] newArray(int size) {
            return new AccountIg[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(caption);
        if (imageProfile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageProfile);
        }
        if (imageFeed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageFeed);
        }
        if (imageStory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageStory);
        }
        if (followers == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(followers);
        }
        if (following == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(following);
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(Integer imageProfile) {
        this.imageProfile = imageProfile;
    }

    public Integer getImageFeed() {
        return imageFeed;
    }

    public void setImageFeed(Integer imageFeed) {
        this.imageFeed = imageFeed;
    }

    public Integer getImageStory() {
        return imageStory;
    }

    public void setImageStory(Integer imageStory) {
        this.imageStory = imageStory;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }
}
