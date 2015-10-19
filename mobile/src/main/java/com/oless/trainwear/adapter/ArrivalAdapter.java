package com.oless.trainwear.adapter;

import com.oless.trainwear.R;
import com.oless.trainwear.model.Arrival;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 * Created by oless on 10/18/15.
 */
public class ArrivalAdapter extends BaseAdapter {

    ArrayList<Arrival> mArrivalArrayList;
    Context mContext;

    public ArrivalAdapter(Context context, ArrayList<Arrival> list) {
        mContext = context;
        mArrivalArrayList = list;
    }

    @Override
    public int getCount() {
        return mArrivalArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrivalArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mArrView = mInflater.inflate(R.layout.arrival_list_item, parent, false);
        TextView mDestTextView = (TextView) mArrView.findViewById(R.id.dest_text_view);
        mDestTextView.setText(mArrivalArrayList.get(position).getDestStationName());
        TextView mTimeTextView = (TextView) mArrView.findViewById(R.id.dest_arrival_time);
        mTimeTextView.setText(mArrivalArrayList.get(position).getArrivalMinutes() + " Minutes");
        return mArrView;
    }
}