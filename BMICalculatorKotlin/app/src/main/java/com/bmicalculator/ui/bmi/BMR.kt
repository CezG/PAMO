package com.bmicalculator.ui.bmi

import com.bmicalculator.Person

class BMR(private val person: Person) {
    var value = 0.0
    fun calculate(): Int {
        val age = person.age
        val weight = person.weight
        val height = person.height
        value = if (person.isFemale) {
            655.1 + 9.567 * weight + 1.85 * height - 4.68 * age
        } else {
            66.47 + 13.7 * weight + 5.0 * height - 6.76 * age
        }
        return value.toInt()
    }
}