package com.bmicalculator;

import static java.lang.Math.round;

public class BMI {
    private Person person;
    private double value;

    public BMI(Person person) {
        this.person = person;
        this.value = Math.round(this.person.getWeight() / Math.pow((double) this.person.getHeight() / 100, 2)*100.0)/100.0;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String rateBmi() {
        String txt = "";

        while (txt.isEmpty()) {
            if (value >= 40) return txt = "obese class 3";   //otyłość skrajna
            if (value >= 35) return txt = "obese class 2";  //ii stopień otyłości
            if (value >= 30) return txt = "obese class 1";  //i stopień otyłości
            if (value >= 25) return txt = "overweight";     //nadwaga
            if (value >= 18.5) return txt = "normal"; //wartość prawidłowa
            if (value >= 17) return txt = "mild thinness";   //niedowaga
            if (value >= 16) return txt = "moderate thinness"; //wychudzenie
            if (value < 16) return txt = "severe thinness"; //wygłodzenie
        }
        return txt;
    }

}








