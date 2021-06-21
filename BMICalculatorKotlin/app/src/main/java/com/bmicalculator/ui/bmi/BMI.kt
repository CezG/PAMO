package com.bmicalculator.ui.bmi

import com.bmicalculator.Person

class BMI(private val person: Person) {
    var value = 0.0
    var levelObesity = 0
    fun calculate(): Double {
        return Math.round(person.weight / Math.pow(person.height.toDouble() / 100, 2.0) * 100.0) / 100.0.also { value = it }
    }

    fun rateBmi(): String {
        calculate()
        var txt = ""
        while (txt.isEmpty()) {
            if (value >= 40) {
                levelObesity = 7
                return "obese class 3".also { txt = it }
            } //otyłość skrajna
            if (value >= 35) {
                levelObesity = 6
                return "obese class 2".also { txt = it }
            } //ii stopień otyłości
            if (value >= 30) {
                levelObesity = 5
                return "obese class 1".also { txt = it }
            } //i stopień otyłości
            if (value >= 25) {
                levelObesity = 4
                return "overweight".also { txt = it }
            } //nadwaga
            if (value >= 18.5) {
                levelObesity = 3
                return "normal".also { txt = it }
            } //wartość prawidłowa
            if (value >= 17) {
                levelObesity = 2
                return "mild thinness".also { txt = it }
            } //niedowaga
            if (value >= 16) {
                levelObesity = 1
                return "moderate thinness".also { txt = it }
            } //wychudzenie
            if (value < 16) {
                levelObesity = 0
                return "severe thinness".also { txt = it }
            } //wygłodzenie
        }
        return txt
    }
}