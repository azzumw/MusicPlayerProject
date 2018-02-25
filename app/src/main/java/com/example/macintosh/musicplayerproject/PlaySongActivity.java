package com.example.macintosh.musicplayerproject;

import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class PlaySongActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private double startTime = 0;
    private double finalTime = 0;

    private Handler myHandler = new Handler();
    public static int oneTimeOnly = 0;

    private SeekBar seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        Bundle extras = getIntent().getExtras();
        if(extras == null) return;

        String songname = extras.getString("SongName");
        String artist = extras.getString("ArtistName");
        final int audiofile= extras.getInt("audiofile");

        seekbar = findViewById(R.id.seekbar);
        seekbar.setClickable(false);


        ImageView playBtn = findViewById(R.id.playBtn);
        ImageView stopBtn = findViewById(R.id.stopBtn);
        final ImageView pauseBtn = findViewById(R.id.pauseBtn);

        TextView songTitle = findViewById(R.id.songnametxtViewAPS);
        TextView artistNameTV = findViewById(R.id.artistNameTextViewAPS);

        songTitle.setText(songname);
        artistNameTV.setText(artist);



        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                pause the media
                mediaPlayer.pause();
            }
        });

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                play the media
                if(mediaPlayer==null)
                    mediaPlayer = MediaPlayer.create(PlaySongActivity.this,audiofile);


                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }

                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
//                pauseBtn.setEnabled(true);
//                play.setEnabled(false);
            }
        });

        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop the media
                mediaPlayer.stop();
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

//            am.abandonAudioFocus(afChangeListener);

        }
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();

            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };


}
