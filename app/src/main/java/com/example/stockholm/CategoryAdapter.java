package com.example.stockholm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */

public class CategoryAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"Museums", "Eating", "Drinking", "Shopping"};

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MuseumsFragment();
        } else if (position == 1) {
            return new EatingFragment();
        } else if (position == 2) {
            return new DrinkingFragment();
        } else {
            return new ShoppingFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}