package com.example.user.androidtask03;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    int count;
    final int maxCount = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (count < maxCount) {
            count++;
            button1.setText(count + "");
        } else if (count == maxCount) {
            button1.setText("Doesnt work");
            button1.setBackgroundColor(Color.LTGRAY);
            button1.setClickable(false);
        }
    }
}
