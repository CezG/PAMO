package com.bmicalculator.ui.bmi;

import com.bmicalculator.Person;

public class BMI {
    private Person person;
    private double value;
    private int level = 0;

    public BMI(Person person) {
        this.person = person;

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double calculate() {
        return value = Math.round(this.person.getWeight() / Math.pow((double) this.person.getHeight() / 100, 2) * 100.0) / 100.0;
    }

    public String rateBmi() {
        calculate();
        String txt = "";

        while (txt.isEmpty()) {
            if (value >= 40) {level = 7; return txt = "obese class 3";}   //otyłość skrajna
            if (value >= 35) {level = 6; return txt = "obese class 2";}  //ii stopień otyłości
            if (value >= 30) {level = 5 ;return txt = "obese class 1";}  //i stopień otyłości
            if (value >= 25) {level = 4; return txt = "overweight"; }    //nadwaga
            if (value >= 18.5) {level = 3; return txt = "normal"; }//wartość prawidłowa
            if (value >= 17) {level = 2; return txt = "mild thinness";}   //niedowaga
            if (value >= 16) {level = 1; return txt = "moderate thinness";} //wychudzenie
            if (value < 16) {level = 0; return txt = "severe thinness" ;} //wygłodzenie
        }
        return txt;

    }



}








