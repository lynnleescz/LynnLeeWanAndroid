package com.example.lynnlee.lynnleewanandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;

import com.example.lynnlee.lynnleewanandroid.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.common_toolbar)
    Toolbar mToolBar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mToolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolBar);
        //不现实title，使用自己的textView
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mToolbarTitle.setText("首页");
        //防止状态栏压着toolbar
        StatusBarUtil.setPaddingSmart(this, mToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //重写onCreateOptionsMenu，并且toolbar.setOnMenuItemListener实现点击事件
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
