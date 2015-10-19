package com.oless.trainwear.parse;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.oless.trainwear.model.Arrival;
import com.oless.trainwear.model.TrainStop;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by oless on 10/17/15.
 */
public class ParsingUtils {

    public static ArrayList<TrainStop> parseInAllStops(Context context) {
        String mStopString;
        StringBuilder mStringBuilder=new StringBuilder();

        Gson mGson = new Gson();

        try {
             InputStream mJsonInputStream= context.getAssets().open("cta_stop_list");
            BufferedReader in=
                    new BufferedReader(new InputStreamReader(mJsonInputStream, "UTF-8"));
            String str;
            while ((str=in.readLine()) != null) {
                mStringBuilder.append(str);
            }
            mJsonInputStream.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        mStopString = mStringBuilder.toString();

        return mGson.fromJson(mStopString, new TypeToken<ArrayList<TrainStop>>(){}.getType());
    }
}
