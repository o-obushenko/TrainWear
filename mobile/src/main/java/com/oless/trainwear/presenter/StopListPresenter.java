package com.oless.trainwear.presenter;

import com.oless.trainwear.TrainActivity;
import com.oless.trainwear.adapter.StopAdapter;
import com.oless.trainwear.fragment.StopListFragment;
import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.stop.StopUtils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
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
        if (mColor.isEmpty()) {
            return;
        }
        mLineStops = StopUtils.getStopsByColor(mColor);
        mStopAdapter = new StopAdapter(mContext, mLineStops);
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

    @Override
    Activity getHostActivity() {
        if (mFragment == null) {
            return null;
        }
        return mFragment.getActivity();
    }

    public void addListView(ListView listView) {
        mStopListView = listView;
        initListView();
    }

    private void initListView() {
        mStopListView.setAdapter(mStopAdapter);

        mStopListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((TrainActivity) getHostActivity()).switchToArrivals(mLineStops.get(position));
            }
        });
    }



    private String trimLineFromText(String string) {
        return string.split(" ")[0];
    }


}
