package com.saikumarbikki.nanibajajmotors.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.saikumarbikki.nanibajajmotors.R;


/**
 * Created by sbikki on 12/5/2017.
 */

public class ContactUsFragment extends Fragment implements View.OnClickListener {
    TextView contact1_Phone, contact2_Phone, contact3_Phone, contact4_Phone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_us, container, false);
        ImageView nani_Contact_us_email = (ImageView) view.findViewById(R.id.contact_us_email_IV);

        //Contact1 information
        contact1_Phone = (TextView) view.findViewById(R.id.contactus_phone_showrooms_tv);
        ImageView contact1_Phone_Icon = (ImageView) view.findViewById(R.id.contactus_phone_showrooms_phone_icon);
        ImageView Contact1_sms_icon = (ImageView) view.findViewById(R.id.contactus_phone_showrooms_SMS_icon);

        //Contact2 information
        contact2_Phone = (TextView) view.findViewById(R.id.contactus_phone_daddy_tv);
        ImageView contact2_Phone_Icon = (ImageView) view.findViewById(R.id.contactus_phone_daddy_icon);
        ImageView Contact2_sms_icon = (ImageView) view.findViewById(R.id.contactus_daddy_SMS_icon);

        //Contact3 information
        contact3_Phone = (TextView) view.findViewById(R.id.contactus_phone_showroom_1_tv);
        ImageView contact3_Phone_Icon = (ImageView) view.findViewById(R.id.contactus_phone_showroom_1_phone_icon);
        ImageView Contact3_sms_icon = (ImageView) view.findViewById(R.id.contactus_phone_showroom_1_SMS_icon);

        //Contact4 information
        contact4_Phone = (TextView) view.findViewById(R.id.contactus_phone_showroom_2_tv);
        ImageView contact4_Phone_Icon = (ImageView) view.findViewById(R.id.contactus_phone_showroom_2_phone_icon);
        ImageView Contact4_sms_icon = (ImageView) view.findViewById(R.id.contactus_phone_showroom_2_SMS_icon);

        contact1_Phone_Icon.setOnClickListener(this);
        Contact1_sms_icon.setOnClickListener(this);
        contact2_Phone_Icon.setOnClickListener(this);
        Contact2_sms_icon.setOnClickListener(this);
        contact3_Phone_Icon.setOnClickListener(this);
        Contact3_sms_icon.setOnClickListener(this);
        contact4_Phone_Icon.setOnClickListener(this);
        Contact4_sms_icon.setOnClickListener(this);
        nani_Contact_us_email.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.contactus_phone_showrooms_phone_icon: {
                makePhoneCall(contact1_Phone);
                break;
            }
            case R.id.contactus_phone_daddy_icon: {
                makePhoneCall(contact2_Phone);
                break;
            }
            case R.id.contactus_phone_showroom_1_phone_icon: {
                makePhoneCall(contact3_Phone);
                break;
            }
            case R.id.contactus_phone_showroom_2_phone_icon: {
                makePhoneCall(contact4_Phone);
                break;
            }
            case R.id.contactus_phone_showrooms_SMS_icon: {
                sendSMS(contact1_Phone);
                break;
            }
            case R.id.contactus_daddy_SMS_icon: {
                sendSMS(contact2_Phone);
                break;
            }
            case R.id.contactus_phone_showroom_1_SMS_icon: {
                sendSMS(contact3_Phone);
                break;
            }
            case R.id.contactus_phone_showroom_2_SMS_icon: {
                sendSMS(contact4_Phone);
                break;
            }
            case R.id.contact_us_email_IV: {
                sendEmail();
                break;
            }
        }
    }

    private void sendEmail() {
        String[] TO = {getString(R.string.Nani_Email)};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/RFC822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void makePhoneCall(TextView phoneNumber_TV) {
        String phone_no = phoneNumber_TV.getText().toString().replaceAll("-", "");
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + phone_no));
        startActivity(callIntent);
    }

    private void sendSMS(TextView phonenumber_tv) {
        String phone_no = phonenumber_tv.getText().toString().replaceAll("-", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", phone_no);
        startActivity(smsIntent);
    }
}
