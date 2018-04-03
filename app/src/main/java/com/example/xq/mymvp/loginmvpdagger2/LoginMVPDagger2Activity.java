package com.example.xq.mymvp.loginmvpdagger2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xq.mymvp.R;
import com.example.xq.mymvp.loginmvpdagger2.moudle.bean.User;
import com.example.xq.mymvp.loginmvpdagger2.presenter.LoginPresenterCompl;
import com.example.xq.mymvp.loginmvpdagger2.view.IUserLoginView;

import javax.inject.Inject;

/**
 * Created by xq on 2018/4/3.
 */

public class LoginMVPDagger2Activity extends MVPBaseActivity<IUserLoginView, LoginPresenterCompl>
        implements IUserLoginView, View.OnClickListener {

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressBar;

    @Inject
    LoginPresenterCompl presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        editUser = (EditText) this.findViewById(R.id.et_login_username);
        editPass = (EditText) this.findViewById(R.id.et_login_password);
        btnLogin = (Button) this.findViewById(R.id.btn_login_login);
        btnClear = (Button) this.findViewById(R.id.btn_login_clear);
        progressBar = (ProgressBar) this.findViewById(R.id.progress_login);

        btnLogin.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_login_clear:
                if (mPresenter != null) {
                    mPresenter.clear();
                }
                break;
            case R.id.btn_login_login:
                if (mPresenter != null) {
                    mPresenter.login(editUser.getText().toString(), editPass.getText().toString());
                }
                break;
        }
    }


    @Override
    public void clearUserName() {
        editUser.setText("");
    }

    @Override
    public void clearPassword() {
        editPass.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected LoginPresenterCompl createPresenter() {
        inject();
        return presenter;
    }

    private void inject() {
        DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }


}
