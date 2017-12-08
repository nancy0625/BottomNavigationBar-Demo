package cn.edu.gdmec.android.navigationdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by asus on 2017/12/7.
 */

public class MainAdapter extends FragmentPagerAdapter {
    private List<Fragment> mListFragments;

    public MainAdapter(FragmentManager fm,List<Fragment> mListFragments) {
        super(fm);
        this.mListFragments = mListFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mListFragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mListFragments.size();
    }
}
