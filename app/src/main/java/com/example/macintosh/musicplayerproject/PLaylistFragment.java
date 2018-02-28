package com.example.macintosh.musicplayerproject;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PLaylistFragment extends Fragment {

    private List<PlayList> playListArrayList;
    private PlayListAdapter itemsAdapter;
    private ListView listView;


    public PLaylistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_playlist, container, false);
        int backgroundcolour = R.color.playlist;

        playListArrayList = ((MusicPlayerApplication) getActivity().getApplication()).getPlaylist();

        Log.v("ONCREATE", "THIS IS CREATEd");

        listView =  rootView.findViewById(R.id.listviewPlaylistActivity);

        itemsAdapter = new PlayListAdapter(getActivity(),playListArrayList, backgroundcolour);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ChildPlaylistActivity.class);
                intent.putExtra("PlaylistName", playListArrayList.get(i).getPlaylistName());

                startActivity(intent);
            }
        });


        FloatingActionButton fab =  rootView.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

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

        return rootView;
    }

}
