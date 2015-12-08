package com.veaer.blog.vary;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veaer.blog.R;

/**
 * Created by Veaer on 15/12/7.
 */
public class VaryViewController {

    private VaryView mVaryView;

    public VaryViewController(View view) {
        mVaryView = new VaryView(view);
    }

    public void showLoading(String msg) {
        View layout = mVaryView.inflate(R.layout.vary_loading);
        if (!TextUtils.isEmpty(msg)) {
            TextView textView = (TextView) layout.findViewById(R.id.loading_text);
            textView.setText(msg);
        }
        mVaryView.showLayout(layout);
    }

    public void restore() {
        mVaryView.restoreView();
    }

    private class VaryView {
        private View view;
        private ViewGroup parentView;
        private int viewIndex;
        private ViewGroup.LayoutParams params;
        private View currentView;

        public VaryView(View view) {
            this.view = view;
            params = view.getLayoutParams();
            if (view.getParent() != null) {
                parentView = (ViewGroup) view.getParent();
            } else {
                parentView = (ViewGroup) view.getRootView().findViewById(android.R.id.content);
            }
            int count = parentView.getChildCount();
            for (int index = 0; index < count; index++) {
                if (view == parentView.getChildAt(index)) {
                    viewIndex = index;
                    break;
                }
            }
            currentView = view;
        }

        public void restoreView() {
            showLayout(view);
        }

        public void showLayout(View view) {
            this.currentView = view;
            if (parentView.getChildAt(viewIndex) != view) {
                ViewGroup parent = (ViewGroup) view.getParent();
                if (parent != null) {
                    parent.removeView(view);
                }
                parentView.removeViewAt(viewIndex);
                parentView.addView(view, viewIndex, params);
            }
        }

        public View inflate(int layoutId) {
            return LayoutInflater.from(view.getContext()).inflate(layoutId, null);
        }

        public Context getContext() {
            return view.getContext();
        }


    }
}
