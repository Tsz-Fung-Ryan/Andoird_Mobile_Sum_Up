package com.example.cps731_project;
import java.util.Random;


public class Equations {

    final int AMOUNTOFNUMBERS = 5;
    int [] numbers = new int [AMOUNTOFNUMBERS];
    char [] modifiers;

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

    public int generateAnswer(){
        Random rand = new Random();
        int answer;
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

        //gonna have to do something with the modifier

        answer = iterateAnswer(answer, newNumbers);
        return answer;
    }
    public int iterateAnswer(int answer, int[]numbers){
        if(numbers.length==0)
            return answer;
        else{

        }
        return answer;
    }
}
