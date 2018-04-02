package com.example.xq.mymvp.logindemo.view;

import com.example.xq.mymvp.logindemo.model.User;

/**
 * Created by xq on 2018/4/2.
 */

public interface ILoginView {
    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void onLoginResult(User user);
}
