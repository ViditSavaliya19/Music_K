package com.kee.vlmusic.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kee.vlmusic.R;
import com.kee.vlmusic.UploadSongActivity;

public class SettingsFragment extends Fragment {

    private LinearLayout upload_music;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1=inflater.inflate(R.layout.fragment_settings, container, false);

        upload_music=view1.findViewById(R.id.upload_music);
        upload_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), UploadSongActivity.class));
            }
        });

        return view1;
    }
}