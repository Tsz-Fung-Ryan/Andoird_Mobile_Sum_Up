package com.example.cps731_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.cps731_project.logic_layer.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private TextView selectedView = null;
    private String[] validNumbers = null;
    private Logic_Layer logic_layer = new Logic_Layer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        newGame();
    }

    public void newGame() {
        resetFields();

        int[] numbers = logic_layer.play();

        Log.d("GAME", "Numbers: " + Arrays.toString(numbers));

        validNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            validNumbers[i] = numbers[i] + "";
        }

        int answer = logic_layer.currentAnswer();

        Log.d("GAME", "Answer: " + answer);
        Log.d("GAME", "Equation: " + logic_layer.getFormula());

        TextView answerView = findViewById(R.id.computerAnswer);
        answerView.setText(Integer.toString(answer));

        setClickableNums(validNumbers);
    }

    /**
     * Handles what happens when an element is tapped
     * @param view that is being tapped on
     */
    public void elementClick(View view) {
        TextView textView = (TextView) view;

        if(selectedView == textView) {
            textView.setTextSize(14);
            selectedView = null;
        } else if(selectedView != null) {
            switchValues(selectedView, textView);
            selectedView.setTextSize(14);
            textView.setTextSize(14);
            selectedView = null;
        } else {
            textView.setTextSize(28);
            selectedView = textView;
        }

        calculateAnswer();
    }

    /**
     * Switches the text values in the 2 passed views
     * @param view1, first view to switch values with
     * @param view2, second view to switch values with
     */
    public void switchValues(TextView view1, TextView view2) {
        String temp = view1.getText().toString();
        view1.setText(view2.getText());
        view2.setText(temp);
    }

    /**
     * Cycles through the available operators for the passed view
     * @param view, the passed view to cycle
     */
    public void cycleOperators(View view) {
        TextView textView = (TextView) view;

        if(textView.getText().toString().equals("+")) {
            textView.setText("-");
        } else {
            textView.setText("+");
        }

        calculateAnswer();
    }

    /**
     * Calls logic layer to calculate current answer and display result to user
     */
    public void calculateAnswer() {
        int[] numbers = getNumbers();
        char[] operators = getOperators();

        if(numbers.length > 0 && numbers.length-1 == operators.length) {
            int currentAnswer = logic_layer.calculateEquation(numbers, operators);

            ((TextView) findViewById(R.id.userAnswer)).setText(currentAnswer + "");
        }
    }

    /**
     * Submits the current equation the user has made to check if they got it right
     * @param view
     */
    public void submitAnswer(View view) {
        int[] numbers = getNumbers();
        char[] operators = getOperators();

        if(numbers.length == 5 && operators.length == 4) {
            //Check answer to see if it is a valid answer
            Log.d("ANSWER", "Valid answer");

            ((TextView) findViewById(R.id.userAnswer)).setText(logic_layer.calculateEquation(numbers, operators) + "");
            boolean correct = logic_layer.solved(numbers, operators);
            Log.d("ANSWER", "Sending: " + Arrays.toString(numbers) + ", " + Arrays.toString(operators));
            Log.d("ANSWER", "Answer result: " + correct);
            ((TextView) findViewById(R.id.currentScore)).setText(logic_layer.getScore() + "");
            newGame();
        } else {
            Log.d("ANSWER", "Invalid answer");
        }
    }

    /**
     * Returns all the numbers in an int array
     * @return the int array
     */
    private int[] getNumbers() {
         ArrayList<Integer> validNumbers = new ArrayList<>();
        //If the space does not contain the string blank then add it as an integer to the validNumbers arraylist
        if(!((TextView) findViewById(R.id.space1)).getText().toString().equals("Blank")) validNumbers.add(Integer.valueOf(((TextView) findViewById(R.id.space1)).getText().toString()));
        if(!((TextView) findViewById(R.id.space2)).getText().toString().equals("Blank")) validNumbers.add(Integer.valueOf(((TextView) findViewById(R.id.space2)).getText().toString()));
        if(!((TextView) findViewById(R.id.space3)).getText().toString().equals("Blank")) validNumbers.add(Integer.valueOf(((TextView) findViewById(R.id.space3)).getText().toString()));
        if(!((TextView) findViewById(R.id.space4)).getText().toString().equals("Blank")) validNumbers.add(Integer.valueOf(((TextView) findViewById(R.id.space4)).getText().toString()));
        if(!((TextView) findViewById(R.id.space5)).getText().toString().equals("Blank")) validNumbers.add(Integer.valueOf(((TextView) findViewById(R.id.space5)).getText().toString()));

        int[] numbers = new int[validNumbers.size()];
        for(int i = 0; i < validNumbers.size(); i++) {
            numbers[i] = validNumbers.get(i);
        }

        return numbers;
    }

    /**
     * Returns all the operators in a char array
     * @return the char array
     */
    private char[] getOperators() {
        ArrayList<Character> validOperators = new ArrayList<>();
        //If the space does not contain the string blank then add it as an character to the validOperators arraylist
        if(!((TextView) findViewById(R.id.operator1)).getText().toString().equals("Operator")) validOperators.add(((TextView) findViewById(R.id.operator1)).getText().charAt(0));
        if(!((TextView) findViewById(R.id.operator2)).getText().toString().equals("Operator")) validOperators.add(((TextView) findViewById(R.id.operator2)).getText().charAt(0));
        if(!((TextView) findViewById(R.id.operator3)).getText().toString().equals("Operator")) validOperators.add(((TextView) findViewById(R.id.operator3)).getText().charAt(0));
        if(!((TextView) findViewById(R.id.operator4)).getText().toString().equals("Operator")) validOperators.add(((TextView) findViewById(R.id.operator4)).getText().charAt(0));

        char[] operators = new char[validOperators.size()];
        for(int i = 0; i < validOperators.size(); i++) {
            operators[i] = validOperators.get(i);
        }

        return operators;
    }

    /**
     * Sets the values for the clickable textviews
     * @param nums, the numbers to set the textviews to
     */
    private void setClickableNums(String[] nums) {
        ((TextView) findViewById(R.id.operand1)).setText(nums[0]);
        ((TextView) findViewById(R.id.operand2)).setText(nums[1]);
        ((TextView) findViewById(R.id.operand3)).setText(nums[2]);
        ((TextView) findViewById(R.id.operand4)).setText(nums[3]);
        ((TextView) findViewById(R.id.operand5)).setText(nums[4]);
    }

    /**
     * Resets the fields on the screen
     */
    public void resetFields() {
        ((TextView) findViewById(R.id.computerAnswer)).setText(getString(R.string.blank));

        ((TextView) findViewById(R.id.operand1)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.operand2)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.operand3)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.operand4)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.operand5)).setText(getString(R.string.blank));

        ((TextView) findViewById(R.id.space1)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.space2)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.space3)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.space4)).setText(getString(R.string.blank));
        ((TextView) findViewById(R.id.space5)).setText(getString(R.string.blank));

        ((TextView) findViewById(R.id.operator1)).setText(getString(R.string.operator));
        ((TextView) findViewById(R.id.operator2)).setText(getString(R.string.operator));
        ((TextView) findViewById(R.id.operator3)).setText(getString(R.string.operator));
        ((TextView) findViewById(R.id.operator4)).setText(getString(R.string.operator));

        ((TextView) findViewById(R.id.userAnswer)).setText(getString(R.string.blank));
    }
}
