package com.evloution.elinkshopping.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.evloution.elinkshopping.R;

/**
 * @Description：
 * @Author： Evloution_
 * @Date： 2019-12-12
 * @Email： 15227318030@163.com
 */
public class ShoppingCartFragment extends Fragment {

    
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        return view;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
