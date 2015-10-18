package com.oless.trainwear.network;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.oless.trainwear.BuildConfig;
import com.oless.trainwear.constant.UrlConstants;
import com.oless.trainwear.url.UrlUtils;

import java.util.HashMap;

/**
 * Created by oless on 10/17/15.
 */
public class RequestModel {

    public static StringRequest requestArrivalsForStop(String mapId, String stopId, String route) {
        HashMap<String,String> params = new HashMap<String, String>();
        params.put("key", BuildConfig.CTA_TRAIN_API_KEY);
        params.put("max", "5");
        if (!mapId.isEmpty()) {
            params.put("mapid", mapId);
        }
        if (!stopId.isEmpty()) {
            params.put("stpid", stopId);
        }
        if (!route.isEmpty()) {
            params.put("rt", route);
        }
        String url = UrlConstants.ARRIVAL_BASE_URL;
        url += "?" + UrlUtils.generateParamString(params);
        return new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
