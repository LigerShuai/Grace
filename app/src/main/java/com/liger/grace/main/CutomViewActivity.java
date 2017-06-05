package com.liger.grace.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.liger.grace.R;

/**
 * Created by Liger on 2017/4/29 16:45.
 */

public class CutomViewActivity extends BaseActivity{

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_customview;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
    }
}
