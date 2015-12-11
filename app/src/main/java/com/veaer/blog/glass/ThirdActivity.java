package com.veaer.blog.glass;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.veaer.blog.Blog;
import com.veaer.blog.R;
import com.veaer.glass.Glass;
import com.veaer.glass.viewpager.PagerTrigger;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Veaer on 15/11/18.
 */
public class ThirdActivity extends AppCompatActivity {
    Glass mGlass;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glass_third_activity);
        ButterKnife.bind(this);
        ThirdAdapter adapter = new ThirdAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        mGlass = Glass.Builder.newInstance()
                .statusBar(getWindow())
                .background(tabLayout)
                .addTrigger(PagerTrigger.addTrigger(viewPager, adapter))
                .build();
        mGlass.setColor(Color.RED);
        Blog.refWatcher.watch(mGlass);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGlass.onDestroy();
    }
}
