package com.groupprojects.hangman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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
    private int numChars;
    //number correctly guessed
    private int numCorr;
    private String answer = "     ";
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

    public void showCurrWord(View view){
        Toast.makeText(this, getGameWord(), Toast.LENGTH_SHORT).show();
        if (currPart < 5) {
            bodyParts[currPart].setVisibility(View.INVISIBLE);
        }
        currPart ++;
        if (currPart < 6) {
            bodyParts[currPart].setVisibility(View.VISIBLE);
        }    }


    public void checkLetterQ(View view) {
        TextView textview = findViewById(R.id.alphQ);
        TextView textview2 = findViewById(R.id.typedWORD);
        for (int i = 0; i < gameWordSelected.length();i++) {
            if (gameWordSelected.charAt(i) == 'Q') {
                textview.setBackgroundColor(Color.GREEN);
                textview2.setText(answer);

            }
            else {
                textview.setBackgroundColor(Color.RED);
            }
        }
    }

    public void checkLetter(View v) {
        Character pageNumber = (v.getTag().toString()).charAt(0);
        String page2 = v.getTag().toString();
        TextView textview = findViewById(R.id.alphW);
        TextView textview2 = findViewById(R.id.typedWORD);
        for (int i = 0; i < gameWordSelected.length();i++) {
            if (gameWordSelected.charAt(i) == pageNumber) {
                textview.setBackgroundColor(Color.GREEN);
                textview2.setText(page2);
                break;
            }
            else {
                textview.setBackgroundColor(Color.RED);
            }
        }
    }
}