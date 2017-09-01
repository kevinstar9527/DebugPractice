package com.superplus.kevinstar.stetho;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * Created by admin on 2017/9/1.
 */

public class TestLeakActivity extends FragmentActivity {

    private TextView textView;
    private static Hello hello;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        hello = new Hello(this);
    }
    public class Hello{
        Hello(Context context){
            textView.setText(context.getString(R.string.app_name));
        }
    }
}
