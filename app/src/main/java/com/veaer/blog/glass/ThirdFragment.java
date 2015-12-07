package com.veaer.blog.glass;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.veaer.blog.R;

/**
 * Created by Veaer on 15/11/18.
 */
public class ThirdFragment extends Fragment {

    private static final String KEY_COLOUR = "KEY_COLOUR";
    private static final String KEY_TEXT = "KEY_TEXT";

    public static Fragment newInstance(Context context, CharSequence name, int colour) {
        Bundle args = new Bundle();
        args.putCharSequence(KEY_TEXT, name);
        args.putInt(KEY_COLOUR, colour);
        return Fragment.instantiate(context, ThirdFragment.class.getName(), args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        CharSequence name = getArguments().getCharSequence(KEY_TEXT);
        int colour = getArguments().getInt(KEY_COLOUR);
        TextView view = (TextView) inflater.inflate(R.layout.glass_third_fragment, container, false);
        view.setTextColor(colour);
        view.setText(name);
        return view;
    }
}
