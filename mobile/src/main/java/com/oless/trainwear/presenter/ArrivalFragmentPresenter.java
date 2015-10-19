package com.oless.trainwear.presenter;

import com.android.volley.toolbox.StringRequest;
import com.oless.trainwear.TrainWearApplication;
import com.oless.trainwear.adapter.ArrivalAdapter;
import com.oless.trainwear.callback.OnArrivalLoaded;
import com.oless.trainwear.fragment.ArrivalFragment;
import com.oless.trainwear.model.Arrival;
import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.network.RequestModel;
import com.oless.trainwear.parse.ArrivalParser;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by oless on 10/18/15.
 */
public class ArrivalFragmentPresenter extends FragmentPresenter {

    ArrivalFragment mFragment;
    Context mContext;
    ListView mArrivalListView = null;
    TextView mResponseTextView = null;
    TrainStop mTrainStop = null;
    ArrayList<Arrival> mArrivalArrayList;
    ArrivalAdapter mArrivalAdapter;

    public ArrivalFragmentPresenter(ArrivalFragment fragment, Context context) {
        mFragment = fragment;
        mContext = context;
    }

    public void addTrainStop(TrainStop stop) {
        mTrainStop = stop;
    }
    @Override
    public void init() {

    }

    @Override
    public void terminate() {

    }

    @Override
    public boolean isInitialized() {
        return false;
    }

    @Override
    Activity getHostActivity() {
        return null;
    }

    public void addListView(ListView listView) {
        mArrivalListView = listView;
        initListView();
    }

    public void addTextView(TextView textView) {
        mResponseTextView = textView;
    }

    private void initListView() {
        StringRequest arrivalRequest = RequestModel.requestArrivalsForStop(mTrainStop, new OnArrivalLoaded() {
            @Override
            public void onArrivalLoaded(String string) {
                populateListFromXmlString(string);
            }

            @Override
            public void onArrivalFailure() {
                mResponseTextView.setText("Responses couldn't load bro idk what happened man");
            }
        });
        TrainWearApplication.getRequestQueue().add(arrivalRequest);
    }

    private void populateListFromXmlString(String string) {
        ArrivalParser mArrivalParser = new ArrivalParser(string);
        try {
            mArrivalArrayList = mArrivalParser.parse();
            mArrivalAdapter = new ArrivalAdapter(mContext, mArrivalArrayList);
            mArrivalListView.setAdapter(mArrivalAdapter);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
