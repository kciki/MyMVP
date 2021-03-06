package com.example.xq.mymvp.loginoptimizeddemo2.view;


import com.example.xq.mymvp.loginoptimizeddemo2.model.bean.User;

/**
 * Created by xq on 2018/1/17.
 */

public interface IUserLoginView {

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void loginSuccess(User user);

    void loginError();
}
