package com.saikumarbikki.nanibajajmotors.tabviewbikemodels;

import android.os.Bundle;
import android.support.annotation.NonNull;
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

public class PulsarTabFragment extends Fragment implements BikeItemEventListener {

    private Communicator communicatorListener;

    public PulsarTabFragment() {
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
        View view = inflater.inflate(R.layout.pulsar_tab_fragment_layout, container, false);

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
        BikeData mPulsar150 = getPulsar150Details();
        BikeData mPulsar180 = getPulsar180Details();
        BikeData mPulsar135LS = getPulsar135LSDetails();
        BikeData mPulsar220F = getPulsar220FDetails();
        BikeData mPulsarNS160 = getPulsarNS160Details();
        BikeData mPulsarNS200 = getPulsarNS200Details();
        BikeData mPulsarRS200 = getPulsarRS200Details();
        bikeModleList.add(mPulsar150);
        bikeModleList.add(mPulsar180);
        bikeModleList.add(mPulsar135LS);
        bikeModleList.add(mPulsar220F);
        bikeModleList.add(mPulsarNS160);
        bikeModleList.add(mPulsarNS200);
        bikeModleList.add(mPulsarRS200);
        return bikeModleList;
    }

    //Bike Details for each Pulsar Model
    //we need add all the Pulsar specific info only here.

