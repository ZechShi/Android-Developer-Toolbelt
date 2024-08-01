package com.tspoon.androidtoolbelt.component.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.tspoon.androidtoolbelt.R;
import com.tspoon.androidtoolbelt.component.fragment.MemoryFragment;
import com.tspoon.androidtoolbelt.view.SlidingTabLayout;


public class MainActivity extends BaseAbstractToolbarActivity {

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private SlidingTabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewPager.setAdapter(new PagerAdapter(this, getSupportFragmentManager()));

        //mTabLayout.setDistributeEvenly(true);
        //mTabLayout.setCustomTabView(R.layout.layout_tab, 0);
        //mTabLayout.setSelectedIndicatorColors(Color.WHITE);
        //mTabLayout.setViewPager(mViewPager);

        mActionBar.setDisplayHomeAsUpEnabled(false);

        setTitle(R.string.app_name_short);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_github) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_github))));
            return true;
        } else if (itemId == R.id.action_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TITLE, "The Android Developer's Toolbelt - " + getString(R.string.url_share));
            startActivity(Intent.createChooser(intent, "Share with..."));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void findViews() {
        super.findViews();
        mToolbar = findViewById(R.id.toolbar);
        mViewPager = findViewById(R.id.viewpager);
        mTabLayout = findViewById(R.id.sliding_tabs);

    }

    private void openLink(String string) {

    }

    public static enum NavItem {
        MEMORY(R.string.nav_memory);

        public int titleRes;

        NavItem(int resId) {
            titleRes = resId;
        }
    }

    private static class PagerAdapter extends FragmentPagerAdapter {

        private static final NavItem[] ITEMS = NavItem.values();

        private Context mContext;

        public PagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (ITEMS[position]) {
                case MEMORY:
                    return MemoryFragment.newInstance();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return ITEMS.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mContext.getString(ITEMS[position].titleRes).toUpperCase();
        }
    }
}
