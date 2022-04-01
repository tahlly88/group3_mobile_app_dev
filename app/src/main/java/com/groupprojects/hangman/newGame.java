package com.groupprojects.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class newGame extends AppCompatActivity {
private String gameWordSelected = wordList.getWord();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
    }
    public String getGameWord(){
        return gameWordSelected;
    }

    public void showCurrWord(View view){
        Toast.makeText(this, getGameWord(), Toast.LENGTH_SHORT).show();
    }
}