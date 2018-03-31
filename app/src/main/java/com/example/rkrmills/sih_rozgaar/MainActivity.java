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

public class MainActivity extends AppCompatActivity {

    private Button SignUpLink, SignInBtn;
    private TextView email, password, _response;
    ProgressBar _proProgressBar;
    public static String token,user_id,email1,designation,name1,department;
            public String official_id,name,jsonemail,jsondesignation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignUpLink = (Button) findViewById(R.id.sign_up_link);

        SignInBtn = (Button) findViewById(R.id.sign_in_button);
        email = (TextView) findViewById(R.id.email_Lid);
        password =(TextView) findViewById(R.id.password_Lid);

        _response = (TextView) findViewById(R.id.response);
        _proProgressBar = (ProgressBar) findViewById(R.id.progressBar);

        SignUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, signup.class);
                startActivity(intent);
            }
        });

        SignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                //this is the url where you want to send the request

                String url = "https://plausible-alley.glitch.me/admins/authenticate";

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

                                    String str_value=ResponseObject.getString("success");
                                    user_id = ResponseObject.getString("user_id");
                                    designation = ResponseObject.getString("designation");
                                    email1=ResponseObject.getString("email");
                                    token = ResponseObject.getString("token");
                                    name1 = ResponseObject.getString("name");
                                    department  =ResponseObject.getString("department");

                                    if(str_value.equals("true")) {
                                        Intent intent = new Intent(MainActivity.this, bottom_nav.class);
                                        startActivity(intent);
                                    }
                                    else{
                                        _response.setText("Incorrect email or password");
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                // _response.setText(response);
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
                        params.put("email", email.getText().toString());
                        params.put("password", password.getText().toString());


                        return params;
                    }
                };
                // Add the request to the RequestQueue.
                queue.add(stringRequest);


            }
        });

    }
}
