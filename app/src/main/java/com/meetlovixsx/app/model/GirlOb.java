package com.meetlovixsx.app.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GirlOb implements Parcelable {
    private String name;
    private String about;
    private int img;

    public GirlOb(String name, String about, int img) {
        this.name = name;
        this.about = about;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public int getImg() {
        return img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.about);
        dest.writeInt(this.img);
    }

    public GirlOb() {
    }

    protected GirlOb(Parcel in) {
        this.name = in.readString();
        this.about = in.readString();
        this.img = in.readInt();
    }

    public static final Creator<GirlOb> CREATOR = new Creator<GirlOb>() {
        @Override
        public GirlOb createFromParcel(Parcel source) {
            return new GirlOb(source);
        }

        @Override
        public GirlOb[] newArray(int size) {
            return new GirlOb[size];
        }
    };
}
