package com.example.oyla.androidtask04;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    CountDownTimer cdt;
    Date dt;
    final String beginText = "Lesson has begun!";
    String finishText = "Lesson has over!";
    final int beginHour = 18;
    final int finishHour = 21;
    boolean startCounter = false;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        TimeZone tz = TimeZone.getTimeZone("Europe/Kiev");
        c = new GregorianCalendar(tz);
        if (c.get(Calendar.HOUR_OF_DAY) >= finishHour) {
            tv.setText(finishText);
        } else if ((c.get(Calendar.HOUR_OF_DAY) >= beginHour) && (c.get(Calendar.HOUR_OF_DAY) < finishHour)) {
            tv.setText(beginText);
        } else {
            startCounter = true;
            long millsec = c.getTimeInMillis();
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.HOUR_OF_DAY, beginHour);
            millsec = c.getTimeInMillis() - millsec;
            cdt = new CountDownTimer(millsec, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    dt = new Date(millisUntilFinished);
                    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
                    tv.setText(df.format(dt));
                    int newColor = Color.argb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(newColor));
                }

                @Override
                public void onFinish() {
                    tv.setText(beginText);
                }
            };

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (startCounter) {
            cdt.start();
        }
    }
}

