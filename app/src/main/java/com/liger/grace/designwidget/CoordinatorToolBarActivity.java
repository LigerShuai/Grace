package com.liger.grace.designwidget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.liger.grace.R;
import com.liger.grace.main.BaseActivity;

import butterknife.BindView;

/**
 * Created by Liger on 2017/4/28 20:08.
 */

public class CoordinatorToolBarActivity extends BaseActivity {

    @BindView(R.id.activity_coord_rv)
    RecyclerView mRecyclerView;
    @BindView(R.id.activity_coord_toolbar)
    Toolbar mToolbar;

    private Context mContext;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_coordin_toolbar;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        initView();
    }

    private void initView() {
        mContext = getBaseContext();
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("CoordinatorToolBar");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        String[] data = new String[30];
        for (int i = 0; i < data.length; i++) {
            data[i] = "item";
        }
        RvAdapter adapter = new RvAdapter(mContext, data);
        mRecyclerView.setAdapter(adapter);

        /*String[] fromColumns = {ContactsContract.Data.DISPLAY_NAME};
        int[] toViews = {android.R.id.text1}; // The TextView in simple_list_item_1
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1, null,
                fromColumns, toViews, 0);
        setListAdapter(mAdapter);*/
    }
}
