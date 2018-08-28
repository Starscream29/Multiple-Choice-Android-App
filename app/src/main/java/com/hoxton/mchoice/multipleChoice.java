package com.hoxton.mchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class multipleChoice extends AppCompatActivity {

    String courseName;
    String quizType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        Bundle bundle = getIntent().getExtras();
        courseName = bundle.getString("courseName");
        quizType = bundle.getString("quizType");

    }
}
