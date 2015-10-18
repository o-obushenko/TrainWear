package com.oless.trainwear;

import android.app.Application;

import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.parse.ParsingUtils;

import java.util.ArrayList;

/**
 * Created by oless on 10/17/15.
 */
public class TrainWearApplication extends Application {

    private ArrayList<TrainStop> mTrainStopsList;

    @Override
    public void onCreate() {
        super.onCreate();
        mTrainStopsList = ParsingUtils.parseInAllStops(this);
    }

    public ArrayList<TrainStop> getAllTrainStops() {
        return mTrainStopsList;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mTrainStopsList.clear();
    }
}
