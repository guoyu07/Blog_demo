package com.veaer.blog;

import android.app.Application;
import android.content.Context;

/**
 * Created by Veaer on 15/12/2.
 */
public class Blog extends Application {
    public static Context mContext;

    @Override public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
