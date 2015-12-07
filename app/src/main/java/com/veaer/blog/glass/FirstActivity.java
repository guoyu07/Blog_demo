package com.veaer.blog.glass;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.veaer.blog.Blog;
import com.veaer.blog.R;
import com.veaer.glass.Glass;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FirstActivity extends AppCompatActivity {

    @Bind(R.id.text_view)
    TextView textView;
    @Bind(R.id.color_view)
    TextView colorView;
    @Bind(R.id.second_view)
    TextView secondView;
    @Bind(R.id.third_view)
    TextView thirdView;
    @Bind(R.id.fab_btn)
    FloatingActionButton fab;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    int color = Color.BLACK;
    Glass mGlass;


    public static void onAction(Context context) {
        Intent intent = new Intent(context, FirstActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glass_first_activity);
        ButterKnife.bind(this);
        secondView.setOnClickListener((v) -> {
            Intent intent = new Intent(Blog.mContext, SecondActivity.class);
            startActivity(intent);
        });
        thirdView.setOnClickListener((v) -> {
            Intent intent = new Intent(Blog.mContext, ThirdActivity.class);
            startActivity(intent);
        });
        fab.setOnClickListener((v) -> {
            switch (color) {
                case Color.BLACK:
                    color = Color.BLUE;
                    break;
                case Color.BLUE:
                    color = Color.RED;
                    break;
                case Color.RED:
                    color = Color.BLACK;
                    break;
            }
            mGlass.setColor(color);
        });
        mGlass = Glass.Builder.newInstance()
                .statusBarWithLower(getWindow(), Blog.mContext)
                .text(textView)
                .defaultColor(Color.RED)
                .background(appBar)
                .background(fab)
                .background(colorView)
                .build();

    }

}
