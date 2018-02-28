package com.example.macintosh.musicplayerproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by macintosh on 25/02/2018.
 */

public class PlayListAdapter extends ArrayAdapter<PlayList> {

    private int backgroundColor;

    public PlayListAdapter(@NonNull Context context, @NonNull List<PlayList> objects, int backgroundColor) {
        super(context, 0, objects);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        PlayList currentPlayList = getItem(position);

        TextView songnameTextView =  listItemView.findViewById(R.id.songNameTextView);
        TextView artistnameTextView =  listItemView.findViewById(R.id.artistNameTextView);
        ImageView imageView =  listItemView.findViewById(R.id.imageView);
        View textContainerView = listItemView.findViewById(R.id.RelativeChildView);

        songnameTextView.setText(currentPlayList.getPlaylistName());
        artistnameTextView.setText(currentPlayList.getPlayListSize()+" Songs");

        int color = ContextCompat.getColor(getContext(),backgroundColor);
        textContainerView.setBackgroundColor(color);

        return listItemView;
    }
}
