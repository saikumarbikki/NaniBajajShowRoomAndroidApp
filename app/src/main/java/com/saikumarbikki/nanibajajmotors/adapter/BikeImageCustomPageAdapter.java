package com.saikumarbikki.nanibajajmotors.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.saikumarbikki.nanibajajmotors.R;
import com.saikumarbikki.nanibajajmotors.interfaces.BikeImageClickListener;

import java.util.ArrayList;

/**
 * Created by sbikki on 1/1/2018.
 */

public class BikeImageCustomPageAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> images;
    private LayoutInflater layoutInflater;

    public void setImageClickListener(BikeImageClickListener imageClickListener) {
        this.imageClickListener = imageClickListener;
    }

    private BikeImageClickListener imageClickListener;

    public BikeImageCustomPageAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.viewpager_item, container, false);

        final ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(images.get(position));
        imageView.setTag(position);

        container.addView(itemView);

        //listening to image click
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != imageClickListener) {
                    imageClickListener.onImageItemClick(imageView, (int) imageView.getTag());
                }
            }
        });

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
