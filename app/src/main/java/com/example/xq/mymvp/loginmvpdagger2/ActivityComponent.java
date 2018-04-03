package com.example.xq.mymvp.loginmvpdagger2;



import dagger.Component;

/**
 * Created by xq on 2018/4/3.
 */

@Component(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(LoginMVPDagger2Activity activity);
}
