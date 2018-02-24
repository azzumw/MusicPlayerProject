package com.example.macintosh.musicplayerproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        ArrayList<Song> songs = new ArrayList<>();

        songs.add(new Song("The Way Of Tears","Muhammad Al Muqit"));
        songs.add(new Song("Ya ilahi","Ishaq Ayubi"));
        songs.add(new Song("Soldiers of Allah","Muhammad Al Muqit"));
        songs.add(new Song("Tabalagho Bil Qaleel","Oussama Al-Safi"));
        songs.add(new Song("Ya Nabi Salaam Alaika","Mahir Zain"));
        songs.add(new Song("The Lightning","Muhammad Al Muqit"));

        SongAdapter<Song> itemsAdapter = new SongAdapter<Song>(this,songs);

        ListView listView =  findViewById(R.id.songlistactivity);

        listView.setAdapter(itemsAdapter);
    }
}
