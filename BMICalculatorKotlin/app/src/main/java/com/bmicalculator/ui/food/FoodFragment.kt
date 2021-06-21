package com.bmicalculator.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bmicalculator.R

class FoodFragment : Fragment() {
    private var foodViewModel: FoodViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_food, container, false)
        val textView = root.findViewById<TextView>(R.id.text_food)
        foodViewModel!!.text.observe(viewLifecycleOwner, { s -> textView.text = s })
        return root
    }
}