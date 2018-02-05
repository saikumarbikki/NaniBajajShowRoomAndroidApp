package com.saikumarbikki.nanibajajmotors.tabviewbikemodels;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.saikumarbikki.nanibajajmotors.R;
import com.saikumarbikki.nanibajajmotors.Utills.MyConstants;
import com.saikumarbikki.nanibajajmotors.adapter.GridCustomItemAdaptor;
import com.saikumarbikki.nanibajajmotors.entities.BikeData;
import com.saikumarbikki.nanibajajmotors.fragment.BikeDetailsFragment;
import com.saikumarbikki.nanibajajmotors.interfaces.BikeItemEventListener;
import com.saikumarbikki.nanibajajmotors.interfaces.Communicator;

import java.util.ArrayList;

/**
 * Created by sbikki on 1/23/2018.
 */

public class AvengerTabFragment extends Fragment implements BikeItemEventListener {
    private Communicator communicatorListener;
    public AvengerTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.avenger_tab_fragment_layout, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.grid_view_bikeimage_title);
        ArrayList<BikeData> bikeModlesData = getBikesModels();
        //Custom Adaptor(need to use adaptor for gridView)
        GridCustomItemAdaptor objGridCustomItemAdaptor = new GridCustomItemAdaptor(getContext(), bikeModlesData);
        gridView.setAdapter(objGridCustomItemAdaptor);
        objGridCustomItemAdaptor.setBikeItemEventListener(this);
        getActivity().setTitle(R.string.app_name);
        return view;
    }

    private ArrayList<BikeData> getBikesModels() {
        ArrayList<BikeData> bikeModleList = new ArrayList<>();
        BikeData mAvengerCruise220 = getAvengerCruise220Details();
        BikeData mAvengerStreet220 = getAvengerStreet220Details();
        BikeData mAvengerStreet150 = getAvengerStreet150Details();
        bikeModleList.add(mAvengerCruise220);
        bikeModleList.add(mAvengerStreet220);
        bikeModleList.add(mAvengerStreet150);
        return bikeModleList;
    }

    private BikeData getAvengerCruise220Details() {
        ArrayList<Integer> getAvengerCrusie220BikeFaces = new ArrayList<>();
        getAvengerCrusie220BikeFaces.add(R.drawable.avenger_cruise_220);
        getAvengerCrusie220BikeFaces.add(R.drawable.avenger2);
        getAvengerCrusie220BikeFaces.add(R.drawable.avenger3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.lite_fb_blue);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.ltgrey12);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Blue");
        bikeColorNames.add("Black matte");
        bikeColorNames.add("Silver");
        BikeData mAvengerCrusie220 = new BikeData(getString(R.string.avenger_cruise_220_title), R.drawable.avenger_cruise_220, null);
        mAvengerCrusie220.setBikeFaceImages(getAvengerCrusie220BikeFaces);
        mAvengerCrusie220.setBikeColorAvaliblity(bikeColorAvailability);
        mAvengerCrusie220.setBikeColorName(bikeColorNames);
        mAvengerCrusie220.setBikeCapacity("220 cc");
        mAvengerCrusie220.setBikeFuelTankCapacity("13 L");
        mAvengerCrusie220.setBikeMaxPower("19.03 @ 8400");
        mAvengerCrusie220.setBikeWeight("159 kg");
        return mAvengerCrusie220;
    }
    private BikeData getAvengerStreet220Details() {
        ArrayList<Integer> getAvengerStreet220BikeFaces = new ArrayList<>();
        getAvengerStreet220BikeFaces.add(R.drawable.avenger_street_220);
        getAvengerStreet220BikeFaces.add(R.drawable.avenger2);
        getAvengerStreet220BikeFaces.add(R.drawable.avenger3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.lite_fb_blue);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.ltgrey12);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Blue");
        bikeColorNames.add("Black matte");
        bikeColorNames.add("Silver");
        BikeData mAvengerStreet220 = new BikeData(getString(R.string.avenger_street_220_title), R.drawable.avenger_street_220, null);
        mAvengerStreet220.setBikeFaceImages(getAvengerStreet220BikeFaces);
        mAvengerStreet220.setBikeColorAvaliblity(bikeColorAvailability);
        mAvengerStreet220.setBikeColorName(bikeColorNames);
        mAvengerStreet220.setBikeCapacity("220 cc");
        mAvengerStreet220.setBikeFuelTankCapacity("14 L");
        mAvengerStreet220.setBikeMaxPower("19.03 @ 8400");
        mAvengerStreet220.setBikeWeight("150 kg");
        return mAvengerStreet220;
    }
    private BikeData getAvengerStreet150Details() {
        ArrayList<Integer> getAvengerStreet150BikeFaces = new ArrayList<>();
        getAvengerStreet150BikeFaces.add(R.drawable.avenger_street150);
        getAvengerStreet150BikeFaces.add(R.drawable.avenger2);
        getAvengerStreet150BikeFaces.add(R.drawable.avenger3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.lite_fb_blue);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.ltgrey12);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Blue");
        bikeColorNames.add("Black matte");
        bikeColorNames.add("Silver");
        BikeData mAvengerStreet150 = new BikeData(getString(R.string.avenger_street_150_title), R.drawable.avenger_street150, null);
        mAvengerStreet150.setBikeFaceImages(getAvengerStreet150BikeFaces);
        mAvengerStreet150.setBikeColorAvaliblity(bikeColorAvailability);
        mAvengerStreet150.setBikeColorName(bikeColorNames);
        mAvengerStreet150.setBikeCapacity("150 cc");
        mAvengerStreet150.setBikeFuelTankCapacity("14 L");
        mAvengerStreet150.setBikeMaxPower("14.54 @ 9000");
        mAvengerStreet150.setBikeWeight("148 kg");
        return mAvengerStreet150;
    }

    @Override
    public void onBikeItemClick(BikeData selectedBikeData) {
        //sending selected bike data object to bikedetails fragment.

        BikeDetailsFragment bikeDetailsFragment = new BikeDetailsFragment();
        Bundle bundle = new Bundle();
        // object is created for each selected bike and passed thriugh out  the application(Parcelable means object)
        bundle.putParcelable(MyConstants.ARG_SELECTED_BIKE, selectedBikeData);
        bikeDetailsFragment.setArguments(bundle);
        communicatorListener.addFragment(bikeDetailsFragment, true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicatorListener = (Communicator) getActivity();
    }
}

