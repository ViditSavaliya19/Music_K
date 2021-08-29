package com.kee.vlmusic.Fragment;
import static com.kee.vlmusic.Home.jcPlayerView;
import static com.kee.vlmusic.Utils.Api.jcAudios;
import static com.kee.vlmusic.Utils.Api.musicList;

import android.app.ProgressDialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.jean.jcplayer.model.JcAudio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kee.vlmusic.ListAdapter;
import com.kee.vlmusic.R;
import com.kee.vlmusic.Song;
import com.kee.vlmusic.Utils.Api;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private boolean checkPermission = false;
    ProgressDialog progressDialog;
    ListView listView;
    List<String> songsNameList;
    List<String> songsUrlList;
    List<String> songsArtistList;
    List<String> songsDurationList;
    ListAdapter adapter;
//    JcPlayerView jcPlayerView;


    List<String> thumbnail;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_home, container, false);
        intiView(view);
        return view;
    }

    private void intiView(View view) {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.show();
        progressDialog.setMessage("Please Wait...");
        listView = view.findViewById(R.id.songsList);
        songsNameList = new ArrayList<>();
        songsUrlList = new ArrayList<>();
        songsArtistList = new ArrayList<>();
        songsDurationList = new ArrayList<>();
        thumbnail = new ArrayList<>();
//        jcPlayerView = view.findViewById(R.id.jcplayer);
        retrieveSongs();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), ""+jcAudios.get(i), Toast.LENGTH_SHORT).show();
                Log.e("Tag Click",""+jcAudios.get(i));
                jcPlayerView.playAudio(jcAudios.get(i));
                jcPlayerView.setVisibility(View.VISIBLE);
                jcPlayerView.createNotification();
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void retrieveSongs() {

        Api api=new Api(getActivity());
        api.Music();

        rv();
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Songs");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot ds : snapshot.getChildren()) {
//                    Song song = ds.getValue(Song.class);
//                    songsNameList.add(song.getSongName());
//                    songsUrlList.add(song.getSongUrl());
//                    songsArtistList.add(song.getSongArtist());
//                    songsDurationList.add(song.getSongDuration());
//                    thumbnail.add(song.getImageUrl());
//
//                    jcAudios.add(JcAudio.createFromURL(song.getSongName(), song.getSongUrl()));
//                }
//                adapter = new ListAdapter(getActivity().getApplicationContext(), songsNameList, thumbnail, songsArtistList, songsDurationList);
////                jcPlayerView.initPlaylist(jcAudios, null);
////                listView.setAdapter(adapter);
////                adapter.notifyDataSetChanged();
////                progressDialog.dismiss();
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getActivity(), "FAILED!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void rv() {
        Toast.makeText(getActivity(), ""+musicList.size(), Toast.LENGTH_SHORT).show();
        adapter = new ListAdapter(getActivity().getApplicationContext(), musicList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

}