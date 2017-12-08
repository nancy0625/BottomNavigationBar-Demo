package cn.edu.gdmec.android.navigationdemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.navigationdemo.fragment.Game_fragment;
import cn.edu.gdmec.android.navigationdemo.fragment.Home_fragment;
import cn.edu.gdmec.android.navigationdemo.fragment.Movie_fragment;
import cn.edu.gdmec.android.navigationdemo.fragment.Music_fragment;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,BottomNavigationBar.OnTabSelectedListener{
    private BottomNavigationBar bottomNavigationBar;
    private ViewPager viewPager;
    private List<Fragment> mList;
    private BadgeItem badgeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBottomNavigationBar();
    }

   public void initView() {
        mList = new ArrayList<>();
       mList.add(new Home_fragment());
       mList.add(new Music_fragment());
       mList.add(new Movie_fragment());
       mList.add(new Game_fragment());

       viewPager = (ViewPager)findViewById(R.id.viewPager);
       viewPager.setOnPageChangeListener(this);
       MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(),mList);
       viewPager.setAdapter(mainAdapter);
    }
    public void initBottomNavigationBar(){
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        badgeItem  = new BadgeItem().setHideOnSelect(true).setBackgroundColor(Color.RED).setText("08");


        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar.setBarBackgroundColor(R.color.black);

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"首页").setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"音乐").setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp,"电影").setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp,"游戏").setActiveColorResource(R.color.white))
                .setFirstSelectedPosition(0)
                .initialise();
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * Called when a tab enters the selected state.
     *
     * @param position The position of the tab that was selected
     */
    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);

    }

    /**
     * Called when a tab exits the selected state.
     *
     * @param position The position of the tab that was unselected
     */
    @Override
    public void onTabUnselected(int position) {

    }

    /**
     * Called when a tab that is already selected is chosen again by the user. Some applications
     * may use this action to return to the top level of a category.
     *
     * @param position The position of the tab that was reselected.
     */
    @Override
    public void onTabReselected(int position) {

    }
}
