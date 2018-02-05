package com.saikumarbikki.nanibajajmotors.fragment;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.saikumarbikki.nanibajajmotors.R;
import com.saikumarbikki.nanibajajmotors.Utills.MyConstants;
import com.saikumarbikki.nanibajajmotors.adapter.BikeImageCustomPageAdapter;
import com.saikumarbikki.nanibajajmotors.entities.BikeData;
import com.saikumarbikki.nanibajajmotors.interfaces.BikeImageClickListener;


/**
 * Created by sbikki on 1/17/2018.
 */

public class BikeImageFullScreenFragment extends Fragment {
    private BikeData selectedBike;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bikeimagefullscreenfragment_layout, container, false);
        selectedBike = getArguments().getParcelable(MyConstants.ARG_SELECTED_BIKE);
        int selectedImagePosition = getArguments().getInt("Selected_ImagePosition");

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        BikeImageCustomPageAdapter bikeImageCustomPageAdapter = new BikeImageCustomPageAdapter(getContext(), selectedBike.getBikeFaceImages());
        viewPager.setAdapter(bikeImageCustomPageAdapter);
        viewPager.setCurrentItem(selectedImagePosition);
        return view;
    }


}
