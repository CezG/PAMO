package com.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Switch switchSex ;
    private TextView tvSex;
    private EditText personWeight;
    private EditText personHeight;
    private TextView tvBMI;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchSex = findViewById(R.id.switchSex);
        tvSex = findViewById(R.id.textViewSex);
        personWeight = findViewById(R.id.personWeight);
        personHeight = findViewById(R.id.personHeight);
        tvBMI = findViewById(R.id.textViewBMI);
        btnCheck = findViewById(R.id.buttonCheck);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int weight = Integer.parseInt(String.valueOf(personWeight.getText()));
                int height = Integer.parseInt(String.valueOf(personHeight.getText()));
                BMI bmi = new BMI(new Person(weight,height));

                tvBMI.setText( "Your BMI value is = "+ bmi.getValue() + " and weight is "  +bmi.rateBmi().toUpperCase());
            }
        }

        );

    }


}