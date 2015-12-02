package com.veaer.blog.mvp.util;

import com.veaer.blog.mvp.impl.OnLoginListener;
import com.veaer.blog.mvp.model.User;

/**
 * Created by Veaer on 15/12/2.
 */
public class LoginUtil {

    public static void login(String name, String password, OnLoginListener loginListener) {
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if ("veaer".equals(name) && "123".equals(password))
                {
                    User user = new User();
                    user.name = name;
                    user.password = password;
                    loginListener.onSuccess(user);
                } else
                {
                    loginListener.onFailed();
                }
            }
        }.start();
    }
}
