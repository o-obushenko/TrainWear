package com.oless.trainwear.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.oless.trainwear.R;
import com.oless.trainwear.presenter.RouteFragmentPresenter;

import java.lang.ref.WeakReference;

/**
 * Created by oless on 10/17/15.
 */
public class RouteListFragment extends Fragment {

    View mView;
    RouteFragmentPresenter mPresenter = null;

    public static RouteListFragment newInstance() {
        return new RouteListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        WeakReference<Activity> mActivityWeakReference = new WeakReference<>(getActivity());
        setPresenter(new RouteFragmentPresenter(mActivityWeakReference.get()));
        mPresenter.init();
        mView = inflater.inflate(R.layout.list_fragment, null);
        mPresenter.addListView((ListView) mView.findViewById(R.id.item_list));
        return mView;
    }

    void setPresenter(RouteFragmentPresenter presenter) {
        mPresenter = presenter;
    }
}
