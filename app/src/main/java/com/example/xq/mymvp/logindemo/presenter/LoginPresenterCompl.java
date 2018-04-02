package com.example.xq.mymvp.logindemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.xq.mymvp.logindemo.model.User;
import com.example.xq.mymvp.logindemo.view.ILoginView;


/**
 * Created by xq on 2018/4/2.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    ILoginView iLoginView;
    User user;
    private Handler handler =new Handler(Looper.getMainLooper());

    public LoginPresenterCompl(ILoginView iLoginView) {
        this.iLoginView = iLoginView;

        user = new User("admin","admin");
    }

    @Override
    public void login(String name, String pwd) {
        iLoginView.showLoading();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                iLoginView.onLoginResult(user);
            }
        },2000);
    }


    @Override
    public void clear() {
        iLoginView.clearUserName();
        iLoginView.clearPassword();
    }
}
