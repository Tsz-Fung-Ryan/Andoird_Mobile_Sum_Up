package com.example.cps731_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView selectedView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

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

    public void switchValues(TextView view1, TextView view2) {
        String temp = view1.getText().toString();
        view1.setText(view2.getText());
        view2.setText(temp);
    }

    public void cycleOperators(View view) {
        TextView textView = (TextView) view;

        if(textView.getText().toString().equals("+")) {
            textView.setText("-");
        } else {
            textView.setText("+");
        }
    }
}
