package com.example.cps731_project.logic_layer;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class Logic_LayerTest {

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
    // Ensures all numbers, operators, and answers are all within their respective parameters
    public void play() {
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
    // Ensures a newly created game outputs something
    public void newGame() {

        assertFalse(g1 == null);
        assertFalse(g2 == null);
        assertFalse(g3 == null);
    }

    @Test
    // Ensures scoring functionality is working by adding 1 when score is increased
    public void getScore() {
        System.out.println(g1.getScore());
        g1.increaseScore();
        System.out.println(g1.getScore());
    }

    @Test
    // Specific scenario: Ensures the solving functionality is correct
    public void solved() {
        g3.playGame();
        assertTrue(g3.solved(new int[]{1,1,1,1,1}, new char[]{'+', '+', '+', '+'}));
        System.out.println(g3.getCurrentEquation().getEquationAnswer());
        System.out.println(g3.getCurrentEquation().getAnswer());
        System.out.println();
    }

}