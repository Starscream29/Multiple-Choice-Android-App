package com.hoxton.mchoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static java.lang.reflect.Array.getInt;

public class quizOverScreen extends AppCompatActivity {

    TextView scoreTotal;
    String courseName;
    String quizType;

    public void tryAgain(View view){
        Intent intent = new Intent(this, multipleChoice.class);
        Bundle bundle = new Bundle();
        bundle.putString("quizType", quizType);
        bundle.putString("courseName", courseName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void newQuiz(View view){
        Intent intent = new Intent(this, chooseGameType.class);
        Bundle bundle = new Bundle();
        bundle.putString("courseName", courseName);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void newCourse(View view){
        Intent intent = new Intent(this, chooseCourse.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_over_screen);

        scoreTotal = findViewById(R.id.scoreValue);

        Bundle bundle = getIntent().getExtras();
        courseName = bundle.getString("courseName");
        quizType = bundle.getString("quizType");

        Intent intent = getIntent();
        int scoreValue = intent.getExtras().getInt("scoreValue", 0);
        int total = intent.getExtras().getInt("total", 0);

        scoreTotal.setText(Integer.toString(scoreValue) + "/" + Integer.toString(total));

    }

}
