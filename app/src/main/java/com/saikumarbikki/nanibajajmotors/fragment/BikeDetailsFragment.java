package com.saikumarbikki.nanibajajmotors.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.saikumarbikki.nanibajajmotors.R;
import com.saikumarbikki.nanibajajmotors.Utills.MyConstants;
import com.saikumarbikki.nanibajajmotors.adapter.BikeImageCustomPageAdapter;
import com.saikumarbikki.nanibajajmotors.entities.BikeData;
import com.saikumarbikki.nanibajajmotors.interfaces.BikeImageClickListener;
import com.saikumarbikki.nanibajajmotors.interfaces.Communicator;

import java.util.ArrayList;


/**
 * Created by sbikki on 1/26/2018.
 */

public class BikeDetailsFragment extends Fragment implements BikeImageClickListener {

    private View rootView;
    private Communicator communicatorListener;
    private BikeData selectedBikeData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.bike_details_base_fragment_layout, container, false);
        Button getoffers_button = (Button) rootView.findViewById(R.id.getoffers_button);
        Button call_dealar_button = (Button) rootView.findViewById(R.id.calldealar_button);

        selectedBikeData = getArguments().getParcelable(MyConstants.ARG_SELECTED_BIKE);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        BikeImageCustomPageAdapter bikeImageCustomPageAdapter = new BikeImageCustomPageAdapter(getContext(), selectedBikeData.getBikeFaceImages());
        viewPager.setAdapter(bikeImageCustomPageAdapter);
        bikeImageCustomPageAdapter.setImageClickListener(this);
        TextView tv_bikeTitle = (TextView) rootView.findViewById(R.id.bike_title);
        tv_bikeTitle.setText(selectedBikeData.getBikeName());
        setOverViewData();
        setBikeColorsData();

        getoffers_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetBikeOffersFragment objGetBikeOffersFragment = new GetBikeOffersFragment();
                communicatorListener.addFragment(objGetBikeOffersFragment, true);
            }
        });
        call_dealar_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
        return rootView;
    }
    private void makePhoneCall() {
        String phone_no = "+919908243623";
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phone_no));
        startActivity(callIntent);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicatorListener = (Communicator) getActivity();
    }

    @Override
    public void onImageItemClick(ImageView imageView, int position) {
        Fragment fragment = new BikeImageFullScreenFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(MyConstants.ARG_SELECTED_BIKE, selectedBikeData);
        bundle.putInt("Selected_ImagePosition", position);
        fragment.setArguments(bundle);
        communicatorListener.addFragment(fragment, true);
    }

    private void setOverViewData() {
        TextView tv_Capacity = (TextView) rootView.findViewById(R.id.tv_capacity_value);
        TextView tv_Mileage = (TextView) rootView.findViewById(R.id.tv_fueltank_value);
        TextView tv_Weight = (TextView) rootView.findViewById(R.id.tv_weight_value);
        TextView tv_MaxPower = (TextView) rootView.findViewById(R.id.tv_maxpower_value);
        tv_Capacity.setText(selectedBikeData.getBikeCapacity());
        tv_Mileage.setText(selectedBikeData.getBikeFuelTankCapacity());
        tv_Weight.setText(selectedBikeData.getBikeWeight());
        tv_MaxPower.setText(selectedBikeData.getBikeMaxPower());
    }

    private void setBikeColorsData() {
        ArrayList<Integer> bikeColorCodes = selectedBikeData.getBikeColorAvaliblity();
        ArrayList<String> bikeColorNames = selectedBikeData.getBikeColorName();
        for (int i = 0; i < bikeColorCodes.size(); i++) {
            switch (i) {
                case 0: {
                    setBikeAvalibleColorsToView(i, R.id.color_first_view, R.id.color_first_view_tv);
                    break;
                }
                case 1: {
                    setBikeAvalibleColorsToView(i, R.id.color_second_view, R.id.color_second_view_tv);
                    break;
                }
                case 2: {
                    setBikeAvalibleColorsToView(i, R.id.color_third_view, R.id.color_third_view_tv);
                    break;
                }
                case 3: {
                    setBikeAvalibleColorsToView(i, R.id.color_fourth_view, R.id.color_fourth_view_tv);
                    break;
                }
                case 4: {
                    setBikeAvalibleColorsToView(i, R.id.color_fifth_view, R.id.color_fifth_view_tv);
                    break;
                }
            }
        }


    }

    private void setBikeAvalibleColorsToView(int position, int imageResID, int textViewID) {
        ArrayList<Integer> bikeColorCodes = selectedBikeData.getBikeColorAvaliblity();
        ArrayList<String> bikeColorNames = selectedBikeData.getBikeColorName();
        ImageView imageView = (ImageView) rootView.findViewById(imageResID);
        imageView.setBackgroundColor(getResources().getColor(bikeColorCodes.get(position)));
        imageView.setVisibility(View.VISIBLE);
        TextView textView = (TextView) rootView.findViewById(textViewID);
        textView.setText(bikeColorNames.get(position));
        textView.setVisibility(View.VISIBLE);
    }

}


