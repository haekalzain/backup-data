package com.example.recyclerviewpemainsepakbola.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {

    private String name,born,photo,description,country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Player() {

    }

    protected Player(Parcel in) {
        name = in.readString();
        born = in.readString();
        photo = in.readString();
        description = in.readString();
        country = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(born);
        parcel.writeString(photo);
        parcel.writeString(description);
        parcel.writeString(country);
    }
}
