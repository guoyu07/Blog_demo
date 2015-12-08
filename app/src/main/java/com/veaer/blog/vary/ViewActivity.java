package com.veaer.blog.vary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.veaer.blog.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Veaer on 15/12/7.
 */
public class ViewActivity extends AppCompatActivity {
    @Bind(R.id.show_area)
    TextView area;
    VaryViewController mVaryViewController;
    boolean isShow = false;

    public static void onAction(Context context) {
        Intent intent = new Intent(context, ViewActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vary_view_activity);
        ButterKnife.bind(this);
        mVaryViewController = new VaryViewController(area);
    }

    @OnClick(R.id.toggle)
    public void toggle(View v) {
        if(isShow) {
            mVaryViewController.restore();
        } else {
            mVaryViewController.showLoading("正在努力刷新");
        }
        isShow = !isShow;
    }

}
