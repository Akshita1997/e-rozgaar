package com.example.rkrmills.sih_rozgaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class signup extends AppCompatActivity {

    private Button LoginLink, nextStepButton;

    TextView _username, _designation, _department, _office, _email, _pswrd, _response;

//    android.support.v7.widget.AppCompatButton _sendRequest;
    Button signup;
    ProgressBar _proProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        _username = (TextView) findViewById(R.id.username_Sid);
        _designation =(TextView) findViewById(R.id.designation_Sid);
        _department = (TextView)findViewById(R.id.dpt_Sid);
        _office =(TextView)findViewById(R.id.office_Sid);
        _email = (TextView) findViewById(R.id.email_Sid);
        _pswrd =(TextView) findViewById(R.id.pswrd_Sid);
        _response = (TextView) findViewById(R.id.response);
        _proProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        signup = (Button) findViewById(R.id.sign_up_btn);

//        LoginLink = (Button) findViewById(R.id.login_link);
//        nextStepButton = (Button) findViewById(R.id.next_step_button);
//
//        LoginLink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(signup.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

        //hooking onclick listener of button
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(signup.this);
                //this is the url where you want to send the request
                //TODO: replace with your own url to send request, as I am using my own localhost for this tutorial
                String url = "https://plausible-alley.glitch.me/admins/register";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the response string.
                                try {
                                    JSONObject ResponseObject = new JSONObject(response);
                                    //JSONObject json_LL = ResponseObject.getJSONObject("success");
                                    String str_value=ResponseObject.getString("success");
                                    if(str_value.equals("true")) {
                                        Intent intent = new Intent(signup.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        _response.setText("This email is already registered");
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // _response.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        _response.setText("That didn't work!");
                    }
                }) {
                    //adding parameters to the request
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("username", _username.getText().toString());
                        params.put("designation", _designation.getText().toString());
                        params.put("department", _department.getText().toString());
                        params.put("office", _office.getText().toString());
                        params.put("email", _email.getText().toString());
                        params.put("password", _pswrd.getText().toString());


                        return params;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);


            }
        });

    }
}
