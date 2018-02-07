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

public class VTabFragment extends Fragment implements BikeItemEventListener {
    private Communicator communicatorListener;
    public VTabFragment() {
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
        View view =  inflater.inflate(R.layout.v_tab_fragment_layout, container, false);
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
        BikeData mV12 = getV12Details();
        BikeData mV15 = getV15Details();
        bikeModleList.add(mV12);
        bikeModleList.add(mV15);
        return bikeModleList;
    }


    private BikeData getV12Details() {
        ArrayList<Integer> v12BikeFaces = new ArrayList<>();
        v12BikeFaces.add(R.drawable.v12);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Black");
        BikeData mV12 = new BikeData(getString(R.string.V_12_title), R.drawable.v12, null);
        mV12.setBikeFaceImages(v12BikeFaces);
        mV12.setBikeColorAvaliblity(bikeColorAvailability);
        mV12.setBikeColorName(bikeColorNames);
        mV12.setBikeCapacity("124.5 cc");
        mV12.setBikeFuelTankCapacity("13 L");
        mV12.setBikeMaxPower("10.7 @ 7500");
        mV12.setBikeWeight("133 kg");
        return mV12;
    }

    private BikeData getV15Details() {
        ArrayList<Integer> v15BikeFaces = new ArrayList<>();
        v15BikeFaces.add(R.drawable.v15);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.lite_fb_blue);
        bikeColorAvailability.add(R.color.blue19);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Heroic Red");
        bikeColorNames.add("Ebony Black");
        bikeColorNames.add("Ocean Blue");
        bikeColorNames.add("Stylish Backrest");
        BikeData mV15 = new BikeData(getString(R.string.V_15_title), R.drawable.v15, null);
        mV15.setBikeFaceImages(v15BikeFaces);
        mV15.setBikeColorAvaliblity(bikeColorAvailability);
        mV15.setBikeColorName(bikeColorNames);
        mV15.setBikeCapacity("149.5 cc");
        mV15.setBikeFuelTankCapacity("13 L");
        mV15.setBikeMaxPower("12.0 @ 7500");
        mV15.setBikeWeight("137 kg");
        return mV15;
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
