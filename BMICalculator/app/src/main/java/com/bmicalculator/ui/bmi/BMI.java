package com.bmicalculator.ui.bmi;

import com.bmicalculator.Person;

public class BMI {
    private Person person;
    private double value;
    private int levelObesity = 0;

    public BMI(Person person) {
        this.person = person;

    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getLevelObesity() {
        return levelObesity;
    }

    public void setLevelObesity(int level) {
        this.levelObesity = level;
    }

    public double calculate() {
        return value = Math.round(this.person.getWeight() / Math.pow((double) this.person.getHeight() / 100, 2) * 100.0) / 100.0;
    }

    public String rateBmi() {
        calculate();
        String txt = "";

        while (txt.isEmpty()) {
            if (value >= 40) {levelObesity = 7; return txt = "obese class 3";}   //otyłość skrajna
            if (value >= 35) {levelObesity = 6; return txt = "obese class 2";}  //ii stopień otyłości
            if (value >= 30) {levelObesity = 5 ;return txt = "obese class 1";}  //i stopień otyłości
            if (value >= 25) {levelObesity = 4; return txt = "overweight"; }    //nadwaga
            if (value >= 18.5) {levelObesity = 3; return txt = "normal"; }//wartość prawidłowa
            if (value >= 17) {levelObesity = 2; return txt = "mild thinness";}   //niedowaga
            if (value >= 16) {levelObesity = 1; return txt = "moderate thinness";} //wychudzenie
            if (value < 16) {levelObesity = 0; return txt = "severe thinness" ;} //wygłodzenie
        }
        return txt;

    }



}








