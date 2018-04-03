package com.example.xq.mymvp.loginmvpdagger2.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by xq on 2018/4/2.
 */

public class BasePresenter<V> {
    protected Reference<V> mViewRef;

    public void attachView(V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public V getView() {
        if (mViewRef == null) {
            return null;
        }
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
