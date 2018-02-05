package com.saikumarbikki.nanibajajmotors.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.saikumarbikki.nanibajajmotors.R;

import java.util.regex.Pattern;

/**
 * Created by sbikki on 2/2/2018.
 */

public class GetBikeOffersFragment extends Fragment {

    private EditText et_phonenumber;
    private EditText et_customerName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.get_offers_fragment, container, false);
        et_customerName = (EditText) view.findViewById(R.id.custumer_name);
        et_phonenumber = (EditText) view.findViewById(R.id.custumer_phone);
        Button bt_submit = (Button) view.findViewById(R.id.submit_button);
        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidMobile(et_phonenumber.getText().toString())) {
                    sendSMS();
                } else {
                    return;
                }
            }

        });
        return view;
    }

    public void sendSMS() {
        try {
            String smsMsg = "Hi Nani Showroom Team, Please share latest bike offers." + "\nThis is " + et_customerName.getText().toString() + "\n Contact me: " + et_phonenumber.getText().toString() ;
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage("+919908243623", null, smsMsg, null, null);
            Toast.makeText(getContext(), " We will get back to you soon with latest offers.", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getContext(), " message sending failed.", Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private boolean isValidMobile(String phone) {
        boolean check = false;
        if (!Pattern.matches("[a-zA-Z]+", phone)) {
            if (phone.length() != 10) {
                // if(phone.length() != 10) {
                check = false;
                et_phonenumber.setError("Not Valid Number");
            } else {
                check = true;
            }
        } else {
            check = false;
        }
        return check;
    }
}
