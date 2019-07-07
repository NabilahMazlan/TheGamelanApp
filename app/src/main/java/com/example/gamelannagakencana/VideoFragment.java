package com.example.gamelannagakencana;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;
import java.util.ArrayList;
import android.content.Intent;


public class VideoFragment extends Fragment {

    ListView lvVideo;
    ArrayList<Video> alVideo ;
    ArrayAdapter aaVideo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        lvVideo = view.findViewById(R.id.listviewVideos);
        alVideo = new ArrayList<Video>();
        allVideos();
        aaVideo = new CustomAdapterVideo(getContext(), R.layout.custom_list_video, alVideo);
        lvVideo.setAdapter(aaVideo);
        aaVideo.notifyDataSetChanged();

        lvVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), VideoDisplay.class);
                intent.putExtra("title", alVideo.get(i).getTitle());
                startActivity(intent);
            }
        });


        return view;
    }

    void allVideos(){

        alVideo.add(new Video(R.drawable.gnk_rampak,"GNK Rampak",  "Gamelan Naga Kencana", 4.23));
        alVideo.add(new Video(R.drawable.gnk_rampak,"GNK Rampak",  "Gamelan Naga Kencana", 4.23));
        alVideo.add(new Video(R.drawable.gnk_rampak,"GNK Rampak",  "Gamelan Naga Kencana", 4.23));

    }

}
