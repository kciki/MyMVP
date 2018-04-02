package com.example.xq.mymvp.loginoptimizeddemo1.model.biz;

/**
 * Created by xq on 2018/4/2.
 */

public interface IUserBiz {
    void login(String name,String pwd,OnLoginListener onLoginListener);
}