    @NonNull
    private BikeData getPulsar150Details() {

        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_150);
        pulsarBikeFaces.add(R.drawable.pulsar2);
        pulsarBikeFaces.add(R.drawable.pulsar3);

        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.blue21);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);

        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Dyno Red");
        bikeColorNames.add("Nuclear Blue");
        bikeColorNames.add("Black Pack");
        bikeColorNames.add("Chrome Black");
        bikeColorNames.add("Laser Black");

        //We are setting all the bike information to Bike data object by the help of constructor and setter method.

        BikeData mPulsar150 = new BikeData(getString(R.string.pulsar_150_title), R.drawable.pulsar_150, null);
        mPulsar150.setBikeFaceImages(pulsarBikeFaces);
        mPulsar150.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsar150.setBikeColorName(bikeColorNames);
        mPulsar150.setBikeCapacity("149 cc");
        mPulsar150.setBikeFuelTankCapacity("15 L");
        mPulsar150.setBikeMaxPower("14 @ 8000");
        mPulsar150.setBikeWeight("144 kg");
        return mPulsar150;
    }

    private BikeData getPulsar180Details() {
        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_180);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.blue21);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Dyno Red");
        bikeColorNames.add("Nuclear Blue");
        bikeColorNames.add("Black Pack");
        bikeColorNames.add("Chrome Black");
        bikeColorNames.add("Laser Black");
        BikeData mPulsar180 = new BikeData(getString(R.string.pulsar_180_title), R.drawable.pulsar_180, null);
        mPulsar180.setBikeFaceImages(pulsarBikeFaces);
        mPulsar180.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsar180.setBikeColorName(bikeColorNames);
        mPulsar180.setBikeCapacity("178.6 cc");
        mPulsar180.setBikeFuelTankCapacity("15 L");
        mPulsar180.setBikeMaxPower("17.02 @ 8500");
        mPulsar180.setBikeWeight("145 kg");
        return mPulsar180;
    }

    private BikeData getPulsar135LSDetails() {
        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_135ls);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.blue21);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Dyno Red");
        bikeColorNames.add("Nuclear Blue");
        bikeColorNames.add("Chrome Black");
        bikeColorNames.add("Laser Black");
        BikeData mPulsar135LS = new BikeData(getString(R.string.pulsar_135LS_title), R.drawable.pulsar_135ls, null);
        mPulsar135LS.setBikeFaceImages(pulsarBikeFaces);
        mPulsar135LS.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsar135LS.setBikeColorName(bikeColorNames);
        mPulsar135LS.setBikeCapacity("134.6 cc");
        mPulsar135LS.setBikeFuelTankCapacity("8 L");
        mPulsar135LS.setBikeMaxPower("13.56 @ 9000");
        mPulsar135LS.setBikeWeight("121 kg");
        return mPulsar135LS;
    }

    private BikeData getPulsar220FDetails() {
        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_220f);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.blue21);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Dyno Red");
        bikeColorNames.add("Nuclear Blue");
        bikeColorNames.add("Black Pack");
        bikeColorNames.add("Chrome Black");
        bikeColorNames.add("Laser Black");
        BikeData mPulsar220F = new BikeData(getString(R.string.pulsar_220F_title), R.drawable.pulsar_220f, null);
        mPulsar220F.setBikeFaceImages(pulsarBikeFaces);
        mPulsar220F.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsar220F.setBikeColorName(bikeColorNames);
        mPulsar220F.setBikeCapacity("220 cc");
        mPulsar220F.setBikeFuelTankCapacity("15 L");
        mPulsar220F.setBikeMaxPower("20.93 @ 8500");
        mPulsar220F.setBikeWeight("155 kg");
        return mPulsar220F;
    }

    private BikeData getPulsarNS160Details() {
        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_ns160);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.fossil_grey);
        bikeColorAvailability.add(R.color.blue21);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Wild Red");
        bikeColorNames.add("Fossil Grey");
        bikeColorNames.add("Saffire Blue");
        BikeData mPulsarNS160 = new BikeData(getString(R.string.pulsar_NS160_title), R.drawable.pulsar_ns160, null);
        mPulsarNS160.setBikeFaceImages(pulsarBikeFaces);
        mPulsarNS160.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsarNS160.setBikeColorName(bikeColorNames);
        mPulsarNS160.setBikeCapacity("160.3 cc");
        mPulsarNS160.setBikeFuelTankCapacity("12 L");
        mPulsarNS160.setBikeMaxPower("15.5 @ 8500 ");
        mPulsarNS160.setBikeWeight("142 kg");
        return mPulsarNS160;
    }

    private BikeData getPulsarNS200Details() {
        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_ns200);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.red);
        bikeColorAvailability.add(R.color.moon_white);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Wild Red");
        bikeColorNames.add("Mirage White");
        bikeColorNames.add("Graphite Black");
        BikeData mPulsarNS200 = new BikeData(getString(R.string.pulsar_NS220_title), R.drawable.pulsar_ns200, null);
        mPulsarNS200.setBikeFaceImages(pulsarBikeFaces);
        mPulsarNS200.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsarNS200.setBikeColorName(bikeColorNames);
        mPulsarNS200.setBikeCapacity("199.5 cc");
        mPulsarNS200.setBikeFuelTankCapacity("12 L");
        mPulsarNS200.setBikeMaxPower("23.5 @ 9500");
        mPulsarNS200.setBikeWeight("154 (ABS) \n" + "152 (DD)");
        return mPulsarNS200;
    }

    private BikeData getPulsarRS200Details() {
        ArrayList<Integer> pulsarBikeFaces = new ArrayList<>();
        pulsarBikeFaces.add(R.drawable.pulsar_rs200);
        ArrayList<Integer> bikeColorAvailability = new ArrayList<>();
        bikeColorAvailability.add(R.color.blue21);
        bikeColorAvailability.add(R.color.black);
        ArrayList<String> bikeColorNames = new ArrayList<>();
        bikeColorNames.add("Racing Blue");
        bikeColorNames.add("Graphite Black");
        BikeData mPulsarRS200 = new BikeData(getString(R.string.pulsar_RS220_title), R.drawable.pulsar_rs200, null);
        mPulsarRS200.setBikeFaceImages(pulsarBikeFaces);
        mPulsarRS200.setBikeColorAvaliblity(bikeColorAvailability);
        mPulsarRS200.setBikeColorName(bikeColorNames);
        mPulsarRS200.setBikeCapacity("199.5 cc");
        mPulsarRS200.setBikeFuelTankCapacity("13 L");
        mPulsarRS200.setBikeMaxPower("23.5 @ 9500");
        mPulsarRS200.setBikeWeight("154 (ABS) \n" + "152 (DD)");
        return mPulsarRS200;
    }

    @Override
    public void onBikeItemClick(BikeData selectedBikeData) {
        //sending selected bike data object to bikedetails fragment.

        BikeDetailsFragment bikeDetailsFragment = new BikeDetailsFragment();
        Bundle bundle = new Bundle();
        // object is created for each selected bike and passed through out  the application(Parcelable means object)
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
