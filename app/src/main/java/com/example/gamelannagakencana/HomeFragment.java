package com.example.gamelannagakencana;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    ListView lvAnnouncement;
    ArrayList<AnnouncementClass> alAnnouncement ;
    ArrayAdapter aaAnnouncement;
    DatabaseHelper myDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        lvAnnouncement = view.findViewById(R.id.listViewAnnouncement);
        myDB = new DatabaseHelper(getContext());
        Cursor cursor = myDB.getListContentsAnnouncement();
        alAnnouncement = new ArrayList<AnnouncementClass>();
        for (cursor.move(0); cursor.moveToNext(); cursor.isAfterLast()){
            String title = cursor.getString(1);
            String desc = cursor.getString(2);
            String image = cursor.getString(3);
            int resID = getResources().getIdentifier(image, "drawable", getActivity().getPackageName());

            AnnouncementClass item = new AnnouncementClass(resID, title, desc);
            alAnnouncement.add(item);
            aaAnnouncement = new CustomAdapterAnnouncement(getContext(), R.layout.custom_list_announcement, alAnnouncement);

            lvAnnouncement.setAdapter(aaAnnouncement);
            aaAnnouncement.notifyDataSetChanged();
        }




        return view;
    }

}
