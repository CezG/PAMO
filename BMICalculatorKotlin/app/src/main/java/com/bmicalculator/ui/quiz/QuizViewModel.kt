package com.bmicalculator.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private val mText: MutableLiveData<String>
    val text: LiveData<String>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is notifications fragment"
    }
}