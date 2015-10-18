package com.oless.trainwear.fragment;

import com.oless.trainwear.R;
import com.oless.trainwear.presenter.RouteFragmentPresenter;
import com.oless.trainwear.presenter.StopListPresenter;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.lang.ref.WeakReference;

/**
 * Created by oless on 10/17/15.
 */
public class StopListFragment extends Fragment {

    String lineColor;
    StopListPresenter mPresenter = null;
    View mView = null;

    public static StopListFragment newInstance() {
        return new StopListFragment();
    }

    public void addArguments(String color) {
        lineColor = color;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        WeakReference<Activity> mActivityWeakReference = new WeakReference<>(getActivity());
        setPresenter(new StopListPresenter(this, mActivityWeakReference.get()));
        mPresenter.addLineColor(lineColor);
        mPresenter.init();
        mView = inflater.inflate(R.layout.list_fragment, null);
        mPresenter.addListView((ListView) mView.findViewById(R.id.item_list));
        return mView;
    }

    void setPresenter(StopListPresenter presenter) {
        mPresenter = presenter;
    }

}
