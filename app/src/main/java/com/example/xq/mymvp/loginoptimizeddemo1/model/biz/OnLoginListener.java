package com.example.xq.mymvp.loginoptimizeddemo1.model.biz;


import com.example.xq.mymvp.loginoptimizeddemo1.model.bean.User;

/**
 * Created by xq on 2018/1/17.
 */

public interface OnLoginListener
{
    void loginSuccess(User user);

    void loginFailed();
}
