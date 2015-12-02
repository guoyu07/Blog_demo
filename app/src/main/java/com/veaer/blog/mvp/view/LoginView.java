package com.veaer.blog.mvp.view;

/**
 * Created by Veaer on 15/12/2.
 */
public interface LoginView {

    void clearName();

    void clearPassword();

    String getUserName();

    String getPassword();

    void changeLoginState();

    void showToast(String msg);

}
