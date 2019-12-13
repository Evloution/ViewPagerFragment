package com.evloution.elinkshopping.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.evloution.elinkshopping.R;
import com.evloution.elinkshopping.fragment.ContentFragment;

import java.util.List;

/**
 * @Description：
 * @Author： Evloution_
 * @Date： 2019-12-12
 * @Email： 15227318030@163.com
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private List<String> titles;

    public HomePagerAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Fragment getItem(int i) {
        return new ContentFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
