package com.example.user.androidtask05;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    //ImageButton imgBtn = (ImageButton) findViewById(R.id.imgBtn);
    ImageButton imgButton;
    int[] resID = {R.raw.gimn_uk, R.raw.gimn_uk, R.raw.gimn_uk};
    int[] imgId = {R.drawable.fl_uk, R.drawable.fl_ru, R.drawable.fl_gb};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        int[] resID = {R.raw.gimn_uk, R.raw.gimn_uk, R.raw.gimn_uk};
//        int[] imgId = {R.drawable.fl_uk, R.drawable.fl_ru, R.drawable.fl_gb};
        mediaPlayer = MediaPlayer.create(this, resID[0]);
        //mediaPlayer = MediaPlayer.create(this, R.raw.gimn_uk);
        imgButton = (ImageButton) findViewById(R.id.imgBtn);


//        final Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                showToast("");
//                mediaPlayer.start();
//            }
//        });
//        final ImageButton imgButton = (ImageButton) findViewById(R.id.imgBtn);
        imgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showToast(imgButton.getDrawable().toString()+" ");
//                mediaPlayer.start();
                imgButton.setBackgroundResource(imgId[2]);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {

    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
