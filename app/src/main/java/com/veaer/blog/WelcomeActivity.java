package com.veaer.blog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.veaer.blog.glass.FirstActivity;
import com.veaer.blog.mvp.activity.LoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.mvp)
    public void toMvp(View v) {
        LoginActivity.onAction(this);
    }

    @OnClick(R.id.glass)
    public void toGlass(View v) {
        FirstActivity.onAction(this);
    }
}

