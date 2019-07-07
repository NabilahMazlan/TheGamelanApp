package com.example.gamelannagakencana;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterVideo extends ArrayAdapter{

    private ArrayList<Video> alVideo;
    private Context context;
    private TextView tvTitle, tvGroup, tvTimeline;
    private ImageView imgThumbnail;


    public CustomAdapterVideo(@NonNull Context context, int resource, @NonNull ArrayList<Video> objects) {
        super(context, resource, objects);

        alVideo = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_list_video, parent, false);
        tvTitle = convertView.findViewById(R.id.textViewVideoTitle);
        tvGroup = convertView.findViewById(R.id.textViewVideoGroup);
        tvTimeline = convertView.findViewById(R.id.textViewVideoTime);
        imgThumbnail = convertView.findViewById(R.id.imageViewVideoView);

        Video currentVideo = alVideo.get(position);

        tvGroup.setText(currentVideo.getGroup());
        tvTimeline.setText(String.valueOf(currentVideo.getTimeline()));
        tvTitle.setText(currentVideo.getTitle());
        imgThumbnail.setImageResource(currentVideo.getImage());

        return convertView;


    }
}
