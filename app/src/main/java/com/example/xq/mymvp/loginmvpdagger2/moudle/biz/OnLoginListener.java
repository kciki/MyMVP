package com.example.xq.mymvp.loginmvpdagger2.moudle.biz;

import com.example.xq.mymvp.loginmvpdagger2.moudle.bean.User;

/**
 * Created by xq on 2018/4/3.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void  loginError();
}
