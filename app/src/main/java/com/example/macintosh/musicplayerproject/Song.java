package com.example.macintosh.musicplayerproject;

/**
 * Created by macintosh on 24/02/2018.
 */

public class Song {
    private String name;
    private String artistName;
    private boolean isPlaying;
    private int songLength;

    public Song(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
    }

    public String getSongName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setStatusSong(boolean isplaying){
        this.isPlaying = isplaying;
    }
}
