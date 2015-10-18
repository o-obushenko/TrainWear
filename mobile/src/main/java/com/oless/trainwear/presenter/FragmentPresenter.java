package com.oless.trainwear.presenter;

import android.app.Activity;

/**
 * Created by oless on 10/17/15.
 */
public abstract class FragmentPresenter {

    public abstract void init();
    public abstract void terminate();
    public abstract boolean isInitialized();
    abstract Activity getHostActivity();

}
