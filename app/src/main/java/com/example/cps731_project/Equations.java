package com.example.cps731_project;
import java.util.Random;


public class Equations {

    private final int AMOUNTOFNUMBERS = 5;
    private Random rand = new Random();
    private int [] numbers = new int [AMOUNTOFNUMBERS];
    private char [] modifiers;
    private int answer;

    public Equations(int [] numbers){
        this.numbers = numbers;
        setModifiers(new char [] {'+','-'});
    }

    public Equations (int [] numbers, char [] modifiers){
        setNumbers(numbers);
        setModifiers(modifiers);
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int [] getNumbers(){
        return numbers;
    }

    public void setModifiers(char[] modifiers) {
        this.modifiers = modifiers;
    }
    public char [] getModifiers(){
        return modifiers;
    }
    public int generateAnswer(){
        numbers = getNumbers();
        int randInt = rand.nextInt(numbers.length);

        answer = numbers[randInt];
        int [] newNumbers = new int[numbers.length-1];

        for(int i = 0; i<newNumbers.length; i++){
            if(i>=randInt)
                newNumbers[i]=numbers[i+1];
            else
                newNumbers [i]= numbers[i];
        }

        answer = iterateAnswer(answer, newNumbers);
        return answer;
    }

    public int iterateAnswer(int answer, int[]numbers){
        if(numbers.length==0)
            return answer;
        else{
            modifiers=getModifiers();
            int randInt = rand.nextInt(numbers.length);
            int operand = numbers[randInt];
            randInt = rand.nextInt(modifiers.length);
            char operator = modifiers[randInt];

            answer = calculate(answer, operator, operand);

            int [] newNumbers = new int[numbers.length-1];

            for(int i = 0; i<newNumbers.length; i++){
                if(i>=randInt)
                    newNumbers[i]=numbers[i+1];
                else
                    newNumbers [i]= numbers[i];
            }
            answer = iterateAnswer(answer, newNumbers);
            return answer;
        }
    }
    private int calculate (int operand1, char modifier, int operand2){
        int calculation=operand1;

        switch(modifier) {
            case '+':
                calculation+=operand2;
                break;
            case '-':
                calculation-=operand2;
                break;
            case 'x':
                calculation= calculation*operand2;
                break;
        }
        return calculation;
    }
}
