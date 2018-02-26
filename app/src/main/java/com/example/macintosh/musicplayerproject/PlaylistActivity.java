package com.example.macintosh.musicplayerproject;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        final ArrayList<PlayList> playListArrayList = new ArrayList<>();
        playListArrayList.add(new PlayList("Madonna"));
        playListArrayList.add(new PlayList("Nasheeds"));

        final PlayListAdapter<PlayList> itemsAdapter = new PlayListAdapter<>(this,playListArrayList);

        ListView listView =  findViewById(R.id.listviewPlaylistActivity);

        listView.setAdapter(itemsAdapter);

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
                        playListArrayList.add(new PlayList(playListName));
                        itemsAdapter.notifyDataSetChanged();
                        dialogInterface.dismiss();

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
}
