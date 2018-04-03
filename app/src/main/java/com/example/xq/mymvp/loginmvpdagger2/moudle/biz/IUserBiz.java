package com.example.xq.mymvp.loginmvpdagger2.moudle.biz;

/**
 * Created by xq on 2018/4/3.
 */

public interface IUserBiz {
    void login(String name,String pwd,OnLoginListener listener);
}
