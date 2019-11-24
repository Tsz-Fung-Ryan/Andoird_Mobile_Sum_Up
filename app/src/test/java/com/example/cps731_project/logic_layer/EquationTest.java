package com.example.cps731_project.logic_layer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

// Unit Test Cases for Equation functions
public class EquationTest {

    private final int AMOUNTOFNUMBERS = 5;

    // Sample equation for 1st Equation constructor
    private Equation equ = new Equation(new int[]{1, 2, 3, 4, 5});

    // Sample equation for 2nd Equation constructor
    private Equation eqs = new Equation(new int[]{1, 2, 3, 4, 5}, new char[]{'+', '-', 'x', '^'});


    @Test
    // Outputs the numbers for next question
    // Test to see if numbers outputted for questions are positive
    public void getNumbers() {

        for (int i = 0; i < equ.getNumbers().length; i++) {
            assertTrue(equ.getNumbers()[i] >= 0);
        }
        assertTrue(equ.getNumbers().length == AMOUNTOFNUMBERS);
        for (int i : equ.getNumbers()) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        for (int i = 0; i < eqs.getNumbers().length; i++) {
            assertTrue(eqs.getNumbers()[i] >= 0);
        }
        assertTrue(eqs.getNumbers().length == AMOUNTOFNUMBERS);
        for (int i : eqs.getNumbers()) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    @Test
    // Outputs the modifiers used for the next question
    public void getModifiers() {
        System.out.println(equ.getModifiers());
        System.out.println(eqs.getModifiers());
    }

    @Test
    // Ensuring the randomly generated answer is positive
    public void generateAnswer() {
        assertTrue(equ.getAnswer() >= 0);
        assertTrue(eqs.getAnswer() >= 0);
    }

    @Test
    // Outputting a randomly generated answer from the 5 randomly generated numbers
    // Outputting the sequence of numbers and modifiers used to get to answer
    public void getAnswer() {
        System.out.println(equ.getAnswer());
        System.out.println(equ.getEquationAnswer());
        System.out.println(eqs.getAnswer());
        System.out.println(eqs.getEquationAnswer());
    }

    @Test
    // Ensuring all calculation methods are correct
    public void calculate() {
        int a = 6;
        int b = 2;

        assertEquals(8, equ.calculate(a, '+', b));
        assertEquals(4, equ.calculate(a, '-', b));
        assertEquals(12, equ.calculate(a, 'x', b));
        //assertEquals(8, eq.calculate(a, '/', b));
        assertEquals(36, equ.calculate(a, '^', b));
    }

    @Test
    // Ensuring the solution based on given parameters is calculated correctly
    public void partialSolution() {
        assertEquals(5, equ.partialSolution(new int[]{1,2,3}, new char [] {'x','+'}));
        assertEquals(2, equ.partialSolution(new int[]{1,2}, new char [] {'x'}));
        assertEquals(8, equ.partialSolution(new int[]{1,2,3,4}, new char [] {'^','+','+'}));
        assertEquals(1, equ.partialSolution(new int[]{1}, new char [] {}));
    }

}