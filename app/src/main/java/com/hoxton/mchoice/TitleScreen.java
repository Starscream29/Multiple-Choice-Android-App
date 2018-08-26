package com.hoxton.mchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class TitleScreen extends AppCompatActivity {

    Button startButton;

// Move from start screen into the select-course activity
    public void startGame(View view) {
        Intent intent = new Intent(this, chooseCourse.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        startButton = findViewById(R.id.startButton);
    }
}
