package com.example.macintosh.musicplayerproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlaylistActivity extends AppCompatActivity {

     List<PlayList> playListArrayList;
     PlayListAdapter itemsAdapter;
     ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        int backgroundcolour = R.color.playlist;

        playListArrayList = ((MusicPlayerApplication) getApplication()).getPlaylist();

        Log.v("ONCREATE", "THIS IS CREATEd");

        listView =  findViewById(R.id.listviewPlaylistActivity);

        itemsAdapter = new PlayListAdapter(this,playListArrayList, backgroundcolour);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PlaylistActivity.this, ChildPlaylistActivity.class);
                intent.putExtra("PlaylistName", playListArrayList.get(i).getPlaylistName());

                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


        FloatingActionButton fab =  findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                final AlertDialog.Builder builder = new AlertDialog.Builder(PlaylistActivity.this);

                View mView = getLayoutInflater().inflate(R.layout.addplaylistdialogue,null);
                final EditText playlistET = mView.findViewById(R.id.editplaylistname);



                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String playListName = playlistET.getText().toString();
                        dialogInterface.dismiss();
                        playListArrayList.add(new PlayList(playListName));
                        itemsAdapter.notifyDataSetChanged();


                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                builder.setView(mView);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    public PlayList getPlaylistObject(int i){
        return playListArrayList.get(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("DESTROY","activity destroyed");
    }

    @Override
    protected void onPause() {
        super.onPause();

//        outState.putParcelable("KEY", listView.onSaveInstanceState());
        Log.v("Pause:","paused state");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelable("KEY", listView.onSaveInstanceState());

        outState.putString("SomeKey", "SomeValue");

        Log.v("ARRAY","save");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.containsKey("SomeKey")) {
            String value = savedInstanceState.getString("SomeKey");
            Log.v("VALUE", value);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("STOPPED:", "stopeed");
    }
}
