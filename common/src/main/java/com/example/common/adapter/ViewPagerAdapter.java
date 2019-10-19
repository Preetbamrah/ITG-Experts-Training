package com.example.common.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.common.activities.NewStudentFragment;
import com.example.common.activities.ReferencedFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position==0)
        {
            fragment = new ReferencedFragment();
        }
        if (position==1)
        {
            fragment = new NewStudentFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0)
        {
            title = "By Reference";
        }
        if (position==1)
        {
            title = "New";
        }
        return title;
    }
}
