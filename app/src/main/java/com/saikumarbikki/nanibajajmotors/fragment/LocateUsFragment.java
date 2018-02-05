package com.saikumarbikki.nanibajajmotors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saikumarbikki.nanibajajmotors.R;


/**
 * Created by sbikki on 12/5/2017.
 */

public class LocateUsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.locate_us_fragment_layout, container, false);
        return view;
    }


}
