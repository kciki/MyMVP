package com.example.xq.mymvp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.xq.mymvp.logindemo.LoginActivity;
import com.example.xq.mymvp.loginmvpdagger2.LoginMVPDagger2Activity;
import com.example.xq.mymvp.loginoptimizeddemo1.LoginOptimized1Activity;
import com.example.xq.mymvp.loginoptimizeddemo2.LoginOptimized2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }


    public void loginOptimized1(View view) {
        startActivity(new Intent(MainActivity.this, LoginOptimized1Activity.class));
    }

    public void loginOptimized2(View view) {
        startActivity(new Intent(MainActivity.this, LoginOptimized2Activity.class));
    }

    public void loginMvpDagger2(View view) {
        startActivity(new Intent(MainActivity.this, LoginMVPDagger2Activity.class));
    }
}
