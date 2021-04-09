package com.bmicalculator.ui.notifications;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bmicalculator.Person;
import com.bmicalculator.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    private EditText personWeight;
    private EditText personHeight;
    private TextView tvBMI;
    private Button btnCheck;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        personWeight = root.findViewById(R.id.personWeight);
        personHeight = root.findViewById(R.id.personHeight);
        tvBMI = root.findViewById(R.id.textViewBMI);
        btnCheck = root.findViewById(R.id.buttonCheck);

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);


                btnCheck.setOnClickListener(new View.OnClickListener() {
                                                public void onClick(View v) {
                                                    if (TextUtils.isEmpty(personWeight.getText()) || TextUtils.isEmpty(personHeight.getText())) {
//                                                        tvBMI.setText("The weight and height is required");
                                                        tvBMI.setError("The weight and height is required");
                                                    } else {
                                                        int weight = Integer.parseInt(String.valueOf(personWeight.getText()));
                                                        int height = Integer.parseInt(String.valueOf(personHeight.getText()));
                                                        BMI bmi = new BMI(new Person(weight, height));
                                                        tvBMI.setError(null);
                                                        tvBMI.setText("Your BMI value is = " + bmi.getValue() + " and weight is " + bmi.rateBmi().toUpperCase());
                                                    }
                                                }
                                            }

                );

            }
        });
        return root;
    }
}