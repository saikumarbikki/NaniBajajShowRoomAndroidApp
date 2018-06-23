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

public class PlatinaTabFragment extends Fragment implements BikeItemEventListener {
    private Communicator communicatorListener;
    public PlatinaTabFragment() {
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
        View view =  inflater.inflate(R.layout.platina_tab_fragment_layout, container, false);
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
        BikeData mPlantina100ES = getPlantina100ESDetails();
        bikeModleList.add(mPlantina100ES);
        return bikeModleList;
    }

    private BikeData getPlantina100ESDetails() {
        ArrayList<Integer> plantinaBikeFaces = new ArrayList<>();
        plantinaBikeFaces.add(R.drawable.platina_100es);
        plantinaBikeFaces.add(R.drawable.platina2 );
        plantinaBikeFaces.add(R.drawable.platina3);

        ArrayList<Integer> bikeColorAvailability= new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.black);

        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Red");
        bikeColorNames.add("Black");

        //We are setting all the bike information to Bike data object by the help of constructor and setter method.
        BikeData mPlantina100ES = new BikeData(getString(R.string.platina_100ES_title), R.drawable.platina_100es, null);
        mPlantina100ES.setBikeFaceImages(plantinaBikeFaces);
        mPlantina100ES.setBikeColorAvailability(bikeColorAvailability);
        mPlantina100ES.setBikeColorName(bikeColorNames);
        mPlantina100ES.setBikeCapacity("102 cc");
        mPlantina100ES.setBikeFuelTankCapacity("11.5 L");
        mPlantina100ES.setBikeMaxPower("7.9 @ 7500");
        mPlantina100ES.setBikeWeight("111 kg");

        return mPlantina100ES;

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
