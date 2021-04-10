package com.bmicalculator.ui.bmi;

import com.bmicalculator.Person;

public class BMR {
    private Person person;
    private double value;


    public BMR(Person person) {
        this.person = person;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int calculate() {
        int age = person.getAge();
        int weight = person.getWeight();
        int height = person.getHeight();
        if (person.isFemale()) {
            value = (655.1 + 9.567 * weight + 1.85 * height - 4.68 * age);
        } else {
            value = (66.47 + 13.7 * weight + 5.0 * height - 6.76 * age);
        }

        return (int) value;
    }


}








