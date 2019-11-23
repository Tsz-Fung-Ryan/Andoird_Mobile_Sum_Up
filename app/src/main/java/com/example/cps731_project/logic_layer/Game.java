package com.example.cps731_project.logic_layer;

import java.util.Random;

public class Game {

    private final int AMOUNTOFNUMBERS = 5;
    private int maxNumber;
    private char [] modifiers;
    private int [] numbers = new int [AMOUNTOFNUMBERS];
    private Equation currentEquation;
    private int score=0;

    //test constructor
    public Game(){
        maxNumber=10;
        modifiers = new char [] {'+','-'};
    }

    //actual constructor for app
    public Game(int maxNumber, char[] modifiers){
        this.maxNumber=maxNumber;
        this.modifiers=modifiers;
    }

    //generates the numbers for the game
    public void generateNumbers(){
        Random rand = new Random();
        for(int number: numbers)
            number = rand.nextInt(maxNumber);
    }

    //getter for numbers
    public int[] getNumbers(){
        return numbers;
    }

    //getter for currentEquation
    public Equation getCurrentEquation(){
        return currentEquation;
    }

    //careates a round by initializing a new equation by generating a finite amount of numbers
    public void playGame(){
        generateNumbers();
        currentEquation = new Equation(numbers,modifiers);
    }

    //iterates the score meant to be used when the equation has been solved
    public void increaseScore() {
        score++;
    }

    //getter for score
    public int getScore(){
        return score;
    }
}
