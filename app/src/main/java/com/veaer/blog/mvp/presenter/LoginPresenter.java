package com.veaer.blog.mvp.presenter;

import android.os.Handler;

import com.veaer.blog.mvp.impl.OnLoginListener;
import com.veaer.blog.mvp.model.User;
import com.veaer.blog.mvp.util.LoginUtil;
import com.veaer.blog.mvp.view.LoginView;


/**
 * Created by Veaer on 15/12/2.
 */
public class LoginPresenter {
    private LoginView mLoginView;
    private Handler mHandler;

    public LoginPresenter(LoginView loginView) {
        mLoginView = loginView;
        mHandler = new Handler();
    }


    public void login() {
        mLoginView.changeLoginState();
        LoginUtil.login(mLoginView.getUserName(), mLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccess(User user) {
                mHandler.post(() -> mLoginView.showToast("登录成功"));
            }

            @Override
            public void onFailed() {
                mHandler.post(() -> {
                    mLoginView.changeLoginState();
                    mLoginView.showToast("帐号/密码不正确");
                });
            }
        });
    }

    public void clear() {
        mLoginView.clearPassword();
        mLoginView.clearName();
    }
}
