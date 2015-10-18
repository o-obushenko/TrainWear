package com.oless.trainwear.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oless.trainwear.R;
import com.oless.trainwear.TrainActivity;
import com.oless.trainwear.fragment.RouteListFragment;

/**
 * Created by oless on 10/17/15.
 */
public class RouteFragmentPresenter extends FragmentPresenter {

    ListView mRouteListView;
    ArrayAdapter<String> mRouteAdapter;
    Context mContext;
    boolean mInitialized;
    RouteListFragment mFragment;

    public RouteFragmentPresenter(RouteListFragment fragment, Context context) {
        mContext = context;
        mFragment = fragment;
    }

    @Override
    public void init() {
        mRouteAdapter = new ArrayAdapter<>(mContext,
                android.R.layout.simple_list_item_1, android.R.id.text1, mContext.getResources().getStringArray(R.array.lines));
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

    public void addListView(ListView lv) {
        mRouteListView = lv;
        initListView();
    }

    private void initListView() {
        mRouteListView.setAdapter(mRouteAdapter);
        mRouteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getHostActivity() == null) {
                    return;
                }
                ((TrainActivity) getHostActivity()).switchToStopList(mRouteAdapter.getItem(position));
            }
        });
    }

    @Override
    Activity getHostActivity() {
        if (mFragment == null) {
            return null;
        }
        return mFragment.getActivity();
    }
}
