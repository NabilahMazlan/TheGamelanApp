package com.example.gamelannagakencana;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.GestureDetector;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String GAMELANNAGAKENCANA = "gnk.db";

    //For creating announcement table
    public static final String ANNOUNCEMENT_TABLE = "announcement_data";
    public static final String ANNOUNCEMENT_ID = "announcement_id";
    public static final String ANNOUNCEMENT_TITLE = "announcement_title";
    public static final String ANNOUNCEMENT_DESCRIPTION = "announcement_description";
    public static final String ANNOUNCEMENT_IMAGE = "announcement_image";

    //For creating songs table
    public static final String SONG_TABLE = "song_data";
    public static final String SONG_ID = "song_id";
    public static final String SONG_NAME = "song_name";
    public static final String SONG_TYPE = "song_type";
    public static final String SONG_IMAGE = "song_image";

    public DatabaseHelper(Context context) {
        super(context, GAMELANNAGAKENCANA, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createAnnouncementTable = "CREATE TABLE " + ANNOUNCEMENT_TABLE + "("
                + ANNOUNCEMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ANNOUNCEMENT_TITLE + " TEXT, "
                + ANNOUNCEMENT_DESCRIPTION + " TEXT, " +
                ANNOUNCEMENT_IMAGE + " TEXT )";
        sqLiteDatabase.execSQL(createAnnouncementTable);
        sqLiteDatabase.execSQL("INSERT INTO announcement_data (announcement_title, announcement_description, announcement_image) VALUES ('GNK Open Class', 'Come down now to learn more about Gamelan and get a hands on experience!\n 12 July 2019\nSaturday 9am - 1pm', 'openclass');");
        sqLiteDatabase.execSQL("INSERT INTO announcement_data (announcement_title, announcement_description, announcement_image) VALUES ('NGAYAH – A DEDICATION OF HEART & SOUL ', 'NGAYAH – the act of volunteerism; participating and contributing to various activities, without any expectations of requite. Through this virtue, Gamelan Singamurti gather, devoting our time to create music. By giving back to the society, Gamelan Singamurti presents to you Ngayah, an hour of traditional Balinese music and dance performance. This showcase is in collaboration with a local community dance group Eka Swara Santhi and Gamelan Pinda Sari from Bali.\n30 March 2019\nSaturday 6pm', 'ngayah');");
        sqLiteDatabase.execSQL("INSERT INTO announcement_data (announcement_title, announcement_description, announcement_image) VALUES ('Country of Origin ', 'Comes from Indonesia', 'openclass');");

        String createSongTable = "CREATE TABLE " + SONG_TABLE + "("
                + SONG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SONG_NAME + " TEXT, "
                + SONG_TYPE + " TEXT, " +
                SONG_IMAGE + " TEXT )";
        sqLiteDatabase.execSQL(createSongTable);
        sqLiteDatabase.execSQL("INSERT INTO song_data (song_name , song_type, song_image) VALUES ('Ladrang SUMYAR', 'Pelog', 'sumyar_song');");
        sqLiteDatabase.execSQL("INSERT INTO song_data (song_name , song_type, song_image) VALUES ('Lancaran Gandhes', 'Pelog', 'gandhes_song');");
        sqLiteDatabase.execSQL("INSERT INTO song_data (song_name , song_type, song_image) VALUES ('Dolanan Kupu-Kuwi', 'Pelog', 'kupukuwi_song');");
        sqLiteDatabase.execSQL("INSERT INTO song_data (song_name , song_type, song_image) VALUES ('Bubaran Sembung Gilang', 'Slendro', 'sembung_gilang');");
        sqLiteDatabase.execSQL("INSERT INTO song_data (song_name , song_type, song_image) VALUES ('Srepeg Kembang Kapas', 'Slendro', 'kembang_kapas');");
        sqLiteDatabase.execSQL("INSERT INTO song_data (song_name , song_type, song_image) VALUES ('Lancaran/Bubaran Udan Mas', 'Slendro', 'udan_mas');");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + ANNOUNCEMENT_TABLE);
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS " + SONG_TABLE);

        onCreate(sqLiteDatabase);

    }

    //To display all items in announcement table
    public Cursor getListContentsAnnouncement(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataAbout = db.rawQuery("SELECT * FROM " + ANNOUNCEMENT_TABLE, null);
        return dataAbout;
    }

    //To display all items in song table
    public Cursor getListContentsSong(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor dataAbout = db.rawQuery("SELECT * FROM " + SONG_TABLE, null);
        return dataAbout;
    }

//    public ArrayList<SongClass> getAllNotes(String keyword) {
//        ArrayList<SongClass> notes = new ArrayList<SongClass>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns= {SONG_ID, SONG_NAME};
//        String condition = SONG_NAME + " Like ?";
//        String[] args = { "%" +  keyword + "%"};
//        Cursor cursor = db.query(SONG_TABLE, columns, condition, args,
//                null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(0);
//                String songContent = cursor.getString(1);
//                SongClass song = new SongClass(songContent);
//                notes.add(song);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return notes;
//    }
}
