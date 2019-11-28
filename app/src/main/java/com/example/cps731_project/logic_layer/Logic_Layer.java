package com.example.cps731_project.logic_layer;

/*
"
* Interface that provides logic for users to play games
*
* */
public class Logic_Layer {

    //Game class
    Game game;

    //Constructor
    public Logic_Layer(){
        game = new Game();
    }

    //plays a round of the game
    public int[] play(){
        game.playGame();
        return game.getCurrentEquation().getNumbers();
    }

    //Creates a new game
    public void newGame(){
        game = new Game();
    }

    //getter to obtain the answer for the UI
    public int currentAnswer(){
        return game.getCurrentEquation().getAnswer();
    }

    //returns current calcuation for UI
    public int calculateEquation(int [] numbers, char[]modifiers){
        if (numbers.length<=1||modifiers.length<=0)
            return numbers[0];

        return game.getCurrentEquation().partialSolution(numbers, modifiers);
    }

    //returns score for UI
    public int getScore(){
        return game.getScore();
    }

    //if true the game will increase the score and UI is expected to call for the next round
    public boolean solved(int [] numbers, char[] modifiers){
        return game.solved(numbers, modifiers);
    }

    //returns the formula that gives the correct answer used for testing
    public String getFormula(){
        return game.getCurrentEquation().getEquationAnswer();
    }
}
