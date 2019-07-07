package com.example.gamelannagakencana;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class SongFragment extends Fragment {

    Button btnPelog, btnSlendro;
    ListView lvPelog, lvSlendro;
    ArrayList<String> alPelog, alSlendro, alName, alType;
    ArrayList<Integer> alImage;
    ArrayAdapter<String> aaPelog, aaSlendro;
    DatabaseHelper myDB;
    String name, type;
    int resID;
    SongClass songs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_song, container, false);
        myDB = new DatabaseHelper(getContext());
        Cursor cursor = myDB.getListContentsSong();

        btnPelog = view.findViewById(R.id.buttonPelogSongs);
        btnSlendro = view.findViewById(R.id.buttonSlendroSongs);
        lvPelog = view.findViewById(R.id.lvPelogSongs);
        lvSlendro = view.findViewById(R.id.lvSlendroSongs);
        lvPelog.setVisibility(view.GONE);
        lvSlendro.setVisibility(view.GONE);

        alPelog = new ArrayList<String>();

        alSlendro = new ArrayList<String>();

        for (cursor.move(0); cursor.moveToNext(); cursor.isAfterLast()){
            String name = cursor.getString(1);
            String type = cursor.getString(2);
            String image = cursor.getString(3);
            resID = getResources().getIdentifier(image, "drawable", getActivity().getPackageName());
            songs = new SongClass(name, type,resID);

            if(type.equals("Slendro")){
                alSlendro.add(name);
                alName.add(name);
                alType.add(type);
                alImage.add(resID);
                aaSlendro = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, alSlendro);
                lvSlendro.setAdapter(aaSlendro);
            }else if(type.equals("Pelog")){
                alPelog.add(name);
                aaPelog = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, alPelog);
                lvPelog.setAdapter(aaPelog);
            }



        }

        btnPelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lvPelog.getVisibility() == View.GONE){
                    lvPelog.setVisibility(View.VISIBLE);
                }else{
                    lvPelog.setVisibility(View.GONE);
                }
            }
        });

        btnSlendro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lvSlendro.getVisibility() == View.GONE){
                    lvSlendro.setVisibility(View.VISIBLE);
                }else{
                    lvSlendro.setVisibility(View.GONE);
                }
            }
        });



        lvSlendro.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getActivity(), ViewSongActivity.class);
                for(int k = 0; k < alName.size(); k++){
                    if (alName.get(k) == name){
                        intent.putExtra("nameSlendro", k);
                        intent.putExtra("imageSlendro", resID);
                    }
                }
                startActivity(intent);
            }
        });

        return view;
    }

    void pelogSongs(){
        alPelog.add("Ladrang Sumyar");
        alPelog.add("Lancaran Gandhes");
        alPelog.add("Dolanan Kupu-Kuwi");
    }

    void slendroSongs(){
        alSlendro.add("Sembung Gilang");
        alSlendro.add("Ayak-Ayakan");
        alSlendro.add("Singanebah");
    }



}
