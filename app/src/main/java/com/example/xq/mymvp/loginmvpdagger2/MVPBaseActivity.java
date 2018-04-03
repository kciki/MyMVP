package com.example.xq.mymvp.loginmvpdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xq.mymvp.loginmvpdagger2.presenter.BasePresenter;


/**
 * Created by xq on 2018/4/2.
 */

public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle arg) {
        super.onCreate(arg);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
