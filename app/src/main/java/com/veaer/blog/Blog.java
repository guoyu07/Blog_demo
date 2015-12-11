package com.veaer.blog;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Veaer on 15/12/2.
 */
public class Blog extends Application {
    public static Context mContext;
    public static RefWatcher refWatcher;

    @Override public void onCreate() {
        super.onCreate();
        mContext = this;
        refWatcher = LeakCanary.install(this);
    }
}
