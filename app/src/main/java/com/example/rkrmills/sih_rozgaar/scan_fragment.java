package com.example.rkrmills.sih_rozgaar;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import android.widget.TextView;
import android.widget.Toast;

public class scan_fragment extends Fragment implements View.OnClickListener {

    private IntentIntegrator qrScan;
    private Button buttonscan;
    private TextView application_id, user_id, pending, approve, hold_on;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_scan_fragment, null);
        //Toast.makeText(getActivity(), "creted", Toast.LENGTH_LONG).show();
        buttonscan = (Button) rootView.findViewById(R.id.buttonScan);
        application_id = (TextView) rootView.findViewById(R.id.application_id2);
        pending = (TextView) rootView.findViewById(R.id.pending);
        approve = (TextView) rootView.findViewById(R.id.approved);
        hold_on = (TextView) rootView.findViewById(R.id.hold_on);
        user_id = (TextView) rootView.findViewById(R.id.user_id2);

        pending.setVisibility(View.GONE);
        approve.setVisibility(View.GONE);
        hold_on.setVisibility(View.GONE);

        //  textViewGmail = (TextView) rootView.findViewById(R.id.textViewGmail);
        qrScan = new IntentIntegrator(getActivity());
        buttonscan.setOnClickListener(this);




        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                approve.setVisibility(View.GONE);
                hold_on.setVisibility(View.GONE);

            }
        });

        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        hold_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



//        buttonScan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent
//                qrScan.initiateScan();
//            }
//        });

        return rootView;
    }
//    public void scanner(View view){
//        qrScan.initiateScan();
//    }

//    //Getting the scan results
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Toast.makeText(getActivity(), "fxdfgfv", Toast.LENGTH_LONG).show();
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//        if (result != null) {
//            //if qrcode has nothing in it
//            if (result.getContents() == null) {
//                Toast.makeText(getActivity(), "Result Not Found", Toast.LENGTH_LONG).show();
//            } else {
//                //if qr contains data
//                try {
//                    //converting the data to json
//                    JSONObject obj = new JSONObject(result.getContents());
//                    //setting values to textviews
//                    application_id.setText(obj.getString("name"));
//                    user_id.setText(obj.getString("address"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    //if control comes here
//                    //that means the encoded format not matches
//                    //in this case you can display whatever data is available on the qrcode
//                    //to a toast
//                    Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_LONG).show();
//                }
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Toast.makeText(getActivity(), "meth", Toast.LENGTH_LONG).show();
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
//                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(),"not found!",Toast.LENGTH_SHORT).show();
            } else {
                //if qr contains data
                try {
                    Toast.makeText(getActivity(),"found!",Toast.LENGTH_SHORT).show();
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    application_id.setText(obj.getString("ApplicationID"));
                    user_id.setText(obj.getString("UserID"));

                    pending.setVisibility(View.VISIBLE);
                    approve.setVisibility(View.VISIBLE);
                    hold_on.setVisibility(View.VISIBLE);
                    //textViewGmail.setText(obj.getString("email"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                     Toast.makeText(getActivity(), result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            Toast.makeText(getActivity(), "last", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        qrScan.initiateScan();

    }
}


