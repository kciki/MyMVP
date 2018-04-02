package com.example.xq.mymvp.loginoptimizeddemo2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xq.mymvp.R;
import com.example.xq.mymvp.loginoptimizeddemo2.model.bean.User;
import com.example.xq.mymvp.loginoptimizeddemo2.presenter.LoginPresentCompl;
import com.example.xq.mymvp.loginoptimizeddemo2.view.IUserLoginView;


public class LoginOptimized2Activity extends MVPBaseActivity<IUserLoginView, LoginPresentCompl> implements IUserLoginView, View.OnClickListener {


    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button btnClear;
    private ProgressBar progressBar;


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
                mPresenter.clear();
                break;
            case R.id.btn_login_login:
                mPresenter.login(editUser.getText().toString(), editPass.getText().toString());
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
    protected LoginPresentCompl createPresenter() {
        return new LoginPresentCompl(this);
    }
}
