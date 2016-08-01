package cl.cutiko.shrinkquizz.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import cl.cutiko.shrinkquizz.R;
import cl.cutiko.shrinkquizz.views.MainActivity;
import cl.cutiko.shrinkquizz.views.cool.CoolFragment;
import cl.cutiko.shrinkquizz.views.lucky.LuckyFragment;
import cl.cutiko.shrinkquizz.views.match.MatchFragment;


public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CoolFragment().newInstance();
            case 1:
                return new LuckyFragment().newInstance();
            case 2:
                return new MatchFragment().newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.cool_fragment);
            case 1:
                return context.getString(R.string.lucky_fragment);
            case 2:
                return context.getString(R.string.match_fragment);
        }
        return null;
    }
}
