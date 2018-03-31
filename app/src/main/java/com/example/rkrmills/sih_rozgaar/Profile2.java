package com.example.rkrmills.sih_rozgaar;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
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


import static com.example.rkrmills.sih_rozgaar.MainActivity.*;

public class Profile2 extends AppCompatActivity {

    private TextView profile_designation, profile_name, profile_email,profile_dept;
    private static String TAG = MainActivity.class.getSimpleName();
    private String jsonResponse;
    // Progress dial
    private TextView txtResponse;

    // temporary string to show the parsed response

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);


        profile_designation = (TextView) findViewById(R.id.designation);
        profile_name = (TextView) findViewById(R.id.name);
        profile_email = (TextView) findViewById(R.id.profile_email);
        profile_dept = (TextView) findViewById(R.id.department);
        profile_email.setText(email1);
        profile_designation.setText(designation);
        profile_name.setText(name1);
        profile_dept.setText(department);
//        String url= "https://plausible-alley.glitch.me/admins/profile";
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                Log.d(TAG, response.toString());
//
//
//                try {
//                    //  Parsing json object response
//                    // response will be a json object
//                  //  JSONObject json_LL = response.getJSONObject("user");
//                    String id = response.getString("id");
//
//                    String email = response.getString("email");
////
//                    String designation = response.getString("designation");
//                    String name = response.getString("name");
////
//
////                    jsonResponse = "";
////                    jsonResponse += "Name: " + name + "\n\n";
////                    jsonResponse += "Email: " + email + "\n\n";
////                    jsonResponse += "Home: " + home + "\n\n";
////                    jsonResponse += "Mobile: " + mobile + "\n\n";
//
////                    profile_name.setText(name);
////                    profile_designation.setText(designation);
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Toast.makeText(getApplicationContext(),
//                            "Error: " + e.getMessage(),
//                            Toast.LENGTH_LONG).show();
//                }
//                hidepDialog();
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(),
//                        error.getMessage(), Toast.LENGTH_SHORT).show();
//                // hide the progress dialog
//                hidepDialog();
//            }
//        }){
//
//            /**
//             * Passing some request headers
//             */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
//                //headers.put("Content-Type", "application/json");
//                headers.put("token", token);
//                return headers;
//            }
//        };
//
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq);
//    }
//    private void showpDialog() {
////        if (!pDialog.isShowing())
////            pDialog.show();
//    }
//
//
//    private void hidepDialog() {
////       if (pDialog.isShowing())
////            pDialog.dismiss();
//    }
    }
}


