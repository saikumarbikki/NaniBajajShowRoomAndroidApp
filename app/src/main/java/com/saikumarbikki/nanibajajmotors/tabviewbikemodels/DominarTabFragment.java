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

public class DominarTabFragment extends Fragment implements BikeItemEventListener {
    private Communicator communicatorListener;
    public DominarTabFragment() {
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
        View view = inflater.inflate(R.layout.dominer_tab_fragment_layout, container, false);
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
        BikeData mDominar400 = getDominar400Details();
        bikeModleList.add(mDominar400);
        return bikeModleList;
    }

    private BikeData getDominar400Details() {
        ArrayList<Integer> dominarBikeFaces = new ArrayList<>();
        dominarBikeFaces.add(R.drawable.dominar_12345);
        dominarBikeFaces.add(R.drawable.dominar_400);
        dominarBikeFaces.add(R.drawable.bajaj_dominar_400_red);
        dominarBikeFaces.add(R.drawable.bajajdominar123);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.moon_white);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.blue19);
        bikeColorAvailability.add(R.color.plum);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Moon White");
        bikeColorNames.add("Matte Black");
        bikeColorNames.add("Midnight Blue");
        bikeColorNames.add("Twilight Plum");
        BikeData mDonminar400 = new BikeData(getString(R.string.dominar_400_title), R.drawable.dominar_12345, null);
        mDonminar400.setBikeFaceImages(dominarBikeFaces);
        mDonminar400.setBikeColorAvaliblity(bikeColorAvailability);
        mDonminar400.setBikeColorName(bikeColorNames);
        mDonminar400.setBikeCapacity("373.3 cc");
        mDonminar400.setBikeFuelTankCapacity("13 L");
        mDonminar400.setBikeMaxPower("35 @ 8000");
        mDonminar400.setBikeWeight("182 kg");
        return mDonminar400;
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
