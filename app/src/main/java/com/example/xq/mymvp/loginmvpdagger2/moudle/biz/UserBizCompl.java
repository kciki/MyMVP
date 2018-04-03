package com.example.xq.mymvp.loginmvpdagger2.moudle.biz;


import com.example.xq.mymvp.loginmvpdagger2.moudle.bean.User;

/**
 * Created by xq on 2018/4/3.
 */

public class UserBizCompl implements IUserBiz {
    @Override
    public void login(final String name, final String pwd, final OnLoginListener listener) {
        //子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //登录成功
                if ("admin".equals(name) && "admin".equals(pwd)) {
                    User user = new User(name,pwd);
                    listener.loginSuccess(user);
                } else {
                    listener.loginError();
                }
            }
        }.start();
    }
}
