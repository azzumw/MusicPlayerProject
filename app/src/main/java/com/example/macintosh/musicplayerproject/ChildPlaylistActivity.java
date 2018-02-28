package com.example.macintosh.musicplayerproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChildPlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        String playlistName = getIntent().getStringExtra("PlaylistName");


        PlayList playList = ((MusicPlayerApplication) getApplication()).getPlaylistMap().get(playlistName);

        final List<Song> playlistSongs = playList.getSongplaylist();



//            playlistSongs.add(playlistActivity.getPlaylistObject(0).getSong(0));
//            playlistSongs.add(playlistActivity.getPlaylistObject(0).getSong(2));
//            playlistSongs.add(playlistActivity.getPlaylistObject(0).getSong(5));

        SongAdapter<Song> itemsAdapter = new SongAdapter<>(ChildPlaylistActivity.this,playlistSongs);

        ListView listView = findViewById(R.id.listviewPlaylistActivity);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ChildPlaylistActivity.this,PlaySongActivity.class);
                intent.putExtra("SongName",playlistSongs.get(i).getSongName());
                intent.putExtra("ArtistName",playlistSongs.get(i).getArtistName());
                intent.putExtra("audiofile",playlistSongs.get(i).getAudioResourceID());
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

}
