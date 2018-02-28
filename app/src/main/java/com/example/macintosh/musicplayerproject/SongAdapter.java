package com.example.macintosh.musicplayerproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macintosh on 24/02/2018.
 */

public class SongAdapter<S> extends ArrayAdapter<Song> {

    public SongAdapter(@NonNull Context context, @NonNull List<Song> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Song currentSong = getItem(position);

        TextView songnameTextView = (TextView) listItemView.findViewById(R.id.songNameTextView);
        TextView artistnameTextView = (TextView) listItemView.findViewById(R.id.artistNameTextView);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);

        songnameTextView.setText(currentSong.getSongName());
        artistnameTextView.setText(currentSong.getArtistName());

        return listItemView;


    }
}
