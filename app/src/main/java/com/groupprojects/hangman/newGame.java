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
    //private String gameWordSelected = "Winner";
    //body part images
    private ImageView[] bodyParts;
    //number of body parts
    private int numParts=6;
    //current part - will increment when wrong answers are chosen
    private int currPart;
    //number of characters in current word
    private int numChars = 5;
    //number correctly guessed
    private int numCorr = 0;
    private int numWrong = 0;
    private String answer = "";
    TextView[] charViews = new TextView[gameWordSelected.length()];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        currPart =0;
        bodyParts = new ImageView[numParts];
        bodyParts[0] = findViewById(R.id.base);
        bodyParts[1] = findViewById(R.id.head);
        bodyParts[2] = findViewById(R.id.body);
        bodyParts[3] = findViewById(R.id.arms);
        bodyParts[4] = findViewById(R.id.lLeg);
        bodyParts[5] = findViewById(R.id.rLeg);
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

        String ltr=((TextView)view).getText().toString();
        char letterChar = ltr.charAt(0);

        //Character pageNumber = (v.getTag().toString()).charAt(0);
        //String page2 = v.getTag().toString();
        //TextView textview = (TextView) ((TextView)view).getText();
        TextView textview2 = findViewById(R.id.typedWORD);
        for (int i = 0; i < gameWordSelected.length();i++) {

            if (numCorr != gameWordSelected.length()) {
                if (gameWordSelected.charAt(i) == letterChar) {
                    ((TextView)view).setBackgroundColor(Color.GREEN);
                    ((TextView)view).setClickable(false);
                    textview2.setText("Letter is in Word");
                    numCorr++;
                    if (numCorr == gameWordSelected.length()){
                        AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
                        winBuild.setTitle("YAY");
                        winBuild.setMessage("You win!\n\nThe answer was:\n\n"+gameWordSelected);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        MainActivity.onNewClick();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // GameActivity.this.finish();
                                    }});

                        winBuild.show();
                    }
                    break;
                } else {
                    //charViews[i].setBackgroundColor(Color.RED);
                    textview2.setText("Letter is not in Word");
                    //numWrong++;
                    ((TextView)view).setBackgroundColor(Color.RED);
                    ((TextView)view).setClickable(false);
                    if (currPart < 5) {
                        bodyParts[currPart].setVisibility(View.INVISIBLE);
                    }
                    currPart ++;
                    if (currPart < 6) {
                        bodyParts[currPart].setVisibility(View.VISIBLE);
                    }
                    if (currPart == 5){
                        AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
                        winBuild.setTitle("Aww");
                        winBuild.setMessage("You Lost!\n\nThe answer was:\n\n"+gameWordSelected);
                        winBuild.setPositiveButton("Play Again",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        MainActivity.onNewClick();
                                    }});

                        winBuild.setNegativeButton("Exit",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // GameActivity.this.finish();
                                    }});

                        winBuild.show();
                    }
                    break;
                }
            }


        }
    }


}