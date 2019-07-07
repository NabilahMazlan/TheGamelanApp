package com.example.gamelannagakencana;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ViewSongActivity extends AppCompatActivity {
    ImageView imgViewSongs;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_song);
        imgViewSongs = findViewById(R.id.imageViewDisplaySongs);
        myDB = new DatabaseHelper(this);
        Cursor cursor = myDB.getListContentsSong();

        SongClass song = new SongClass();
        Intent intent = getIntent();
        String nameSlendroIntent = intent.getStringExtra("nameSlendro");
        String typeSlendroIntent = intent.getStringExtra("typeSlendro");
        int imgSlendro = intent.getIntExtra("imageSlendro",0);

        imgViewSongs.setImageResource(imgSlendro);



    }
}
