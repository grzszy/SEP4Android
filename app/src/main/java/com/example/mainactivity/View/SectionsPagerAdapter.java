package com.example.mainactivity.View;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mainactivity.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    /**
     * @author Mathias Hansen
     * @author Jakob Hansen
     */

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4};
    private final Context mContext;



    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     *
     * @param position get the position of the tab
     * @return returns the fragment at position
     */

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new Home_Fragment();
                break;
            case 1:
                fragment = new Forecast_Fragment();
                break;
            case 2:
                fragment = new Log_Fragment();
                break;
            case 3:
                fragment = new Warning_Fragment();
                break;
        }
        return fragment;
    }

    /**
     *
     * @param position get the position of the tab
     * @return returns the name of the fragment
     */

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    /**
     *
     * @return returns the number of fragment
     */

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}