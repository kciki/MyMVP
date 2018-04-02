package com.example.xq.mymvp.loginoptimizeddemo2.model.biz;

import com.example.xq.mymvp.loginoptimizeddemo2.model.bean.User;

/**
 * Created by xq on 2018/4/2.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String name, final String pwd, final OnLoginListener onLoginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("admin".equals(name) && "admin".equals(pwd)) {
                    User user = new User(name,pwd);
                    onLoginListener.loginSuccess(user);
                } else {
                    onLoginListener.loginFailed();
                }
            }
        }.start();
    }
}
