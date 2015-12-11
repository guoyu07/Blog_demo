package com.veaer.blog;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veaer.blog.base.BaseActivity;
import com.veaer.blog.glass.FirstActivity;
import com.veaer.blog.mvp.activity.LoginActivity;
import com.veaer.blog.netstatus.NetStatusActivity;
import com.veaer.blog.vary.ViewActivity;

import butterknife.Bind;
import butterknife.ButterKnife;


public class WelcomeActivity extends BaseActivity {

    @Bind(R.id.wel_rv)
    RecyclerView welRv;

    @Override
    protected int getLayoutID() {
        return R.layout.welcome_activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        welRv.setAdapter(new WelAdapter());
        welRv.setLayoutManager(new LinearLayoutManager(mContext));
    }

    public class WelAdapter extends RecyclerView.Adapter<WelHolder> {
        private LayoutInflater mLayoutInflater;

        public WelAdapter() {
            super();
            mLayoutInflater = LayoutInflater.from(Blog.mContext.getApplicationContext());
        }

        @Override
        public int getItemCount() {
            return 4;
        }

        @Override
        public WelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WelHolder(mLayoutInflater.inflate(R.layout.welcome_holder, parent, false));
        }

        @Override
        public void onBindViewHolder(WelHolder holder, int position) {
            holder.bindData(position);
        }
    }

    public class WelHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.wel_holder_text)
        TextView holderText;
        private View view;

        public WelHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }

        public void bindData(int pos) {
            Class<?> toClass;
            String btnText;
            switch (pos) {
                case 0:
                    toClass = LoginActivity.class;
                    btnText = "mvp";
                    break;
                case 1:
                    toClass = FirstActivity.class;
                    btnText = "glass";
                    break;
                case 2:
                    toClass = ViewActivity.class;
                    btnText = "vary";
                    break;
                case 3:
                    toClass = NetStatusActivity.class;
                    btnText = "netStatus";
                    break;
                default:
                    toClass = LoginActivity.class;
                    btnText = "mvp";
            }
            view.setOnClickListener(v -> readyGo(toClass));
            holderText.setText(btnText);
        }
    }
}

