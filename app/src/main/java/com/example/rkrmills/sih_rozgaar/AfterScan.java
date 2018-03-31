package com.example.rkrmills.sih_rozgaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.data;
import static com.example.rkrmills.sih_rozgaar.MainActivity.token;

public class AfterScan extends AppCompatActivity {

    private IntentIntegrator qrScan;

    private Button button2;
    Button approve, hold;
    private TextView application_id, user_id;
    public static String user_id1, application_id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_scan);

        qrScan = new IntentIntegrator(this);

        button2 = (Button) findViewById(R.id.button2);
        application_id = (TextView) findViewById(R.id.application_id2);
        approve = (Button) findViewById(R.id.approved);
        hold = (Button) findViewById(R.id.hold_on);
        user_id = (TextView) findViewById(R.id.user_id2);
        approve.setVisibility(View.GONE);
        hold.setVisibility(View.GONE);
        qrScan.initiateScan();


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(AfterScan.this);
                //this is the url where you want to send the request
                approve.setVisibility(View.VISIBLE);
                hold.setVisibility(View.VISIBLE);
                String url = "https://plausible-alley.glitch.me/admins/addFiles";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the response string.

                                // Display the response string.
                                try {
                                    JSONObject ResponseObject = new JSONObject(response);
//

//                             user_id1=ResponseObject.getString("UserID");
//                             application_id1 = ResponseObject.getString("ApplicationID");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // _response.setText(response);
                                // _response.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                _response.setText("That didn't work!");
                    }
                }) {
                    //adding parameters to the request
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("user_id", user_id1);
                        params.put("app_id", application_id1);


                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        //headers.put("Content-Type", "application/json");
                        headers.put("Authorization", token);
                        return headers;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                //approve.setVisibility(View.GONE);
                //hold.setVisibility(View.GONE);
            }

        });

        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(AfterScan.this);
                //this is the url where you want to send the request

                String url = "https://plausible-alley.glitch.me/admins/updateStatus";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the response string.

                                // Display the response string.
                                try {
                                    JSONObject ResponseObject = new JSONObject(response);
//

//                             user_id1=ResponseObject.getString("UserID");
//                             application_id1 = ResponseObject.getString("ApplicationID");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // _response.setText(response);
                                // _response.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                _response.setText("That didn't work!");
                    }
                }) {
                    //adding parameters to the request
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        //params.put("user_id", user_id1);
                        params.put("id", application_id1);
                        params.put("status", "approved");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        //headers.put("Content-Type", "application/json");
                        headers.put("Authorization", token);
                        return headers;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);
                Intent intent = new Intent(AfterScan.this, nextdest.class);
                startActivity(intent);

            }

        });
//
        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(AfterScan.this);
                //this is the url where you want to send the request

                String url = "https://plausible-alley.glitch.me/admins/updateStatus";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the response string.

                                // Display the response string.
                                try {
                                    JSONObject ResponseObject = new JSONObject(response);
//

//                             user_id1=ResponseObject.getString("UserID");
//                             application_id1 = ResponseObject.getString("ApplicationID");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // _response.setText(response);
                                // _response.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                _response.setText("That didn't work!");
                    }
                }) {
                    //adding parameters to the request
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        //params.put("user_id", user_id1);
                        params.put("id", application_id1);
                        params.put("status", "onhold");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        //headers.put("Content-Type", "application/json");
                        headers.put("Authorization", token);
                        return headers;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);

                Intent intent = new Intent(AfterScan.this, nextHoldOn.class);
                startActivity(intent);


            }

        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    application_id1 = obj.getString("application_id");
                    application_id.setText(application_id1);
//                    user_id1 = obj.getString("user_id1");
//                    user_id.setText(user_id1);


                } catch (JSONException e) {
                    e.printStackTrace();
                    //if control comes here
                    //that means the encoded format not matches
                    //in this case you can display whatever data is available on the qrcode
                    //to a toast
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }



}

