package com.example.rkrmills.sih_rozgaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

import android.app.AlertDialog;
import android.widget.TextView;


public class profile extends AppCompatActivity {

    private TextView editProfile;
    private TextView position_name, profile_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editProfile = (TextView)findViewById(R.id.editProfile);
        position_name = (TextView) findViewById(R.id.designation);
        profile_name = (TextView) findViewById(R.id.profile_name);

        position_name.setText(getIntent().getStringExtra("arg"));

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile.this, editProfile.class);
                startActivity(intent);
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.action_scan:
                        break;

                }
                return true;
            }

        });
    }
}
