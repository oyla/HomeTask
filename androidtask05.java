package com.example.user.androidhometask05;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    int flag;
    MediaPlayer mediaPlayer;
    int gimn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String locale = Locale.getDefault().getLanguage();
        imageButton = (ImageButton) findViewById(R.id.imageButton);

        switch (locale) {
            case "uk":
                flag = R.drawable.fl_uk;
                gimn = R.raw.gimn_uk;
                break;
            case "ru":
                flag = R.drawable.fl_ru;
                gimn = R.raw.gimn_ru;
                break;
            case "gb":
                flag = R.drawable.fl_gb;
                gimn = R.raw.gimn_gb;
                break;
            default:
                flag = R.drawable.fl_en;
                gimn = R.raw.gimn_us;
                break;
        }
        imageButton.setImageResource(flag);
        mediaPlayer = MediaPlayer.create(this, gimn);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }
}
