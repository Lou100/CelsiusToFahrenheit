package com.example.celsiustofahrenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //Referencing the buttons and text views
    private Button fahrenButton;
    private TextView resultId;
    private EditText celsiusEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* finding the buttons and text views in activity_main.xml and programming and referencing them in
        MainActivity.java
         */

        fahrenButton = (Button) findViewById(R.id.fahrenButton);
        resultId = (TextView) findViewById(R.id.resultId);
        celsiusEditText = (EditText) findViewById(R.id.celsiusEditText);

        fahrenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Conversion formula from fahrenheit to celsius
                //(32°F − 32) × 5/9 = 0°C
                double addition = 32.00d;
                double fraction = 1.80d;
                int result = 0;

                ////If statement to prevent app from crashing if user enters no numbers(Degrees)

                if(fahrenButton.getText().toString().equals("")) {
                    /* If no number was entered a red error message
                    will display indicating no number was entered
                     */
                    resultId.setText(R.string.error_message);
                    resultId.setTextColor(Color.RED);
                }else{
                    // Else if a number was entered the inches conversion result will display in dark grey
                    double celsiusValue = Double.parseDouble(celsiusEditText.getText().toString());
                    result = (int) ((celsiusValue*fraction)+(addition));
                    resultId.setText(String.format(String.valueOf(result))+ " Degrees");

                }






            }
        });
    }
}
