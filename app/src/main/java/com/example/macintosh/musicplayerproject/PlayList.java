package com.example.macintosh.musicplayerproject;

import java.util.ArrayList;

/**
 * Created by macintosh on 25/02/2018.
 */

public class PlayList {
    private ArrayList<Song> songplaylist;
    private String playlistName;

    public PlayList(String playlistName) {
        this.songplaylist = new ArrayList<>();
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

    public ArrayList<Song> getSongplaylist(){
        return songplaylist;
    }

    public int getPlayListSize(){
        return songplaylist.size();
    }
}
