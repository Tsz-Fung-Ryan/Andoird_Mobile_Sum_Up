package com.example.cps731_project;

public class Equations {

    final int AMOUNTOFNUMBERS = 5;
    int [] numbers = new int [AMOUNTOFNUMBERS];
    char [] modifiers;

    public Equations(int [] numbers){
        this.numbers = numbers;
        modifiers = new char [] {'+','-'};
    }

    public Equations (int [] numbers, char [] modifiers){
        this.numbers = numbers;
        this.modifiers = modifiers;
    }
}
