package com.example.xq.mymvp.loginmvpdagger2;

import com.example.xq.mymvp.loginmvpdagger2.presenter.LoginPresenterCompl;
import com.example.xq.mymvp.loginmvpdagger2.view.IUserLoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xq on 2018/4/3.
 */

@Module
public class ActivityModule {
    private IUserLoginView iUserLoginView;

    public ActivityModule(IUserLoginView iUserLoginView){
        this.iUserLoginView = iUserLoginView;
    }

    @Provides
    public IUserLoginView provideUserView(){
        return iUserLoginView;
    }

    @Provides
    public LoginPresenterCompl provideLoginPresentCompl(IUserLoginView iUserLoginView){
        return new LoginPresenterCompl(iUserLoginView);
    }
}
