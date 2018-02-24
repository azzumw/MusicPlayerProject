package com.example.macintosh.musicplayerproject;

/**
 * Created by macintosh on 24/02/2018.
 */

public class Song {
    private String name;
    private String artistName;

    public Song(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public String getArtistName() {
        return artistName;
    }
}
