package com.example.xq.mymvp.logindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.xq.mymvp.R;
import com.example.xq.mymvp.logindemo.model.User;
import com.example.xq.mymvp.logindemo.presenter.ILoginPresenter;
import com.example.xq.mymvp.logindemo.presenter.LoginPresenterCompl;
import com.example.xq.mymvp.logindemo.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView,View.OnClickListener{

    private EditText editUser;
    private EditText editPass;
    private Button btnLogin;
    private Button   btnClear;
    private ProgressBar progressBar;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        loginPresenter = new LoginPresenterCompl(this);
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
        switch (v.getId()){
            case R.id.btn_login_clear:
                loginPresenter.clear();
                break;
            case R.id.btn_login_login:
                btnLogin.setEnabled(false);
                btnClear.setEnabled(false);
                loginPresenter.login(editUser.getText().toString(), editPass.getText().toString());
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
    public void onLoginResult(User user) {
        btnLogin.setEnabled(true);
        btnClear.setEnabled(true);
        hideLoading();
        if(!"admin".equals(editUser.getText().toString()) ||
                !"admin".equals(editPass.getText().toString())){
            Toast.makeText(this,"Login Error",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }
    }

}
