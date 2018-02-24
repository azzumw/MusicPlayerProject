package com.example.macintosh.musicplayerproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView playlistTV = findViewById(R.id.playlistTextView);
        TextView songlistTV = findViewById(R.id.songTextView);

        playlistTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(intent);
            }
        });

        songlistTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SongListActivity.class);
                startActivity(intent);
            }
        });
    }
}
