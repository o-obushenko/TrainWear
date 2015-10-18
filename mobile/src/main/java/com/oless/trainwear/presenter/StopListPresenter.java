package com.oless.trainwear.presenter;

import com.oless.trainwear.adapter.StopAdapter;
import com.oless.trainwear.fragment.StopListFragment;
import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.stop.StopUtils;

import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by oless on 10/17/15.
 */
public class StopListPresenter extends FragmentPresenter {

    boolean mInitialized;
    StopAdapter mStopAdapter = null;
    StopListFragment mFragment;
    Context mContext;
    ListView mStopListView;
    String mColor;
    ArrayList<TrainStop> mLineStops;

    public StopListPresenter(StopListFragment fragment, Context context) {
        mFragment = fragment;
        mContext = context;
    }

    public void addLineColor(String color) {
        mColor = trimLineFromText(color);
    }

    @Override
    public void init() {
        mStopAdapter = new StopAdapter();
        if (mColor.isEmpty()) {
            return;
        }
        mLineStops = StopUtils.getStopsByColor(mColor);
        mInitialized = true;
    }

    @Override
    public void terminate() {
        mInitialized = false;
    }

    @Override
    public boolean isInitialized() {
        return mInitialized;
    }

    public void addListView(ListView listView) {
        mStopListView = listView;
        initListView();
    }

    private void initListView() {
        mStopListView.setAdapter(mStopAdapter);
    }

    private String trimLineFromText(String string) {
        return string.split(" ")[0];
    }


}
