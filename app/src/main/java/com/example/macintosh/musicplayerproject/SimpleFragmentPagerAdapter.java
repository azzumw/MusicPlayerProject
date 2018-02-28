package com.example.macintosh.musicplayerproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by macintosh on 28/02/2018.
 */

class SimpleFragmentPagerAdapter extends FragmentPagerAdapter{
    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new PLaylistFragment();
            case 1: return new SonglistFragment();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "PLAYLIST";
            case 1: return "SONGS";
            default: return null;
        }
    }
}
