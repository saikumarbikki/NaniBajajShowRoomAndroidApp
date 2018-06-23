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

public class DiscoverTabFragment extends Fragment implements BikeItemEventListener {
    private Communicator communicatorListener;

    public DiscoverTabFragment() {
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
        View view = inflater.inflate(R.layout.discover_tab_fragment_layout, container, false);

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
        //need to add discover models here.
        ArrayList<BikeData> bikeModleList = new ArrayList<>();
        BikeData mDiscover110 = getDiscover110Details();
        BikeData mDiscover125 = getDiscover125Details();
        bikeModleList.add(mDiscover110);
        bikeModleList.add(mDiscover125);
        return bikeModleList;
    }

    private BikeData getDiscover110Details() {
        ArrayList<Integer> discoverBikeFaces = new ArrayList<>();
        discoverBikeFaces.add(R.drawable.discover_110);
        discoverBikeFaces.add(R.drawable.discover_110_2);
        discoverBikeFaces.add(R.drawable.discover3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.blue19);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Red");
        bikeColorNames.add("Black");
        bikeColorNames.add("Blue");
        BikeData mDiscover110 = new BikeData(getString(R.string.discover_110_title), R.drawable.discover_110, null);
        mDiscover110.setBikeFaceImages(discoverBikeFaces);
        mDiscover110.setBikeColorAvailability(bikeColorAvailability);
        mDiscover110.setBikeColorName(bikeColorNames);
        mDiscover110.setBikeCapacity("115.45 cc");
        mDiscover110.setBikeFuelTankCapacity("8 L");
        mDiscover110.setBikeMaxPower("8.6 @ 7000");
        mDiscover110.setBikeWeight("--");
        return mDiscover110;

    }
    private BikeData getDiscover125Details() {
        ArrayList<Integer> discoverBikeFaces = new ArrayList<>();
        discoverBikeFaces.add(R.drawable.discover_125);
        discoverBikeFaces.add(R.drawable.discover2);
        discoverBikeFaces.add(R.drawable.discover3);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.blue19);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Red");
        bikeColorNames.add("Black");
        bikeColorNames.add("Blue");
        BikeData mDiscover125 = new BikeData(getString(R.string.discover_125_title), R.drawable.discover_125, null);
        mDiscover125.setBikeFaceImages(discoverBikeFaces);
        mDiscover125.setBikeColorAvailability(bikeColorAvailability);
        mDiscover125.setBikeColorName(bikeColorNames);
        mDiscover125.setBikeCapacity("124.5 cc");
        mDiscover125.setBikeFuelTankCapacity("8 L");
        mDiscover125.setBikeMaxPower("11 @7500");
        mDiscover125.setBikeWeight("--");
        return mDiscover125;
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
