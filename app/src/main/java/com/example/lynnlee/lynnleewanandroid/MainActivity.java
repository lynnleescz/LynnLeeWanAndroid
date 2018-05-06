package com.example.lynnlee.lynnleewanandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lynnlee.lynnleewanandroid.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.common_toolbar)
    Toolbar mToolBar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mToolbarTitle;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.fragment_content)
    FrameLayout mFragmentContent;
    @BindView(R.id.coordinator_layout)
    CoordinatorLayout mCoordinatorLayout;

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

        initNavigationView();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //获得侧滑菜单的宽度
                int drawerViewWidth = drawerView.getMeasuredWidth();
                // 根据滑动百分比计算内容部分应该向右边移动的距离
                int marginLeft = (int)(drawerViewWidth * slideOffset) ;
                mCoordinatorLayout.setLeft(marginLeft);
            }
        };
        toggle.syncState();
        mDrawerLayout.addDrawerListener(toggle);
    }

    private void initNavigationView() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item_wan_android:
                        Log.i(Constants.TAG, "goto-->wan android UI");
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.nav_item_my_collect:
                        Log.i(Constants.TAG, "goto-->Collect UI");
                        break;
                    case R.id.nav_item_setting:
                        Log.i(Constants.TAG, "goto-->Setting UI");
                        break;
                    case R.id.nav_item_about_us:
                        Log.i(Constants.TAG, "goto-->About us UI");
                        break;
                    case R.id.nav_item_logout:
                        Log.i(Constants.TAG, "goto-->logout UI");
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //重写onCreateOptionsMenu，并且toolbar.setOnMenuItemListener实现点击事件
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
