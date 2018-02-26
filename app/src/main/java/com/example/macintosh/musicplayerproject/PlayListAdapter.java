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
 * Created by macintosh on 25/02/2018.
 */

public class PlayListAdapter<P> extends ArrayAdapter<PlayList> {
    public PlayListAdapter(@NonNull Context context, @NonNull ArrayList<PlayList> objects) {
        super(context, 0, objects);
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

        songnameTextView.setText(currentPlayList.getPlaylistName());
        artistnameTextView.setText(currentPlayList.getPlayListSize()+" Songs");
        return listItemView;
    }
}
