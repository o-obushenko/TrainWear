package com.oless.trainwear.model;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

/**
 * Created by oless on 10/17/15.
 */
public class TrainStop {

    class PrimitiveLocation {
        double latitude;
        double longitude;

        public PrimitiveLocation(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
    @SerializedName("mapid")
    int mapId;
    @SerializedName("stopid")
    int stopId;
    @SerializedName("station_name")
    String stationName;
    @SerializedName("stop_name")
    String stopName;
    @SerializedName("station_descriptive_name")
    String descriptiveName;
    PrimitiveLocation location;
    @SerializedName("blue")
    boolean isBlue;
    @SerializedName("red")
    boolean isRed;
    @SerializedName("green")
    boolean isGreen;
    @SerializedName("orange")
    boolean isOrange;
    @SerializedName("brown")
    boolean isBrown;
    @SerializedName("yellow")
    boolean isYellow;
    @SerializedName("purple")
    boolean isPurple;
    @SerializedName("pink")
    boolean isPink;

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getDescriptiveName() {
        return descriptiveName;
    }

    public void setDescriptiveName(String descriptiveName) {
        this.descriptiveName = descriptiveName;
    }

    public LatLng getLocation() {

        return new LatLng(location.latitude, location.longitude);
    }

    public void setLocation(Location location) {
        this.location = new PrimitiveLocation(location.getLatitude(), location.getLongitude());
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void setIsBlue(boolean isBlue) {
        this.isBlue = isBlue;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setIsRed(boolean isRed) {
        this.isRed = isRed;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setIsGreen(boolean isGreen) {
        this.isGreen = isGreen;
    }

    public boolean isOrange() {
        return isOrange;
    }

    public void setIsOrange(boolean isOrange) {
        this.isOrange = isOrange;
    }

    public boolean isBrown() {
        return isBrown;
    }

    public void setIsBrown(boolean isBrown) {
        this.isBrown = isBrown;
    }

    public boolean isYellow() {
        return isYellow;
    }

    public void setIsYellow(boolean isYellow) {
        this.isYellow = isYellow;
    }

    public boolean isPurple() {
        return isPurple;
    }

    public void setIsPurple(boolean isPurple) {
        this.isPurple = isPurple;
    }

    public boolean isPink() {
        return isPink;
    }

    public void setIsPink(boolean isPink) {
        this.isPink = isPink;
    }

    @Override
    public String toString() {
        return "TrainStop{" +
                "mapId=" + mapId +
                ", stopId=" + stopId +
                ", stationName='" + stationName + '\'' +
                ", descriptiveName='" + descriptiveName + '\'' +
                ", location=" + location +
                ", isBlue=" + isBlue +
                ", isRed=" + isRed +
                ", isGreen=" + isGreen +
                ", isOrange=" + isOrange +
                ", isBrown=" + isBrown +
                ", isYellow=" + isYellow +
                ", isPurple=" + isPurple +
                ", isPink=" + isPink +
                '}';
    }
}