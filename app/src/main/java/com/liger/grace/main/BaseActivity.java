package com.liger.grace.main;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Liger on 2017/4/28 20:08.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    public View mRootView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater inflater = LayoutInflater.from(this);
        mRootView = inflater.inflate(layoutResID, null);
        setContentView(mRootView);
        unbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutResId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
