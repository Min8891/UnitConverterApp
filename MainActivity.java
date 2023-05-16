package com.example.unitconverter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = " ";
    String result = "N/A";
    int calc = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* Called when the user taps the Calculate button */
    public void buttonOnClick(View v){
        // Do something in response to button

        TextView n = (TextView) findViewById(R.id.number); //get the number's text view

        //TextView resultText = (TextView) findViewById(R.id.textResult); //get the result text view

        //get the numbers in form of strings
        String value=n.getText().toString();
            //convert strings to integers, for calculation
            double a = Double.parseDouble(value);
            double r = 0;
            // Do something in response to radio button clicks
            RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup2);

            // which button is now checked?
            int selectedId = rg.getCheckedRadioButtonId();
            calc = 0;
            if (selectedId == R.id.radioButton1) {
                calc = 1; // kg to lbs
            } else if (selectedId == R.id.radioButton2) {
                calc = 2; // lbs to Kg
            } else if (selectedId == R.id.radioButton3) {
                calc = 3; // Miles to Km
            } else if (selectedId == R.id.radioButton4) {
                calc = 4;  // Km to Miles
            }
        if((value.isEmpty() == false) && (calc != 0)) {
            switch (calc) {
                //case 0:
                    //result = "Please return and select a conversion";
                   // break;
                case 1: // kg to lbs
                    r = a * 2.20462;
                    result = a + " kg = " + r + "lbs";
                    break;
                case 2: // lbs to Kg
                    r = a * 0.453592;
                    result = a + " lbs = " + r + "Kg";
                    break;
                case 3: // Miles to Km
                    r = a * 1.60934;
                    result = a + " Miles = " + r + "Km";
                    break;
                case 4: // Km to Miles
                    r = a * 0.621371;
                    result = a + " Km = " + r + "Miles";
                    break;

            }
        }
        else if(calc == 0)
            result = "You did not select a conversion!";
        else
            result = "you did not enter a number";
        Intent i = new Intent(getApplicationContext(),ResultActivity.class);
        i.putExtra(EXTRA_MESSAGE, result);
        startActivity(i);
    }





}



