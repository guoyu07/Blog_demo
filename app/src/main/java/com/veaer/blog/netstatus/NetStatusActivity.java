package com.veaer.blog.netstatus;

import android.os.Bundle;

import com.veaer.blog.R;
import com.veaer.blog.base.BaseActivity;

/**
 * Created by Veaer on 15/12/11.
 */
public class NetStatusActivity extends BaseActivity {
    protected NetChangeObserver mNetChangeObserver = null;


    @Override
    protected int getLayoutID() {
        return R.layout.net_status_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNetChangeObserver = new NetChangeObserver() {
            @Override
            public void onNetConnected(NetUtils.NetType type) {
                showToast("网络已连接");
            }

            @Override
            public void onNetDisConnect() {
                showToast("网络已断开");
            }

        };
        NetStateReceiver.register(mContext, mNetChangeObserver);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetStateReceiver.unRegister(mContext, mNetChangeObserver);
    }
}
