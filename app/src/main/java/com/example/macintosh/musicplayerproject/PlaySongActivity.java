package com.example.macintosh.musicplayerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PlaySongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);


        ImageView skipPreviousButton = findViewById(R.id.skipPreviousBtn);
        ImageView skipNextButton = findViewById(R.id.skipNextBtn);
        ImageView playBtn = findViewById(R.id.playBtn);
        ImageView stopBtn = findViewById(R.id.stopBtn);
        ImageView pauseBtn = findViewById(R.id.pauseBtn);

        skipNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              skip to the next media
            }
        });

        skipPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//           skip to previous media
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                pause the media
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                play the media
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop the media
            }
        });

    }
}
