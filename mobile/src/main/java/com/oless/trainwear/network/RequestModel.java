package com.oless.trainwear.network;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.oless.trainwear.BuildConfig;
import com.oless.trainwear.callback.OnArrivalLoaded;
import com.oless.trainwear.constant.UrlConstants;
import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.url.UrlUtils;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by oless on 10/17/15.
 */
public class RequestModel {

    public static final String TAG = "RequestModel";

    public static StringRequest requestArrivalsForStop(TrainStop trainStop, final OnArrivalLoaded callback) {
        HashMap<String,String> params = new HashMap<String, String>();
        params.put("key", BuildConfig.CTA_TRAIN_API_KEY);
        params.put("max", "5");
        if (trainStop.getMapId() != 0) {
            params.put("mapid", ((Integer) trainStop.getMapId()).toString());
        }
        if (trainStop.getStopId() != 0) {
            params.put("stpid", ((Integer) trainStop.getStopId()).toString());
        }
        int directionInt = (((Character) trainStop.getDirection()) == 'N' || ((Character) trainStop.getDirection()) == 'E') ? 5 : 1;
        String url = UrlConstants.ARRIVAL_BASE_URL;
        url += "?" + UrlUtils.generateParamString(params);

        Log.d(TAG, url);
        return new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callback.onArrivalLoaded(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onArrivalFailure();
            }
        });
    }
}
