package com.oless.trainwear;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.parse.ParsingUtils;

import java.util.ArrayList;

/**
 * Created by oless on 10/17/15.
 */
public class TrainWearApplication extends Application {

    private static ArrayList<TrainStop> mTrainStopsList;
    private static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        mTrainStopsList = ParsingUtils.parseInAllStops(this);
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }
    }

    public static ArrayList<TrainStop> getAllTrainStops() {
        return mTrainStopsList;
    }

    public static RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mTrainStopsList.clear();
        mRequestQueue.stop();
    }
}
