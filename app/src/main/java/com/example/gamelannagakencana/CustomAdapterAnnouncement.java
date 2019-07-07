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
import android.content.Intent;

import java.util.ArrayList;

public class CustomAdapterAnnouncement extends ArrayAdapter {
    private ArrayList<AnnouncementClass> alannouncement;
    private Context context;



    public CustomAdapterAnnouncement(@NonNull Context context, int resource, @NonNull ArrayList<AnnouncementClass> objects) {
        super(context, resource, objects);

        alannouncement = objects;
        this.context = context;
    }

    public static class ViewHolder{
        private TextView tvTitle, tvDesc, tvMore;
        private ImageView img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_list_announcement, parent, false);
        holder.tvTitle = convertView.findViewById(R.id.textViewAnnTitle);
        holder.tvDesc = convertView.findViewById(R.id.textViewAnnDesc);
        holder.tvMore = convertView.findViewById(R.id.textViewMore);
        holder.img = convertView.findViewById(R.id.imageViewAnnouncement);

        final AnnouncementClass currentAnnouncement = alannouncement.get(position);

        holder.tvTitle.setText(currentAnnouncement.getTitle());
        holder.tvDesc.setText(String.valueOf(currentAnnouncement.getDesc()));
        holder.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AnnouncementInfoActivity.class);
                intent.putExtra("titleAnn", currentAnnouncement.getTitle());
                intent.putExtra("descAnn", currentAnnouncement.getDesc());
                intent.putExtra("imageAnn", currentAnnouncement.getImageview());
                context.startActivity(intent);
            }
        });
        holder.img.setImageResource(currentAnnouncement.getImageview());

        return convertView;


    }
}
