package com.evloution.elinkshopping.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evloution.elinkshopping.R;
import com.evloution.elinkshopping.adapter.HomePagerAdapter;
import com.evloution.elinkshopping.bean.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Evloution_
 * @date 2018/10/24
 * @explain 展示首页的 fragment
 */
public class HomePageFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager mViewPager;
    private HomePagerAdapter homePagerAdapter;

    // tab标题
    private List<String> titles = new ArrayList<>();
    // fragments
    private List<Fragment> fragments = new ArrayList<>();
    public static List<Category> categories = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        initView(view);
        initData();
        initEvents();
        return view;
    }

    private void initView(View view) {
        tabLayout = view.findViewById(R.id.tl);
        mViewPager = view.findViewById(R.id.vp);
    }

    private void initData() {
        titles.clear();
        fragments.clear();

        categories.add(new Category("首页"));
        categories.add(new Category("最新"));
        categories.add(new Category("热门"));
        categories.add(new Category("分类"));
        categories.add(new Category("推荐"));
        categories.add(new Category("推荐2"));
        categories.add(new Category("推荐3"));
        categories.add(new Category("推荐4"));
        categories.add(new Category("推荐5"));
        categories.add(new Category("推荐6"));

        for (int i = 0; i < categories.size(); i++) {
            titles.add(categories.get(i).getTitle());
        }
    }

    private void initEvents() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        homePagerAdapter = new HomePagerAdapter(getChildFragmentManager(), titles);
        mViewPager.setAdapter(homePagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
