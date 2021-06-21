package com.bmicalculator.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bmicalculator.R

class QuizFragment : Fragment() {
    private var mViewModel: QuizViewModel? = null
    private var questionNo = 0
    private val questions = arrayOf(
            "How did COVID 19 infect the first human? \n\n A) some Chinese ate a bat \n\n B) got out of a virus laboratory located in the city where the infection was detected \n\n C) aliens implanted it with a special probe",
            "Where Covid19 was separated? \n\n A) in China \n\n B) in Pakistan \n\n C) in the USA",
            "Which country is in the top three for coronavirus spread and deaths? \n\n A) Russia \n\n B) Italy \n\n C) Poland",
            "According to the latest Irish research, what fraction of Covid 19 infections has occurred outside? \n\n A) 1/10 \n\n B) 1/1000 \n\n C) 1/10000",
            "According to the WHO, how long does immunity to Covid 19 persist after vaccination? \n\n A) for one year \n\n B) it is unknown \n\n C) about half a year",
            "According to annual CDC research, wearing masks for 100 days reduces the spread of covid 19 virus? \n\n A) does not reduces spread \n\n B) reduces spread by about 20% \n\n C) reduces spread by about 1%"
    )
    private val rightAnswers = arrayOf(1, 2, 3, 3, 2, 3)
    fun showToast(answer: Int, textView: TextView) {
        val toastGood = Toast.makeText(requireActivity().applicationContext, "Good !!", Toast.LENGTH_SHORT)
        val toastWrong = Toast.makeText(requireActivity().applicationContext, "WRONG !!", Toast.LENGTH_SHORT)
        toastGood.setMargin(130f, 130f)
        toastWrong.setMargin(130f, 130f)
        if (questionNo > 4) {
            textView.text = "You WIN !!!"
        } else {
            if (answer === rightAnswers[questionNo]) {
                toastGood.show()
                questionNo = questionNo + 1
                textView.text = questions[questionNo]
            } else {
                toastWrong.show()
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_quiz, container, false)
        val buttonA = root.findViewById<Button>(R.id.buttonA)
        val buttonB = root.findViewById<Button>(R.id.buttonB)
        val buttonC = root.findViewById<Button>(R.id.buttonC)
        val questionsText = root.findViewById<TextView>(R.id.quizQuestions)
        buttonA.setOnClickListener { showToast(1, questionsText) }
        buttonB.setOnClickListener { showToast(2, questionsText) }
        buttonC.setOnClickListener { showToast(3, questionsText) }
        return root
    }
}