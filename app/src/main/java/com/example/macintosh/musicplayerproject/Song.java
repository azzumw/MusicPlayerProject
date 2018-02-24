package com.example.macintosh.musicplayerproject;

/**
 * Created by macintosh on 24/02/2018.
 */

public class Song {
    private String name;
    private String artistName;
    private boolean isPlaying;
    private int songLength;
    private int audioResourceID;

    public Song(String name, String artistName,int audioResourceID) {
        this.name = name;
        this.artistName = artistName;
        this.audioResourceID = audioResourceID;
    }

    public String getSongName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getAudioResourceID() {
        return audioResourceID;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setStatusSong(boolean isplaying){
        this.isPlaying = isplaying;
    }
}
