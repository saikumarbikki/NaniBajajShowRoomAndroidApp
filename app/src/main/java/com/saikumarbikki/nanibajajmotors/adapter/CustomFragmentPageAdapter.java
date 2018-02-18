package com.saikumarbikki.nanibajajmotors.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.AvengerTabFragment;
import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.CT100TabFragment;
import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.DiscoverTabFragment;
import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.DominarTabFragment;
import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.PlatinaTabFragment;
import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.PulsarTabFragment;
import com.saikumarbikki.nanibajajmotors.tabviewbikemodels.VTabFragment;

public class CustomFragmentPageAdapter extends FragmentPagerAdapter{

    private static final String TAG = CustomFragmentPageAdapter.class.getSimpleName();

    private static final int FRAGMENT_COUNT = 7;

    public CustomFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PulsarTabFragment();
            case 1:
                return new DiscoverTabFragment();
            case 2:
                return new PlatinaTabFragment();
            case 3:
                return new CT100TabFragment();
            case 4:
                return new VTabFragment();
            case 5:
                return new DominarTabFragment();
            case 6:
                return new AvengerTabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "PULSAR";
            case 1:
                return "DISCOVER";
            case 2:
                return "PLATINA";
            case 3:
                return "CT 100";
            case 4:
                return "V";
            case 5:
                return "DOMINAR";
            case 6:
                return "AVENGER";

        }
        return null;
    }
}
