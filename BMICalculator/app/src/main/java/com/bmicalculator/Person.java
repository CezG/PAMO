package com.bmicalculator;


public class Person {
    private boolean isFemale;
    private int age;
    private int weight;
    private int height;


    public Person(boolean isFemale, int age, int weight, int height) {
        this.isFemale = isFemale;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}
