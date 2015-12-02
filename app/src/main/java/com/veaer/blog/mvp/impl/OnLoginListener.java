package com.veaer.blog.mvp.impl;

import com.veaer.blog.mvp.model.User;

/**
 * Created by Veaer on 15/12/2.
 */
public interface OnLoginListener {

    void onSuccess(User user);

    void onFailed();
}
