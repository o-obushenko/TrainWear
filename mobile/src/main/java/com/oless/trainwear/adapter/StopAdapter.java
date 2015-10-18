package com.oless.trainwear.adapter;

import com.oless.trainwear.R;
import com.oless.trainwear.model.TrainStop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oless on 10/17/15.
 */
public class StopAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<TrainStop> mLineStopsList;

    public StopAdapter(Context context, ArrayList<TrainStop> stopList) {
        mContext = context;
        mLineStopsList = stopList;
    }

    @Override
    public int getCount() {
        return mLineStopsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mLineStopsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mStopView = mInflater.inflate(R.layout.stop_list_item, parent, false);
        TextView mNameView = (TextView) mStopView.findViewById(R.id.stop_name_text_view);
        mNameView.setText(mLineStopsList.get(position).getStationName());
        return mStopView;
    }
}
