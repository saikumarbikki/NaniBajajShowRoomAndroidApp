package com.saikumarbikki.nanibajajmotors.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import com.saikumarbikki.nanibajajmotors.R;

/**
 * Created by sbikki on 1/28/2018.
 */

public class AboutDeveloperFragment extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_developer_fragment_layout, container, false);

        ImageView iv_LinkedIn = (ImageView) view.findViewById(R.id.iv_linkedIn);
        ImageView iv_FaceBook = (ImageView) view.findViewById(R.id.iv_fb);
        ImageView iv_Twiteer = (ImageView) view.findViewById(R.id.iv_twiteer);
//        ImageView iv_skype = (ImageView) view.findViewById(R.id.iv_skype);
        ImageView iv_GooglePlus = (ImageView) view.findViewById(R.id.iv_googleplus);
        ImageView iv_Instagram = (ImageView) view.findViewById(R.id.iv_instagram);

        iv_LinkedIn.setOnClickListener(this);
        iv_FaceBook.setOnClickListener(this);
        iv_Twiteer.setOnClickListener(this);
//        iv_skype.setOnClickListener(this);
        iv_GooglePlus.setOnClickListener(this);
        iv_Instagram.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_linkedIn: {
                Intent intent_LinkedIn = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/sai-kumar-b-36bb77159/"));
                startActivity(intent_LinkedIn);
                break;

            }
            case R.id.iv_fb: {
                Intent intent_FaceBook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/saisunny.bikki"));
                startActivity(intent_FaceBook);
                break;

            }
            case R.id.iv_twiteer: {
                Intent intent_Twitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/37c473177aa241b"));
                startActivity(intent_Twitter);
                break;

            }
         /*   case R.id.iv_skype: {
                Intent sky = new Intent("android.intent.action.VIEW");
                sky.setData(Uri.parse("skype:" + "saikumarbikki"));
                startActivity(sky);
                break;

            }*/
            case R.id.iv_googleplus: {
                Intent intent_GooglePlus = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/102377385853768993966/posts"));
                startActivity(intent_GooglePlus);
                break;

            }
            case R.id.iv_instagram: {

                Uri uri = Uri.parse("https://www.instagram.com/sai_goud_1213/");
                Intent intent_Instagram = new Intent(Intent.ACTION_VIEW, uri);
                intent_Instagram.setPackage("com.instagram.android");

                try {
                    startActivity(intent_Instagram);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.instagram.com/sai_goud_1213/")));
                }
                break;
            }

        }

    }
}
