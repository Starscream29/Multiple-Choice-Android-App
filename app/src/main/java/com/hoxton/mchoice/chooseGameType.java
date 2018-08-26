package com.hoxton.mchoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseGameType extends AppCompatActivity {

    Button Quiz;
    Button allQuestions;
    String courseName;

    public void startQuiz(View view){
        Intent intent = new Intent(this, multipleChoice.class);
        //Save quiz type as quiz and pass on for later, as well as courseName
        String quizType = "quiz";
        Bundle bundle = new Bundle();
        bundle.putString("quizType", quizType);
        bundle.putString("courseName", courseName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void allQuestions(View view){
        Intent intent = new Intent(this, multipleChoice.class);
        //Save quiz type as allQuestions and pass on for later, as well as courseName
        String quizType = "allQuestions";
        Bundle bundle = new Bundle();
        bundle.putString("quizType", quizType);
        bundle.putString("courseName", courseName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game_type);

        Bundle bundle = getIntent().getExtras();
        courseName = bundle.getString("courseName");
        Quiz = findViewById(R.id.Quiz);
        allQuestions = findViewById(R.id.allQuestions);


    }
}
