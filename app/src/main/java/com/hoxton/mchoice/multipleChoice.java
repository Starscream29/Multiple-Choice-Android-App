package com.hoxton.mchoice;

import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.Random;


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
    int[] questionArray = new int[86];


    //Function for shuffling an array courtesy of Dan Bray at:
    // https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
    private static void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

    public void chooseA(View view){
        if (correctAnswer == 1) {
            score++;
            getNewSet();
        }
        else {
            OptionA.setText("INCORRECT");
            score --;
        }

    }
    public void chooseB(View view){
        if (correctAnswer == 2) {
            score++;
            getNewSet();
        }
        else {
            OptionB.setText("INCORRECT");
            score --;
        }
    }
    public void chooseC(View view){
        if (correctAnswer == 3) {
            score++;
            getNewSet();
        }
        else {
            OptionC.setText("INCORRECT");
            score --;
        }
    }
    public void chooseD(View view){
        if (correctAnswer == 4) {
            score++;
            getNewSet();
        }
        else {
            OptionD.setText("INCORRECT");
            score --;
        }
    }

    public void getNewSet(){

        if (questionsCount == 10 && quizType.equals("quiz10")){

            Intent intent = new Intent(this, quizOverScreen.class);
            intent.putExtra("scoreValue", score);
            intent.putExtra("total", 10);
            Bundle bundle = new Bundle();
            bundle.putString("quizType", quizType);
            bundle.putString("courseName", courseName);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if(questionsCount == 25 && quizType.equals("quiz25")){

            Intent intent = new Intent(this, quizOverScreen.class);
            intent.putExtra("scoreValue", score);
            intent.putExtra("total", 25);
            Bundle bundle = new Bundle();
            bundle.putString("quizType", quizType);
            bundle.putString("courseName", courseName);
            intent.putExtras(bundle);
            startActivity(intent);
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

        currentEntry= myDbHelper.returnInfo(questionArray[current], courseName);

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

        for(int k = 0; k < questionArray.length; k++)
            questionArray[k] = k+1;

        shuffleArray(questionArray);

        getNewSet();
    }
}
