package com.example.cps731_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.cps731_project.common.Utilities;
import com.example.cps731_project.logic_layer.*;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private TextView selectedView = null;
    private String[] validNumbers = null;
    private String[] validOperators = {"+", "-"};
    private Logic_Layer logic_layer = new Logic_Layer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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

    private void setClickableNums(String[] nums) {
        ((TextView) findViewById(R.id.operand1)).setText(nums[0]);
        ((TextView) findViewById(R.id.operand2)).setText(nums[1]);
        ((TextView) findViewById(R.id.operand3)).setText(nums[2]);
        ((TextView) findViewById(R.id.operand4)).setText(nums[3]);
        ((TextView) findViewById(R.id.operand5)).setText(nums[4]);
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
    }

    /**
     * Submits the current equation the user has made to check if they got it right
     * @param view
     */
    public void submitAnswer(View view) {
        String[] numbers = {
                ((TextView) findViewById(R.id.space1)).getText().toString(),
                ((TextView) findViewById(R.id.space2)).getText().toString(),
                ((TextView) findViewById(R.id.space3)).getText().toString(),
                ((TextView) findViewById(R.id.space4)).getText().toString(),
                ((TextView) findViewById(R.id.space5)).getText().toString()
        };

        String[] operators = {
                ((TextView) findViewById(R.id.operator1)).getText().toString(),
                ((TextView) findViewById(R.id.operator2)).getText().toString(),
                ((TextView) findViewById(R.id.operator3)).getText().toString(),
                ((TextView) findViewById(R.id.operator4)).getText().toString(),
        };

        if(validNumsAndOps(numbers, operators)) {
            //Check answer to see if it is a valid answer
            Log.d("ANSWER", "Valid answer");

            Utilities util = new Utilities();

            ((TextView) findViewById(R.id.userAnswer)).setText(logic_layer.calculateEquation(util.toIntArray(numbers), util.toCharArray(operators)) + "");
            boolean correct = logic_layer.solved(util.toIntArray(numbers), util.toCharArray(operators));
            Log.d("ANSWER", "Sending: " + Arrays.toString(util.toIntArray(numbers)) + ", " + Arrays.toString(util.toCharArray(operators)));
            Log.d("ANSWER", "Answer result: " + correct);
        } else {
            //Do something, like an error message?
            Log.d("ANSWER", "Invalid answer");
        }
    }

    /**
     * Checks if the passed nums and ops arrays are valid
     * @param nums, the array that contains the numbers to be checked
     * @param ops, the array that contains the operators to be checked
     * @return true or false if the numbers and operators are valid
     */
    private boolean validNumsAndOps(String[] nums, String[] ops) {
        for(int i = 0; i < nums.length; i++) {
            if(!validNumber(nums[i])) {
                return false;
            }
        }

        for(int i = 0; i < ops.length; i++) {
            if(!validOperator(ops[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Parses the number of the view passed into the function
     * @param num, the passed TextView to get parse the number of
     * @return the parse number
     */
    private boolean validNumber(String num) {
        for(int i = 0; i < validNumbers.length; i++) {
            Log.d("ANSWER", "Checking if " + num + " in " + validNumbers[i].toString());
            if(validNumbers[i].equals(num)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if the passed operator is valid
     * @param operator to be check if it is valid
     * @return true or false if the operator is valid
     */
    private boolean validOperator(String operator) {
        for(int i = 0; i < validOperators.length; i++) {
            if(validOperators[i].equals(operator)) {
                return true;
            }
        }

        return false;
    }
}
