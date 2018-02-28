package com.example.macintosh.musicplayerproject;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macintosh on 25/02/2018.
 */

public class PlayList{

    private List<Song> songplaylist;
    private String playlistName;

    public PlayList(String playlistName) {
        this.songplaylist = new ArrayList<>();
        this.playlistName = playlistName;
    }

    public PlayList(String playlistName,
                    List<Song> songplaylist) {
        this.songplaylist = songplaylist;
        this.playlistName = playlistName;
    }

    public String getPlaylistName(){
        return this.playlistName;
    }

    public void addSong(Song song){
        songplaylist.add(song);
    }

    public Song getSong(int i){
        return songplaylist.get(i);
    }

    public List<Song> getSongplaylist(){
        return songplaylist;
    }

    public int getPlayListSize(){
        return songplaylist.size();
    }

}
