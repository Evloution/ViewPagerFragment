##### Android  实现购物APP底部和顶部导航栏

​	主要使用了 TabLayout + ViewPager + Fragment 组合实现的

##### 效果

​	![]( https://github.com/Evloution/ViewPagerFragment/blob/master/images/0c3b90a96ba604b256782f72f9e8630.jpg )

![]( https://github.com/Evloution/ViewPagerFragment/blob/master/images/227acdcd688e931dc044f9a2315dcb6.jpg )

![]( https://github.com/Evloution/ViewPagerFragment/blob/master/images/Video_20191213_040453_183.gif )



##### 引入依赖

```java
implementation 'com.android.support:design:28.0.0'
implementation 'com.android.support:recyclerview-v7:28.0.0'
implementation 'com.android.support:cardview-v7:28.0.0'
```

##### 代码

​	底部导航使用的 Android自带的导航切换

​	页面个数设置：

​	在 res/menu/bottom_nav_menu.xml 文件下，设置要在底部显示的图标和文字

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:id="@+id/navigation_home"
        android:icon="@mipmap/homepage_icon"
        android:title="@string/title_home" />

    <item
        android:id="@+id/navigation_nearby"
        android:icon="@mipmap/nearby_icon"
        android:title="@string/title_nearby" />

    <item
        android:id="@+id/navigation_shoppingcart"
        android:icon="@mipmap/shoppingcart_icon"
        android:title="@string/title_shoppingcart" />

    <item
        android:id="@+id/navigation_mypage"
        android:icon="@mipmap/mypage_icon"
        android:title="@string/title_mypage" />

</menu>
```

​	核心代码：切换碎片

```java
	/**
     * fragment 切换方法
     *
     * @param targetFragment
     * @return 对应的 fragment
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
```

##### 解决menu大于三个后显示不全的问题

​	开发过程中遇到了我添加了一个menu菜单后，底部导航栏显示不全，经过查阅资料得知，在初始化时加入	

​	navView.setLabelVisibilityMode(1); 即可。

```java
BottomNavigationView navView = findViewById(R.id.nav_view);
// 解决 BottomNavigationView 大于3个menu时文字不显示的问题
navView.setLabelVisibilityMode(1);
navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
```

顶部导航栏

​	我是在首页碎片中实现的顶部导航栏

```xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:fitsSystemWindows="true"
        android:orientation="vertical">

        <android.support.design.widget.TabLayout
            android:id="@+id/tl"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:tabGravity="fill"
            app:tabIndicatorColor="@color/colorPrimary"
            app:tabMode="fixed"
            app:tabSelectedTextColor="@color/colorPrimary"
            app:tabTextColor="@color/gray"></android.support.design.widget.TabLayout>

        <android.support.v4.view.ViewPager
            android:id="@+id/vp"
            android:layout_width="match_parent"
            android:layout_height="match_parent"></android.support.v4.view.ViewPager>

</LinearLayout>
	<!--
       app:tabMode="scrollable" 设置tabMode属性为可以滚动
       tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
       android design library提供的TabLayout控件
       tabIndicatorColor：菜单下方移动的横线的颜色
       tabSelectedTextColor ：菜单被选中之后的颜色
       tabTextColor : 菜单正常的颜色
       app:tabTextAppearance : 添加样式，这里加了样式主要是为了在文字前面加一个图所用，就是把textAllCaps设置成false
   -->
```

​	HomePageFragment：

```java
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
```

​	HomePagerAdapter.java

```java
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
```

