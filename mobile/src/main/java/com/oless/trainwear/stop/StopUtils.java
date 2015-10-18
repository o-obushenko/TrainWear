package com.oless.trainwear.stop;

import com.oless.trainwear.TrainWearApplication;
import com.oless.trainwear.model.TrainStop;

import java.util.ArrayList;

/**
 * Created by oless on 10/17/15.
 */
public class StopUtils {

    public static ArrayList<TrainStop> getStopsByColor(String lineColor) {
        ArrayList<TrainStop> stopsOnLine = new ArrayList<>();
        for (TrainStop stop : TrainWearApplication.getAllTrainStops()) {
            if (stop.getLines().toLowerCase().contains(lineColor.toLowerCase())) {
                stopsOnLine.add(stop);
            }
        }
        return stopsOnLine;
    }
}
