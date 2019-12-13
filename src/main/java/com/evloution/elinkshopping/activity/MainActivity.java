package com.evloution.elinkshopping.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.evloution.elinkshopping.R;
import com.evloution.elinkshopping.fragment.NearbyFragment;
import com.evloution.elinkshopping.fragment.HomePageFragment;
import com.evloution.elinkshopping.fragment.MyPageFragment;
import com.evloution.elinkshopping.fragment.ShoppingCartFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment = new Fragment();
    private HomePageFragment homePageFragment;
    private NearbyFragment nearbyFragment;
    private MyPageFragment myPageFragment;
    private ShoppingCartFragment shoppingCartFragment;
    private FragmentManager fm;
    private FragmentTransaction ft;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchFragment(homePageFragment);
                    return true;
                case R.id.navigation_nearby:
                    switchFragment(nearbyFragment);
                    return true;
                case R.id.navigation_shoppingcart:
                    switchFragment(shoppingCartFragment);
                    return true;
                case R.id.navigation_mypage:
                    switchFragment(myPageFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // 解决 BottomNavigationView 大于3个menu时文字不显示的问题
        navView.setLabelVisibilityMode(1);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initView();
    }

    private void initView() {
        homePageFragment = new HomePageFragment();
        nearbyFragment = new NearbyFragment();
        myPageFragment = new MyPageFragment();
        shoppingCartFragment = new ShoppingCartFragment();

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.add(R.id.fragment_content, homePageFragment).commit();
        fragment = homePageFragment;
    }

    /**
     * fragment 切换方法
     *
     * @param targetFragment
     * @return 对应的fragment
     */
    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction.hide(fragment).add(R.id.fragment_content, targetFragment).commit();
        } else {
            transaction.hide(fragment).show(targetFragment).commit();
        }
        fragment = targetFragment;
        return transaction;
    }
}
