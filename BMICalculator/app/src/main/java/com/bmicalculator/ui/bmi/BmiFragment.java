package com.bmicalculator.ui.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bmicalculator.Person;
import com.bmicalculator.R;
import com.bmicalculator.ui.food.FoodFragment;

public class BmiFragment extends Fragment {

    private BmiViewModel bmiViewModel;

    private Switch switchSex;
    private TextView tvSex;
    private EditText personAge;
    private EditText personWeight;
    private EditText personHeight;
    private TextView tvBmi;
    private TextView tvBmr;   // basal metabolic rate
    private Button btnCheck;
    private ImageView imgView;

    private int[] images = {R.drawable.food_0, R.drawable.food_1, R.drawable.food_2, R.drawable.food_3,
            R.drawable.food_4, R.drawable.food_5, R.drawable.food_6, R.drawable.food_7};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        bmiViewModel =
                new ViewModelProvider(this).get(BmiViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bmi, container, false);
        tvBmr = root.findViewById(R.id.text_bmr);
        switchSex = root.findViewById(R.id.switchSex);
        tvSex = root.findViewById(R.id.textViewSex);
        personAge = root.findViewById(R.id.personAge);
        personWeight = root.findViewById(R.id.personWeight);
        personHeight = root.findViewById(R.id.personHeight);
        tvBmi = root.findViewById(R.id.textViewBMI);
        btnCheck = root.findViewById(R.id.buttonCheck);
        imgView = root.findViewById((R.id.imgFood));

        bmiViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            private boolean isFemale;

            @Override
            public void onChanged(@Nullable String s) {
//                final boolean isFemale;
                switchSex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            isFemale = true;
                            tvSex.setText("Female");
                        } else {
                            isFemale = false;
                            tvSex.setText("Male");
                        }
                        ;
                    }
                });


                btnCheck.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) {
                                                    if (TextUtils.isEmpty(personAge.getText())) {
                                                        personAge.setError("The age is required");
                                                    } else if (TextUtils.isEmpty(personWeight.getText())) {
                                                        personWeight.setError("The weight is required");
                                                    } else if (TextUtils.isEmpty(personHeight.getText())) {
                                                        personHeight.setError("The height is required");
                                                    } else {
                                                        int age = Integer.parseInt(String.valueOf(personAge.getText()));
                                                        int weight = Integer.parseInt(String.valueOf(personWeight.getText()));
                                                        int height = Integer.parseInt(String.valueOf(personHeight.getText()));
                                                        Person person = new Person(isFemale, age, weight, height);
                                                        BMI bmi = new BMI(person);
                                                        BMR bmr = new BMR(person);

                                                        tvBmi.setError(null);
                                                        tvBmi.setText("Your BMI value is = " + bmi.calculate() + " and weight is " + bmi.rateBmi().toUpperCase());
                                                        tvBmr.setText("Your BMR value is = " + bmr.calculate() + " kcal");
                                                        int obesity = bmi.getLevelObesity();
                                                        imgView.setImageResource(images[obesity]);
                                                        imgView.setVisibility(View.VISIBLE);


                                                        //Below are function to pass object but it wasnt working
//                                                        Bundle bundle = new Bundle();
//                                                        bundle.putInt("Obesity",bmi.getLevelObesity());
//                                                        FoodFragment fragment = new FoodFragment();
//                                                        fragment.setArguments(bundle);
//
//                                                        FragmentManager fragmentManager = getFragmentManager();
//                                                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                                                    }
                                                }
                                            }

                );


            }
        });
        return root;
    }
}