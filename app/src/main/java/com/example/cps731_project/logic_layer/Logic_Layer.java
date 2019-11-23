package com.example.cps731_project.logic_layer;


public class Logic_Layer {

    Game game = new Game();

    public Logic_Layer(){
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
            return 0;

        return game.getCurrentEquation().partialSolution(numbers, modifiers);
    }

    //returns score for UI
    public int getScore(){
        return game.getScore();
    }

    //if true the game will increase the score and UI is expected to call for the next round
    public boolean solved(int [] numbers, char[] modifiers){
        if(calculateEquation(numbers, modifiers)==currentAnswer()) {
            game.increaseScore();
            return true;
        }
        else
            return false;
    }
}
