package com.hoxton.mchoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseCourse extends AppCompatActivity {

    Button HIST115;

    public void chooseHIST115(View view) {
        Intent intent = new Intent(this, chooseGameType.class);
        //Save value of HIST115 into courseName and pass it on for later
        String courseName = "HIST115";
        Bundle bundle = new Bundle();
        bundle.putString("courseName", courseName);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_course);

        HIST115 = findViewById(R.id.HIST115);
    }
}
