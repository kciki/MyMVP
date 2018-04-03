package com.example.xq.mymvp.loginmvpdagger2.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.xq.mymvp.loginmvpdagger2.moudle.bean.User;
import com.example.xq.mymvp.loginmvpdagger2.moudle.biz.IUserBiz;
import com.example.xq.mymvp.loginmvpdagger2.moudle.biz.OnLoginListener;
import com.example.xq.mymvp.loginmvpdagger2.moudle.biz.UserBizCompl;
import com.example.xq.mymvp.loginmvpdagger2.view.IUserLoginView;

/**
 * Created by xq on 2018/4/3.
 */

public class LoginPresenterCompl extends BasePresenter<IUserLoginView> implements ILoginPresenter {

    private IUserLoginView iuserLoginView;
    private IUserBiz iUserBiz;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public LoginPresenterCompl(IUserLoginView iuserLoginView) {
        this.iuserLoginView = iuserLoginView;
        iUserBiz = new UserBizCompl();
    }

    @Override
    public void login(String name, String pwd) {
        iuserLoginView.showLoading();
        iUserBiz.login(name, pwd, new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iuserLoginView.hideLoading();
                        iuserLoginView.loginSuccess(user);
                    }
                });
            }

            @Override
            public void loginError() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iuserLoginView.hideLoading();
                        iuserLoginView.loginError();
                    }
                });
            }
        });
    }

    @Override
    public void clear() {
        iuserLoginView.clearUserName();
        iuserLoginView.clearPassword();
    }
}
