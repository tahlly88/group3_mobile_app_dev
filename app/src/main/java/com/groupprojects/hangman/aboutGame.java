package com.groupprojects.hangman;

import static com.groupprojects.hangman.R.raw.*;
import static com.groupprojects.hangman.R.raw.about_theme;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class aboutGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        MediaPlayer media = MediaPlayer.create(this,about_theme);
        media.start();


    }

    public void getNewWord(View view){
        Toast.makeText(aboutGame.this, wordList.getWord(), Toast.LENGTH_SHORT).show();

    }
}