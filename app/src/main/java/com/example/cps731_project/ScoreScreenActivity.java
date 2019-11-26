package com.example.cps731_project;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

/**
 * Score screen that gets called when countdown in GameActivity reaches 0. Users will have the option to either be able to go back to main menu or retry the game
 *
 * @Date 2019-11-25
 * @Last_Modified 2019-11-25
 */
public class ScoreScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);

        //set the score
        setScoreEarned();
    }

    //Sets the score user obtained in the last game
    public void setScoreEarned(){
        Intent intent = getIntent();
        String score = intent.getStringExtra("user_score");
        ((TextView) findViewById(R.id.scoreEarnedTxt)).setText(score);
    }

    //Sends user back to game activity to retry
    public void retryButton(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    //sends user back to the main menu
    public void backToMainMenuButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
