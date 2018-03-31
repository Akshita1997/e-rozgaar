package com.example.rkrmills.sih_rozgaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.AppController;

import static com.example.rkrmills.sih_rozgaar.MainActivity.token;

public class nextdest extends AppCompatActivity {
    private Spinner spindes;
    private static String TAG = MainActivity.class.getSimpleName();
    private String jsonResponse;
    private Button submit;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextdest);
        submit = (Button)findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"your file has gone to the next official", Toast.LENGTH_SHORT).show();
            }

        });

        String url= "https://plausible-alley.glitch.me/admins/getOfficers";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());


                try {
//                    JSONObject ResponseObject = new JSONObject(response);
                    //  Parsing json object response
                    // response will be a json object
                    //  JSONObject json_LL = response.getJSONObject("user");
//                    String id = response.getString("id");
//
//                    String email = response.getString("email");
//
                    String designation = response.getString("designation");
                    String name = response.getString("name");

                    count = response.length();
//

//                    jsonResponse = "";
//                    jsonResponse += "Name: " + name + "\n\n";
//                    jsonResponse += "Email: " + email + "\n\n";
//                    jsonResponse += "Home: " + home + "\n\n";
//                    jsonResponse += "Mobile: " + mobile + "\n\n";

//                    profile_name.setText(name);
//                    profile_designation.setText(designation);



                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                hidepDialog();
            }
        }){

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                //headers.put("Content-Type", "application/json");
                headers.put("token", token);
                return headers;
            }
        };


        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
        radio();
    }
    private void showpDialog() {
//        if (!pDialog.isShowing())
//            pDialog.show();
    }


    private void hidepDialog() {
//       if (pDialog.isShowing())
//            pDialog.dismiss();
    }



public void radio() {
    for (int row = 0; row < 1; row++) {
        RadioGroup ll = new RadioGroup(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        for (int i = 1; i <= count; i++) {
            RadioButton rdbtn = new RadioButton(this);
            rdbtn.setId((row * 2) + i);
            rdbtn.setText("Radio " + rdbtn.getId());
            ll.addView(rdbtn);
        }
        ((ViewGroup) findViewById(R.id.radiogroup)).addView(ll);
    }
}
    }

