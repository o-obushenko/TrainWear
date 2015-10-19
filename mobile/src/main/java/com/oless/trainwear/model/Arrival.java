package com.oless.trainwear.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by oless on 10/18/15.
 */
public class Arrival {

    int mRun;
    String mColor;
    int mTrainDirection;
    boolean mIsApproaching;
    boolean mIsScheduled;
    boolean mIsFault;
    boolean mIsDelayed;
    String mArrivalTime;
    String mPredictionTime;
    String mDestStationName;

    public Arrival() {
        mRun = 0;
        mColor = "";
        mTrainDirection = 0;
        mIsApproaching = false;
        mIsScheduled = false;
        mIsFault = false;
        mIsDelayed = false;
        mArrivalTime = "";
        mPredictionTime = "";
        mDestStationName = "";
    }

    public Arrival(int run, String color, int trainDirection, boolean isApproaching, boolean isScheduled, boolean isFault, boolean isDelayed, String arrivalTime, String predictionTime, String destStationName) {
        this.mRun = run;
        this.mColor = color;
        this.mTrainDirection = trainDirection;
        this.mIsApproaching = isApproaching;
        this.mIsScheduled = isScheduled;
        this.mIsFault = isFault;
        this.mIsDelayed = isDelayed;
        this.mArrivalTime = arrivalTime;
        this.mPredictionTime = predictionTime;
        this.mDestStationName = destStationName;
    }

    public int getRun() {
        return mRun;
    }

    public void setRun(int run) {
        this.mRun = run;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        this.mColor = color;
    }

    public int getTrainDirection() {
        return mTrainDirection;
    }

    public void setTrainDirection(int trainDirection) {
        this.mTrainDirection = trainDirection;
    }

    public boolean isApproaching() {
        return mIsApproaching;
    }

    public void setIsApproaching(boolean isApproaching) {
        this.mIsApproaching = isApproaching;
    }

    public boolean isScheduled() {
        return mIsScheduled;
    }

    public void setIsScheduled(boolean isScheduled) {
        this.mIsScheduled = isScheduled;
    }

    public boolean isFault() {
        return mIsFault;
    }

    public void setIsFault(boolean isFault) {
        this.mIsFault = isFault;
    }

    public boolean isDelayed() {
        return mIsDelayed;
    }

    public void setIsDelayed(boolean isDelayed) {
        this.mIsDelayed = isDelayed;
    }

    public String getArrivalTime() {
        return mArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.mArrivalTime = arrivalTime;
    }

    public String getPredictionTime() {
        return mPredictionTime;
    }

    public void setPredictionTime(String predictionTime) {
        this.mPredictionTime = predictionTime;
    }

    public String getDestStationName() {
        return mDestStationName;
    }

    public void setDestStationName(String destStationName) {
        mDestStationName = destStationName;
    }

    public int getArrivalMinutes() {
        DateFormat df = new SimpleDateFormat("yyyyMMdd kk:mm:ss", Locale.ENGLISH);
        try {
            Date result =  df.parse(getArrivalTime());
            long differenceMillis = result.getTime() - System.currentTimeMillis();
            int differenceSeconds = (int) differenceMillis / 1000;
            return (int) Math.round((double) (differenceSeconds/60));
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
