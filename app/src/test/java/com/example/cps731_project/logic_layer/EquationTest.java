package com.example.cps731_project.logic_layer;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;


public class EquationTest {

    private Random rand = new Random(10);
    int[] num = new int [5];
    char[] s = new char [4];
    Equation eq = new Equation(num);

    @Test
    public void setNumbers() {
    }

    @Test
    public void getNumbers() {
        assertEquals(5, num.length);
    }

    @Test
    public void setModifiers() {
    }

    @Test
    public void getModifiers() {
    }

    @Test
    public void generateAnswer() {
        Equation equ = new Equation(new int[] {1,2,3,4,5});
        System.out.println(equ.generateAnswer());
    }

    @Test
    public void getAnswer() {

    }

    @Test
    public void calculate() {
        int a = 6;
        int b = 2;

        assertEquals(8, eq.calculate(a, '+', b));
        assertEquals(4, eq.calculate(a, '-', b));
        assertEquals(12, eq.calculate(a, 'x', b));
        //assertEquals(8, eq.calculate(a, '/', b));
        //assertEquals(36, eq.calculate(a, '^', b));

    }

    @Test
    public void partialSolution() {

    }
}