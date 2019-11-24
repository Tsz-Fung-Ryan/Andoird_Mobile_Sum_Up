package com.example.cps731_project.logic_layer;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GameTest {

    // Max amount of numbers per question
    private final int AMOUNTOFNUMBERS = 5;
    // Random object used
    Random rand = new Random();

    // Game 1 replicates Test Constructor
    Game g1 = new Game();
    // Game 2 replicates App Constructor (bound of 25)
    Game g2 = new Game(rand.nextInt(25), new char[]{'+','-','x'});
    // Game 3 replicates Specific case for "solved" function
    Game g3 = new Game(1, new char[]{'+'});

    @Test
    // Ensuring every number is positive
    public void generateNumbers() {

        g1.playGame();
        for(int i : g1.getNumbers()){
            assertTrue(i >= 0);
        }

        g2.playGame();
        for(int i : g2.getNumbers()) {
            assertTrue(i >= 0);
        }
    }

    @Test
    // Making sure numbers are generated are within threshold of its parameters
    public void getNumbers() {

        g1.generateNumbers();
        assertTrue(g1.getNumbers().length == AMOUNTOFNUMBERS);
        for(int i : g1.getNumbers()){
            System.out.printf("%d ", i);
        }
        System.out.println();

        g2.generateNumbers();
        assertTrue(g2.getNumbers().length == AMOUNTOFNUMBERS);
        for(int i : g2.getNumbers()){
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println();
    }

    @Test
    // Outputs the numbers generated, the modifiers used, the answer, and the equation to answer
    public void getCurrentEquation() {

        g1.playGame();
        for (int i : g1.getCurrentEquation().getNumbers()) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println(g1.getCurrentEquation().getModifiers());
        System.out.println(g1.getCurrentEquation().getAnswer());
        System.out.println(g1.getCurrentEquation().getEquationAnswer());
        System.out.println();

        g2.playGame();
        for (int i : g2.getCurrentEquation().getNumbers()) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println(g2.getCurrentEquation().getModifiers());
        System.out.println(g2.getCurrentEquation().getAnswer());
        System.out.println(g2.getCurrentEquation().getEquationAnswer());
        System.out.println();
    }


    @Test
    // Ensuring scoring increments by 1 every time answer is correct
    public void getScore() {

        System.out.println(g1.getScore());
        g1.increaseScore();
        System.out.println(g1.getScore());
    }

    @Test
    // Ensuring scoring functionality is correct
    public void solved() {
        g3.playGame();
        assertTrue(g3.solved(new int[]{1,1,1,1,1}, new char[]{'+', '+', '+', '+'}));
        System.out.println(g3.getCurrentEquation().getEquationAnswer());
        System.out.println(g3.getCurrentEquation().getAnswer());
        System.out.println();
    }
}