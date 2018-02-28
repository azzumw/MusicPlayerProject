package com.example.macintosh.musicplayerproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    private ArrayList<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);



        songs.add(new Song("The Way Of Tears","Muhammad Al Muqit",R.raw.thewayoftears));
        songs.add(new Song("Ya ilahi","Ishaq Ayubi",R.raw.yaillahi));
        songs.add(new Song("Soldiers of Allah","Muhammad Al Muqit",R.raw.soldiersofallah));
        songs.add(new Song("Tabalagho Bil Qaleel","Oussama Al-Safi",R.raw.tabalagho));
        songs.add(new Song("Ya Nabi Salaam Alaika","Mahir Zain",R.raw.yanabisalaam));
        songs.add(new Song("The Lightning","Muhammad Al Muqit",R.raw.lightning));
        songs.add(new Song("Moon River","Chanelle/Bxjamin",R.raw.moonriver));
        songs.add(new Song("La Isla Bonita","Madona",R.raw.laislabonita));

        SongAdapter<Song> itemsAdapter = new SongAdapter<Song>(this,songs);

        ListView listView =  findViewById(R.id.songlistactivity);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                releaseMediaPlayer();
                Intent intent = new Intent(SongListActivity.this,PlaySongActivity.class);
                intent.putExtra("SongName",songs.get(i).getSongName());
                intent.putExtra("ArtistName",songs.get(i).getArtistName());
                intent.putExtra("audiofile",songs.get(i).getAudioResourceID());
                startActivity(intent);

            }
        });
    }

    public Song getSong(int i){
        return songs.get(i);
    }

}
