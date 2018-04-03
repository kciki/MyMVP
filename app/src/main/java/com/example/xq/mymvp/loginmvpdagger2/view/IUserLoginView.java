package com.example.xq.mymvp.loginmvpdagger2.view;


import com.example.xq.mymvp.loginmvpdagger2.moudle.bean.User;

/**
 * Created by xq on 2018/4/3.
 */

public interface IUserLoginView {
    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void loginSuccess(User user);

    void loginError();
}
