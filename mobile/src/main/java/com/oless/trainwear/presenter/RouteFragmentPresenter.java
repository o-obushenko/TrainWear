package com.oless.trainwear.presenter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oless.trainwear.R;

/**
 * Created by oless on 10/17/15.
 */
public class RouteFragmentPresenter extends FragmentPresenter {

    ListView mRouteListView;
    ArrayAdapter<String> mRouteAdapter;
    Context mContext;

    public RouteFragmentPresenter(Context context) {
        mContext = context;
    }

    @Override
    public void init() {
         mRouteAdapter = new ArrayAdapter<>(mContext,
                android.R.layout.simple_list_item_1, android.R.id.text1, mContext.getResources().getStringArray(R.array.lines));
    }

    @Override
    public void terminate() {

    }

    @Override
    public boolean isInitialized() {
        return false;
    }

    public void addListView(ListView lv) {
        mRouteListView = lv;
        initListView();
    }

    private void initListView() {
        mRouteListView.setAdapter(mRouteAdapter);
    }
}
