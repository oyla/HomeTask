package com.example.user.androidtask06;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    int count = 0;
    int songTextLength = 0;
    CountDownTimer cdt;
    String[] songText;
    Toast toast;
    long lengthLong = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.setLooping(true);
        songText = getResources().getStringArray(R.array.song_array);
        songTextLength = songText.length;
        cdt = new CountDownTimer(lengthLong * (songTextLength + 1), lengthLong) {

            @Override
            public void onTick(long millisUntilFinished) {
                showToast();
            }

            @Override
            public void onFinish() {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        cdt.start();
    }

    public void showToast() {
        Toast.makeText(this, songText[count], Toast.LENGTH_LONG).show();
        count++;
        if (count == songTextLength) {
            count = 0;
            cdt.start();
        }
    }

}
