package com.groupprojects.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class aboutGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //the below code is to make sure the word list is working properly

         Toast toast2 = Toast.makeText(this, wordList.getWord(), Toast.LENGTH_LONG);
         toast2.show();

    }

    public void getNewWord(View view){
        Toast.makeText(aboutGame.this, wordList.getWord(), Toast.LENGTH_SHORT).show();
    }
}