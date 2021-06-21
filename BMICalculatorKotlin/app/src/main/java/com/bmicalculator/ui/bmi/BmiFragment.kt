package com.bmicalculator.ui.bmi

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bmicalculator.Person
import com.bmicalculator.R

class BmiFragment : Fragment() {
    private var bmiViewModel: BmiViewModel? = null
    private var switchSex: SwitchCompat? = null
    private var tvSex: TextView? = null
    private var personAge: EditText? = null
    private var personWeight: EditText? = null
    private var personHeight: EditText? = null
    private var tvBmi: TextView? = null
    private var tvBmr // basal metabolic rate
            : TextView? = null
    private var btnCheck: Button? = null
    private var imgView: ImageView? = null
    private val images = intArrayOf(R.drawable.food_0, R.drawable.food_1, R.drawable.food_2, R.drawable.food_3,
            R.drawable.food_4, R.drawable.food_5, R.drawable.food_6, R.drawable.food_7)

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bmiViewModel = ViewModelProvider(this).get(BmiViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_bmi, container, false)
        tvBmr = root.findViewById(R.id.text_bmr)
        switchSex = root.findViewById(R.id.switchSex)
        tvSex = root.findViewById(R.id.textViewSex)
        personAge = root.findViewById(R.id.personAge)
        personWeight = root.findViewById(R.id.personWeight)
        personHeight = root.findViewById(R.id.personHeight)
        tvBmi = root.findViewById(R.id.textViewBMI)
        btnCheck = root.findViewById(R.id.buttonCheck)
        imgView = root.findViewById(R.id.imgFood)
        bmiViewModel!!.text.observe(viewLifecycleOwner, object : Observer<String?> {
            private var isFemale = false
            override fun onChanged(s: String?) {
//                final boolean isFemale;
                switchSex?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        isFemale = true
                        tvSex?.setText("Female")
                    } else {
                        isFemale = false
                        tvSex?.setText("Male")
                    }
                })
                btnCheck?.setOnClickListener(View.OnClickListener {
                    if (TextUtils.isEmpty(personAge?.getText())) {
                        personAge?.setError("The age is required")
                    } else if (TextUtils.isEmpty(personWeight?.getText())) {
                        personWeight?.setError("The weight is required")
                    } else if (TextUtils.isEmpty(personHeight?.getText())) {
                        personHeight?.setError("The height is required")
                    } else {
                        val age = personAge?.getText().toString().toInt()
                        val weight = personWeight?.getText().toString().toInt()
                        val height = personHeight?.getText().toString().toInt()
                        val person = Person(isFemale, age, weight, height)
                        val bmi = BMI(person)
                        val bmr = BMR(person)
                        tvBmi?.setError(null)
                        tvBmi?.setText("Your BMI value is = " + bmi.calculate() + " and weight is " + bmi.rateBmi().toUpperCase())
                        tvBmr?.setText("Your BMR value is = " + bmr.calculate() + " kcal")
                        val obesity = bmi.levelObesity
                        imgView?.setImageResource(images[obesity])
                        imgView?.setVisibility(View.VISIBLE)


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
                )
            }
        })
        return root
    }
}