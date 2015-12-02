package com.veaer.blog.mvp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.veaer.blog.R;
import com.veaer.blog.mvp.presenter.LoginPresenter;
import com.veaer.blog.mvp.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Veaer on 15/12/2.
 */
public class LoginActivity extends AppCompatActivity implements LoginView {

    @Bind(R.id.name) EditText nameEt;
    @Bind(R.id.password) EditText passwordEt;
    @Bind(R.id.login_progress) ProgressBar progressBar;
    @Bind(R.id.login_form) LinearLayout loginForm;

    private LoginPresenter mLoginPresenter;

    public static void onAction(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_login_activity);
        ButterKnife.bind(this);
        mLoginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.login)
    public void login(View v) {
        mLoginPresenter.login();
    }

    @OnClick(R.id.clear)
    public void clear(View v) {
        mLoginPresenter.clear();
    }

    @Override
    public void clearName() {
        nameEt.setText("");
    }

    @Override
    public void clearPassword() {
        passwordEt.setText("");
    }

    @Override
    public String getPassword() {
        return passwordEt.getText().toString().trim();
    }

    @Override
    public String getUserName() {
        return nameEt.getText().toString().trim();
    }

    @Override
    public void changeLoginState() {
        if(View.VISIBLE == progressBar.getVisibility()) {
            progressBar.setVisibility(View.GONE);
            loginForm.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
            loginForm.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
