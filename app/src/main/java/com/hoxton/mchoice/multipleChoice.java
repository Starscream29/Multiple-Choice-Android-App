package com.hoxton.mchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class multipleChoice extends AppCompatActivity {

    TextView textView;
    TextView textView1;



String courseName;
String quizType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        textView = findViewById(R.id.test);
        textView1 = findViewById(R.id.test1);

        Bundle bundle = getIntent().getExtras();
        courseName = bundle.getString("courseName");
        quizType = bundle.getString("quizType");

        textView.setText(courseName);
        textView1.setText(quizType);


    }
}
