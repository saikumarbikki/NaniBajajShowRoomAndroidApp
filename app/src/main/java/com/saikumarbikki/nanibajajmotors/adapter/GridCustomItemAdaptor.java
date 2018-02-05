package com.saikumarbikki.nanibajajmotors.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.saikumarbikki.nanibajajmotors.R;
import com.saikumarbikki.nanibajajmotors.interfaces.BikeItemEventListener;
import com.saikumarbikki.nanibajajmotors.entities.BikeData;

import java.util.ArrayList;

/**
 * Created by sbikki on 12/3/2017.
 */

public class GridCustomItemAdaptor extends BaseAdapter {
    Context mcontext;
    ArrayList<BikeData> bikeList;
    private BikeItemEventListener bikeItemEventListener;

    public GridCustomItemAdaptor(Context context, ArrayList<BikeData> argBikeList) {
        mcontext = context;
        //Data for custom Adaptor
        bikeList = argBikeList;

    }
    @Override
    public int getCount() {
        return bikeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // View for custom adaptor.

        if (view == null) {
            Log.d("Test123", "Position :" + position);
            //Here this is a normal java file so you need to add xml file to java so you need to use LayoutInflator.
            LayoutInflater layoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.grid_item_view_layout, parent, false);
        }
        TextView mBikeTitle_TV = (TextView) view.findViewById(R.id.gridview_bike_title);
        ImageView mBikeImageview = (ImageView) view.findViewById(R.id.gridview_bike_image);

        BikeData objBikeData = bikeList.get(position);

        mBikeTitle_TV.setText(objBikeData.getBikeName());
        mBikeImageview.setImageResource(objBikeData.getBikeImageResID());
        mBikeImageview.setTag(objBikeData);
        mBikeImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != bikeItemEventListener) {
                    bikeItemEventListener.onBikeItemClick((BikeData) v.getTag());
                }
            }
        });
        return view;

    }

    public void setBikeItemEventListener(BikeItemEventListener bikeItemEventListener) {
        this.bikeItemEventListener = bikeItemEventListener;
    }
}
