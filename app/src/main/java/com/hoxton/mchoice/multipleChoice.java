package com.hoxton.mchoice;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class multipleChoice extends AppCompatActivity {

    String courseName;
    String quizType;
    int correctAnswer;
    int score = 0;
    int questionsCount = 0;
    int current = 0;
    TextView Question;
    TextView OptionA;
    TextView OptionB;
    TextView OptionC;
    TextView OptionD;
    String[] currentEntry;


    public void chooseA(View view){
        if (correctAnswer == 1) {
            score+=3;
            getNewSet();
        }
        else {
            OptionA.setText("INCORRECT");
            score --;
        }

    }
    public void chooseB(View view){
        if (correctAnswer == 2) {
            score+=3;
            getNewSet();
        }
        else {
            OptionB.setText("INCORRECT");
            score --;
        }
    }
    public void chooseC(View view){
        if (correctAnswer == 3) {
            score+=3;
            getNewSet();
        }
        else {
            OptionC.setText("INCORRECT");
            score --;
        }
    }
    public void chooseD(View view){
        if (correctAnswer == 4) {
            score+=3;
            getNewSet();
        }
        else {
            OptionD.setText("INCORRECT");
            score --;
        }
    }

    public void getNewSet(){
        if (quizType.equals("quiz")){
            if (questionsCount >= 10) {
                Question.setText("Total score: " + score + "/10");
            }
        }

        com.hoxton.mchoice.DataBaseHelper myDbHelper;
        myDbHelper = new com.hoxton.mchoice.DataBaseHelper(this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database"); }
        try {
            myDbHelper.openDataBase();
        }catch(SQLException sqle){
            throw sqle; }

        currentEntry= myDbHelper.returnInfo(current, courseName);

        Question.setText(currentEntry[0]);
        OptionA.setText(currentEntry[1]);
        OptionB.setText(currentEntry[2]);
        OptionC.setText(currentEntry[3]);
        OptionD.setText(currentEntry[4]);

        correctAnswer = Integer.parseInt(currentEntry[5]);

        questionsCount ++;

        current++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        Bundle bundle = getIntent().getExtras();
        courseName = bundle.getString("courseName");
        quizType = bundle.getString("quizType");

        Question = findViewById(R.id.Question);

        OptionA = findViewById(R.id.OptionA);
        OptionB = findViewById(R.id.OptionB);
        OptionC = findViewById(R.id.OptionC);
        OptionD = findViewById(R.id.OptionD);

        getNewSet();
    }
}
