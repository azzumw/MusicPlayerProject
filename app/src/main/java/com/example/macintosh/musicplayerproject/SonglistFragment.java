package com.example.macintosh.musicplayerproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SonglistFragment extends Fragment {

    private ArrayList<Song> songs = new ArrayList<>();

    public SonglistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_song_list, container, false);

        songs.add(new Song("The Way Of Tears","Muhammad Al Muqit",R.raw.thewayoftears));
        songs.add(new Song("Ya ilahi","Ishaq Ayubi",R.raw.yaillahi));
        songs.add(new Song("Soldiers of Allah","Muhammad Al Muqit",R.raw.soldiersofallah));
        songs.add(new Song("Tabalagho Bil Qaleel","Oussama Al-Safi",R.raw.tabalagho));
        songs.add(new Song("Ya Nabi Salaam Alaika","Mahir Zain",R.raw.yanabisalaam));
        songs.add(new Song("The Lightning","Muhammad Al Muqit",R.raw.lightning));
        songs.add(new Song("Moon River","Chanelle/Bxjamin",R.raw.moonriver));
        songs.add(new Song("La Isla Bonita","Madona",R.raw.laislabonita));

        SongAdapter<Song> itemsAdapter = new SongAdapter<Song>(getActivity(),songs);

        ListView listView =  rootView.findViewById(R.id.songlistactivity);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                releaseMediaPlayer();
                Intent intent = new Intent(getActivity(),PlaySongActivity.class);
                intent.putExtra("SongName",songs.get(i).getSongName());
                intent.putExtra("ArtistName",songs.get(i).getArtistName());
                intent.putExtra("audiofile",songs.get(i).getAudioResourceID());
                startActivity(intent);

            }
        });
        return rootView;
    }

}
