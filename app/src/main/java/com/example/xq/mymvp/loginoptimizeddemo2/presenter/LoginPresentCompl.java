package com.example.xq.mymvp.loginoptimizeddemo2.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.xq.mymvp.loginoptimizeddemo2.model.bean.User;
import com.example.xq.mymvp.loginoptimizeddemo2.model.biz.IUserBiz;
import com.example.xq.mymvp.loginoptimizeddemo2.model.biz.OnLoginListener;
import com.example.xq.mymvp.loginoptimizeddemo2.model.biz.UserBiz;
import com.example.xq.mymvp.loginoptimizeddemo2.view.IUserLoginView;

/**
 * Created by xq on 2018/4/2.
 */

public class LoginPresentCompl extends BasePresenter<IUserLoginView> implements ILoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public LoginPresentCompl(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    @Override
    public void login(String name, String pwd) {
        userLoginView.showLoading();
        userBiz.login(name, pwd, new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.loginSuccess(user);
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.loginError();
                    }
                });
            }
        });
    }

    @Override
    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }

}
