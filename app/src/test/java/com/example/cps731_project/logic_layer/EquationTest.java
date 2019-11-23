package com.example.cps731_project.logic_layer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;


public class EquationTest {

    private Random rand = new Random(10);
    int[] num = new int[5];
    char[] s = new char[4];
    Equation equ = new Equation(new int[]{1, 2, 3, 4, 5});
    Equation eqs = new Equation(new int[]{1, 2, 3, 4, 5}, new char[]{'+', '-', 'x', '^'});

    @Test
    public void setNumbers() {
    }

    @Test
    public void getNumbers() {

        System.out.println(equ.getNumbers());
        System.out.println(eqs.getNumbers());

        assertEquals(5, num.length);

        for (int i = 0; i<num.length; i++) {
            assertTrue(equ.getNumbers()[i] >= 0);
            assertTrue(eqs.getNumbers()[i] >= 0);
        }
    }

    @Test
    public void setModifiers() {
    }

    @Test
    public void getModifiers() {
        System.out.println(equ.getModifiers());
        System.out.println(eqs.getModifiers());
    }

    @Test
    public void generateAnswer() {
        assertTrue(equ.getAnswer() >= 0);
        assertTrue(eqs.getAnswer() >= 0);
    }

    @Test
    public void getAnswer() {
        System.out.println(equ.getAnswer());
        System.out.println(equ.getEquationAnswer());
        System.out.println(eqs.getAnswer());
        System.out.println(eqs.getEquationAnswer());
    }

    @Test
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
    public void partialSolution() {
        assertEquals(5, equ.partialSolution(new int[]{1,2,3}, new char [] {'x','+'}));
        assertEquals(2, equ.partialSolution(new int[]{1,2}, new char [] {'x'}));
        assertEquals(8, equ.partialSolution(new int[]{1,2,3,4}, new char [] {'^','+','+'}));
        assertEquals(1, equ.partialSolution(new int[]{1}, new char [] {}));
    }

}