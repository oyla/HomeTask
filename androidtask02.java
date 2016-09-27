package com.example.user.androidtask02;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    final String[] fontsSelect = {
            "Bold",
            "Italic",
            "Light",
            "Medium",
            "Regular"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float r = (float) Math.random() * 20 + 10;
        button1.setTextSize(r);

        int newColor = Color.argb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        button1.setTextColor(newColor);

        int newBackColor = Color.argb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        button1.setBackgroundColor(newBackColor);

        int selectFont = (int) (Math.random() * 5);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/" + fontsSelect[selectFont] + ".ttf");
        button1.setTypeface(face);

        button1.setText(fontsSelect[selectFont] + " " + String.format("%.2f", r));
    }
}
