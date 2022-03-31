package com.groupprojects.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class wordList {
    private static Random random = new Random();
    private static final int DEFAULT_WORD_LENGTH = 3;
    private HashSet<String> wordSet;
    private static ArrayList<String> wordLists;
    private int wordLength = DEFAULT_WORD_LENGTH;

    public wordList(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;

        wordSet = new HashSet<>();
        wordLists = new ArrayList<>();

        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            wordLists.add(word);
        }
    }

    public static String pickGoodStarterWord() {
        int index = random.nextInt(wordLists.size());
        String t=wordLists.get(index);
        if(t.length()<=6)
            return wordLists.get(index);
        else return pickGoodStarterWord();
    }

    public static String getWord(){
        return pickGoodStarterWord();
    }
}
