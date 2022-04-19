package com.groupprojects.hangman;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class newGame extends AppCompatActivity {
    private String gameWordSelected = (wordList.getWord()).toUpperCase();
    //body part images
    private ImageView[] bodyParts;
    //number of body parts
    private int numParts=7;
    //current part - will increment when wrong answers are chosen
    private int currPart;
    //number of characters in current word
    private int numChars = 5;
    //number correctly guessed
    private int numCorr = 0;
    private int numWrong = 0;
    private boolean guessCorr;
    private int numRight = 0;
    private String typedWord;
    private TextView[] gameWordChars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        currPart =0;
        bodyParts = new ImageView[numParts];
        bodyParts[0] = findViewById(R.id.base);
        bodyParts[1] = findViewById(R.id.head);
        bodyParts[2] = findViewById(R.id.body);
        bodyParts[3] = findViewById(R.id.leftArm);
        bodyParts[4] = findViewById(R.id.arms);
        bodyParts[5] = findViewById(R.id.lLeg);
        bodyParts[6] = findViewById(R.id.rLeg);

        gameWordChars = new TextView[5];
        gameWordChars[0] = findViewById(R.id.ltr1);
        gameWordChars[1] = findViewById(R.id.ltr2);
        gameWordChars[2] = findViewById(R.id.ltr3);
        gameWordChars[3] = findViewById(R.id.ltr4);
        gameWordChars[4] = findViewById(R.id.ltr5);



        for(int p = 1; p < numParts; p++) {
            bodyParts[p].setVisibility(View.INVISIBLE);
        }
    }
    public String getGameWord(){
        return gameWordSelected;
    }

    public void showCurrWord(View view) {
        Toast.makeText(this, getGameWord(), Toast.LENGTH_SHORT).show();
    }

    public void checkLetter(View view) {
        guessCorr = false;
        String ltr=((TextView)view).getText().toString();
        char letterChar = ltr.charAt(0);
        for (int i = 0; i < gameWordSelected.length();i++) {

            if (numCorr != gameWordSelected.length()) {
                if (gameWordSelected.charAt(i) == letterChar) {
                    guessCorr = true;
                    gameWordChars[i].setText(ltr);
                    numRight++;
                }
            }
        }
            if (guessCorr == true) {
                ((TextView)view).setBackgroundColor(Color.GREEN);
                ((TextView)view).setClickable(false);
                numCorr++;
                if (numRight == gameWordSelected.length()){
                    youWin();
            }
            }

            else {

                ((TextView)view).setBackgroundColor(Color.RED);
                ((TextView)view).setClickable(false);
                if (currPart < 6) {
                    bodyParts[currPart].setVisibility(View.INVISIBLE);
                }
                currPart ++;
                if (currPart < 7) {
                    bodyParts[currPart].setVisibility(View.VISIBLE);
                }
                if (currPart == 6){
                   youLose();
                }
            }



    }

    public void killGame() {
        this.finishAffinity();
    }

    public void playAgain() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void checkTypedWord(View view){

        typedWord = ((TextView)view).getText().toString();

        if (typedWord.toUpperCase().equals(gameWordSelected)){
           youWin();
        }
        else {
           youLose();
        }

    }

    public void youWin(){
        AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
        winBuild.setTitle("YAY");
        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+gameWordSelected);
        winBuild.setPositiveButton("Play Again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playAgain();
                    }});

        winBuild.setNegativeButton("Exit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        killGame();
                    }});

        winBuild.show();
    }

    public void youLose(){
        AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
        winBuild.setTitle("Aww");
        winBuild.setMessage("You Lost!\n\nThe answer was:\n\n"+gameWordSelected);
        winBuild.setPositiveButton("Play Again",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        playAgain();
                    }});

        winBuild.setNegativeButton("Exit",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        killGame();
                    }});

        winBuild.show();
    }




}