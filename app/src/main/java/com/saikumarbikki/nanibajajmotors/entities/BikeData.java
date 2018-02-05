package com.saikumarbikki.nanibajajmotors.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by sbikki on 1/23/2018.
 */

public class BikeData implements Parcelable{

    private String bikeName;
    private int bikeImageResID;
    private String bikeDescription;
    private ArrayList<Integer> bikeFaceImages;
    private ArrayList<Integer> bikeColorAvaliblity;
    private ArrayList<String> bikeColorName;
    private String bikeCapacity;
    private String bikeFuelTankCapacity;
    private String bikeWeight;
    private String bikeMaxPower;


    public ArrayList<String> getBikeColorName() {
        return bikeColorName;
    }

    public void setBikeColorName(ArrayList<String> bikeColorName) {
        this.bikeColorName = bikeColorName;
    }



    public String getBikeMaxPower() {
        return bikeMaxPower;
    }

    public void setBikeMaxPower(String bikeMaxPower) {
        this.bikeMaxPower = bikeMaxPower;
    }


    public String getBikeWeight() {
        return bikeWeight;
    }

    public void setBikeWeight(String bikeWeight) {
        this.bikeWeight = bikeWeight;
    }

    public String getBikeFuelTankCapacity() {
        return bikeFuelTankCapacity;
    }

    public void setBikeFuelTankCapacity(String bikeFuelTankCapacity) {
        this.bikeFuelTankCapacity = bikeFuelTankCapacity;
    }

    public String getBikeCapacity() {
        return bikeCapacity;
    }

    public void setBikeCapacity(String bikeCapacity) {
        this.bikeCapacity = bikeCapacity;
    }

    public static Creator<BikeData> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<BikeData> CREATOR
            = new Creator<BikeData>() {
        @Override
        public BikeData createFromParcel(Parcel in) {
            return new BikeData(in);
        }
        @Override
        public BikeData[] newArray(int size) {
            return new BikeData[size];
        }
    };

    //read all the fields for paraclable
    private BikeData(Parcel in) {
        this.bikeName = in.readString();
        this.bikeDescription=in.readString();
        this.bikeImageResID=in.readInt();
        this.bikeColorAvaliblity=in.readArrayList(Integer.class.getClassLoader());
        this.bikeFaceImages=in.readArrayList(Integer.class.getClassLoader());
        this.bikeCapacity=in.readString();
        this.bikeMaxPower=in.readString();
        this.bikeFuelTankCapacity =in.readString();
        this.bikeWeight=in.readString();
        this.bikeColorName=in.readArrayList(String.class.getClassLoader());
    }



    public ArrayList<Integer> getBikeColorAvaliblity() {
        return bikeColorAvaliblity;
    }

    public void setBikeColorAvaliblity(ArrayList<Integer> bikeColorAvaliblity) {
        this.bikeColorAvaliblity = bikeColorAvaliblity;
    }


    public BikeData(String bikeName, int bikeImageResID, String bikeDescription, ArrayList<Integer> bikeFaceImages) {
        this.bikeName = bikeName;
        this.bikeImageResID = bikeImageResID;
        this.bikeDescription = bikeDescription;
        this.bikeFaceImages = bikeFaceImages;
    }
    public BikeData(String bikeName, int bikeImageResID, String bikeDescription) {
        this.bikeName = bikeName;
        this.bikeImageResID = bikeImageResID;
        this.bikeDescription = bikeDescription;
    }

    public String getBikeName() {
        return bikeName;
    }

    public int getBikeImageResID() {
        return bikeImageResID;
    }

    public String getBikeDescription() {
        return bikeDescription;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public void setBikeImageResID(int bikeImageResID) {
        this.bikeImageResID = bikeImageResID;
    }

    public void setBikeDescription(String bikeDescription) {
        this.bikeDescription = bikeDescription;
    }

    public void setBikeFaceImages(ArrayList<Integer> bikeFaceImages) {
        this.bikeFaceImages = bikeFaceImages;
    }

    public ArrayList<Integer> getBikeFaceImages() {
        return bikeFaceImages;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //write all the feilds to paracalible
        //Need to follow : we need write all the bike specific information in it.
        //This will help to send details from one fragment  to another fragment.
        dest.writeString(bikeName);
        dest.writeInt(bikeImageResID);
        dest.writeString(bikeDescription);
        dest.writeList(bikeFaceImages);
        dest.writeList(bikeColorAvaliblity);
        dest.writeString(bikeCapacity);
        dest.writeString(bikeMaxPower);
        dest.writeString(bikeFuelTankCapacity);
        dest.writeString(bikeWeight);
        dest.writeList(bikeColorName);
    }
}
