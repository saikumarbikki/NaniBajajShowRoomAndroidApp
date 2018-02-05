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

public class CT100TabFragment extends Fragment implements BikeItemEventListener {
    private Communicator communicatorListener;

    public CT100TabFragment() {
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
        View view = inflater.inflate(R.layout.ct100_tab_fragment_layout, container, false);
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
        BikeData mCT100B = getCT100BDetails();
        BikeData mCT100_KS_Alloy = getCT100_KS_AlloyDetails();
        BikeData mCT100_ES_Alloy = getCT100_ES_AlloyDetails();
        bikeModleList.add(mCT100B);
        bikeModleList.add(mCT100_KS_Alloy);
        bikeModleList.add(mCT100_ES_Alloy);
        return bikeModleList;
    }

    private BikeData getCT100BDetails() {
        ArrayList<Integer> discoverBikeFaces = new ArrayList<>();
        discoverBikeFaces.add(R.drawable.ct_100b);
        discoverBikeFaces.add(R.drawable.ct_100_2);
        discoverBikeFaces.add(R.drawable.ct_100_3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Flame Red");
        bikeColorNames.add("EBONY BLACK \n(BLUE DECALS)");
        bikeColorNames.add("EBONY BLACK \n (RED DECALS)");
        BikeData mCT100B = new BikeData(getString(R.string.CT_100B_title), R.drawable.ct_100b, null);
        mCT100B.setBikeFaceImages(discoverBikeFaces);
        mCT100B.setBikeColorAvaliblity(bikeColorAvailability);
        mCT100B.setBikeColorName(bikeColorNames);
        mCT100B.setBikeCapacity("99.27 cc");
        mCT100B.setBikeFuelTankCapacity("10.5 L");
        mCT100B.setBikeMaxPower("8.2 @ 7500");
        mCT100B.setBikeWeight("109 kg");
        return mCT100B;
    }
    private BikeData getCT100_KS_AlloyDetails() {
        ArrayList<Integer> discoverBikeFaces = new ArrayList<>();
        discoverBikeFaces.add(R.drawable.ct_100_ks_alloy);
        discoverBikeFaces.add(R.drawable.ct_100_2);
        discoverBikeFaces.add(R.drawable.ct_100_3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Flame Red");
        bikeColorNames.add("EBONY BLACK \n(BLUE DECALS)");
        bikeColorNames.add("EBONY BLACK \n (RED DECALS)");
        BikeData mCT100B = new BikeData(getString(R.string.CT_100_KS_Alloy_title), R.drawable.ct_100_ks_alloy, null);
        mCT100B.setBikeFaceImages(discoverBikeFaces);
        mCT100B.setBikeColorAvaliblity(bikeColorAvailability);
        mCT100B.setBikeColorName(bikeColorNames);
        mCT100B.setBikeCapacity("99.27 cc");
        mCT100B.setBikeFuelTankCapacity("10.5 L");
        mCT100B.setBikeMaxPower("8.2 @ 7500");
        mCT100B.setBikeWeight("110 kg");
        return mCT100B;
    }
    private BikeData getCT100_ES_AlloyDetails() {
        ArrayList<Integer> discoverBikeFaces = new ArrayList<>();
        discoverBikeFaces.add(R.drawable.ct_100_es_alloy);
        discoverBikeFaces.add(R.drawable.ct_100_2);
        discoverBikeFaces.add(R.drawable.ct_100_3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Flame Red");
        bikeColorNames.add("EBONY BLACK \n(BLUE DECALS)");
        bikeColorNames.add("EBONY BLACK \n (RED DECALS)");
        BikeData mCT100B = new BikeData(getString(R.string.CT_100_ES_Alloy_title), R.drawable.ct_100_es_alloy, null);
        mCT100B.setBikeFaceImages(discoverBikeFaces);
        mCT100B.setBikeColorAvaliblity(bikeColorAvailability);
        mCT100B.setBikeColorName(bikeColorNames);
        mCT100B.setBikeCapacity("102 cc");
        mCT100B.setBikeFuelTankCapacity("10.5 L");
        mCT100B.setBikeMaxPower("7.7 @ 7500");
        mCT100B.setBikeWeight("110 kg");
        return mCT100B;
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
