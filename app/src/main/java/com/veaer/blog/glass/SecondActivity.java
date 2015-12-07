package com.veaer.blog.glass;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.veaer.blog.Blog;
import com.veaer.blog.R;
import com.veaer.glass.Glass;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Veaer on 15/11/5.
 */
public class SecondActivity extends AppCompatActivity {

    @Bind(R.id.image)
    ImageView imageView;
    @Bind(R.id.fab_btn)
    FloatingActionButton fab;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    Glass mGlass;
    int label = R.mipmap.a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glass_second_activity);
        ButterKnife.bind(this);
        fab.setOnClickListener((v) -> {
                switch (label) {
                    case R.mipmap.a:
                        label = R.mipmap.b;
                        break;
                    case R.mipmap.b:
                        label = R.mipmap.c;
                        break;
                    case R.mipmap.c:
                        label = R.mipmap.a;
                        break;
                }
                changeImage();
            });
        mGlass = Glass.Builder.newInstance()
                .statusBarWithLower(getWindow(), Blog.mContext)
                .background(appBar)
                .build();
        changeImage();
    }

    public void changeImage() {
        imageView.setImageResource(label);
        mGlass.setPaletteBmp(BitmapFactory.decodeResource(getResources(), label), Glass.paletteType.MUTED);
    }

}
