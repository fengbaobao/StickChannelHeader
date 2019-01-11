package com.moonrock.stickchannelheader;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moonrock.stickchannelheader.view.adapter.ContentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linkang on 2019/1/11.
 */

public class MainActivity extends Activity {

    private ViewPager vpChannelContainer;
    private List<String> mChannels;
    private TabLayout tlTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coordinator);
        initView();
    }

    private void initView() {

        vpChannelContainer = (ViewPager) findViewById(R.id.vp_channelContainer);
        tlTabs = (TabLayout) findViewById(R.id.tl_tabs);

        mChannels = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mChannels.add("Channel[" + i + "]");
            tlTabs.addTab(tlTabs.newTab());
            tlTabs.getTabAt(i).setText(mChannels.get(i));
        }

        vpChannelContainer.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mChannels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mChannels.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.viewpager_content, container, false);

                RecyclerView rvContent = (RecyclerView) view.findViewById(R.id.rv_content);

                final LinearLayoutManager contentLinearLayoutManager = new LinearLayoutManager(MainActivity.this);
                contentLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rvContent.setLayoutManager(contentLinearLayoutManager);

                RecyclerView.Adapter adapter = new ContentAdapter(MainActivity.this, getPageTitle(position).toString());
                rvContent.setAdapter(adapter);
                rvContent.setNestedScrollingEnabled(true);

                rvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {

                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                    }
                });

                container.addView(view);

                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

        });

        tlTabs.setupWithViewPager(vpChannelContainer);
    }


}
