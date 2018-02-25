package com.example.macintosh.musicplayerproject;

import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlaySongActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    String songname, artist;
    private ImageView playBtn;
    private ImageView stopBtn;
    private ImageView pauseBtn;
    private int audiofile;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();
        }
    };



    private SeekBar seekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        Log.v("CREATE","Activity created");
        Bundle extras = getIntent().getExtras();
        if(extras == null) return;

        songname = extras.getString("SongName");
        artist = extras.getString("ArtistName");
        audiofile = extras.getInt("audiofile");
        mediaPlayer = MediaPlayer.create(PlaySongActivity.this,audiofile);

        seekbar = findViewById(R.id.seekbar);
        seekbar.setClickable(false);


        playBtn = findViewById(R.id.playBtn);
        stopBtn = findViewById(R.id.stopBtn);
        pauseBtn = findViewById(R.id.pauseBtn);

        TextView songTitle = findViewById(R.id.songnametxtViewAPS);
        TextView artistNameTV = findViewById(R.id.artistNameTextViewAPS);

        songTitle.setText(songname);
        artistNameTV.setText(artist);



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

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.v("OnPostResume", "Resume playback");

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


                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();

                }

                else{
                    mediaPlayer.release();
                    mediaPlayer = MediaPlayer.create(PlaySongActivity.this,audiofile);
                    mediaPlayer.start();
                }
//
                Snackbar.make(view, "Now Playing: "+ songname+ " by " + artist, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                mediaPlayer.setOnCompletionListener(onCompletionListener);
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

        @Override
    protected void onPause() {
        super.onPause();
        Log.v("OnStop","Stopped playback");
        releaseMediaPlayer();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v("STARTED","Playback start");

        Toast.makeText(this, ""+(float)mediaPlayer.getDuration()/60000, Toast.LENGTH_SHORT).show();
    }




}
