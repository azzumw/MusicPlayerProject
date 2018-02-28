package com.example.macintosh.musicplayerproject;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by macintosh on 27/02/2018.
 */

public class MusicPlayerApplication extends Application {

    private Map<String, PlayList> playlistMap;

    @Override
    public void onCreate() {
        super.onCreate();
        playlistMap = new HashMap<>();

        Song wayOfTearsSong = new Song("The Way Of Tears", "Muhammad Al Muqit", R.raw.thewayoftears);
        Song yaIlahiSong = new Song("Ya ilahi", "Ishaq Ayubi", R.raw.yaillahi);
        Song soldiersOfAllah = new Song("Soldiers of Allah", "Muhammad Al Muqit", R.raw.soldiersofallah);
        Song tabalagho = new Song("Tabalagho Bil Qaleel", "Oussama Al-Safi", R.raw.tabalagho);
        Song yanabi = new Song("Ya Nabi Salaam Alaika", "Mahir Zain", R.raw.yanabisalaam);
        Song lightning =new Song("The Lightning", "Muhammad Al Muqit", R.raw.lightning);
        Song laislabonita = new Song("La Isla Bonita","Madona",R.raw.laislabonita);
        Song moonriver = new Song("Moon River","Chanelle/Bxjamin",R.raw.moonriver);

        playlistMap.put("Muhammad Al Muqit", new PlayList("Muhammad Al Muqit", Arrays.asList(wayOfTearsSong,soldiersOfAllah, lightning)));
        playlistMap.put("Mahir Zain", new PlayList("Mahir Zain",Arrays.asList(yanabi)));
        playlistMap.put("Madona", new PlayList("Madona",Arrays.asList(laislabonita)));
        playlistMap.put("Chanelle/Bxjamin", new PlayList("Chanelle/Bxjamin",Arrays.asList(moonriver)));
        playlistMap.put("Oussama Al-Safi", new PlayList("Oussama Al-Safi",Arrays.asList(tabalagho)));
    }

    public Map<String, PlayList> getPlaylistMap() {
        return playlistMap;
    }

    public List<PlayList> getPlaylist() {
        Collection<PlayList> playlistCollection = playlistMap.values();
        return new ArrayList<>(playlistCollection);
    }
}
