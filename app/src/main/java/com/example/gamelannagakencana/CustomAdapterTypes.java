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

public class CustomAdapterTypes extends ArrayAdapter {

    private ArrayList<TypesClass> types;
    private Context context;
    private TextView tvName;
    private ImageView img;

    public CustomAdapterTypes(@NonNull Context context, int resource, @NonNull ArrayList<TypesClass> objects) {
        super(context, resource, objects);

        types = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_lv_types, parent, false);
        tvName = convertView.findViewById(R.id.textViewTypes);
        img = convertView.findViewById(R.id.imageViewTypes);

        TypesClass type = types.get(position);

        tvName.setText(type.getTxt());
        if(type.getTxt() == "Balinese Gamelan Set"){
            img.setImageResource(R.drawable.bali_gamelan);
        }else if(type.getTxt() == "Sundanese Gamelan Set"){
            img.setImageResource(R.drawable.sunda_gamelan);
        }else if(type.getTxt() == "Javanese Gamelan Set"){
            img.setImageResource(R.drawable.gamelan_java);
        }

        return convertView;


    }
}
