package com.example.rkrmills.sih_rozgaar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class nextHoldOn extends AppCompatActivity {

    CheckBox check1, check2, check3;
    private EditText comment;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_hold_on);
        comment = (EditText) findViewById(R.id.comment);
        addListenerOnButtonClick();
    }

    public void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check3 = (CheckBox) findViewById(R.id.checkBox3);
        submit = (Button) findViewById(R.id.button1);

        //Applying the Listener on the Button click
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");
                if (check1.isChecked()) {
//                    result.append("\nPizza 100Rs");
//                    totalamount += 100;
                }
                if (check2.isChecked()) {
//                    result.append("\nCoffe 50Rs");
//                    totalamount += 50;
                }
                if (check3.isChecked()) {
//                    result.append("\nBurger 120Rs");
//                    totalamount += 120;
                }
                //result.append("\nTotal: " + totalamount + "Rs");
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }
}