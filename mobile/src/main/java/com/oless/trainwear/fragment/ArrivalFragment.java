package com.oless.trainwear.fragment;

import com.oless.trainwear.R;
import com.oless.trainwear.model.TrainStop;
import com.oless.trainwear.presenter.ArrivalFragmentPresenter;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by oless on 10/18/15.
 */
public class ArrivalFragment extends Fragment {

    View mView;
    ArrivalFragmentPresenter mPresenter = null;
    TrainStop mTrainStop;

    public static ArrivalFragment newInstance() {
        return new ArrivalFragment();
    }

    public void addArguments(TrainStop stop) {
        mTrainStop = stop;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        WeakReference<Activity> mActivityWeakReference = new WeakReference<>(getActivity());
        setPresenter(new ArrivalFragmentPresenter(this, mActivityWeakReference.get()));
        mPresenter.addTrainStop(mTrainStop);
        mPresenter.init();
        mView = inflater.inflate(R.layout.list_fragment, null);
        mPresenter.addListView((ListView) mView.findViewById(R.id.item_list));
        return mView;
    }

    void setPresenter(ArrivalFragmentPresenter presenter) {
        mPresenter = presenter;
    }
}
