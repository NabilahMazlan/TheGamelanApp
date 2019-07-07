package com.example.gamelannagakencana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.content.Intent;

public class OtherGamelanActivity extends AppCompatActivity {

    CardView cvGA, cvBronzage, cvDjoko, cvSingamurti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_gamelan);
        cvGA = findViewById(R.id.cardViewGA);
        cvBronzage = findViewById(R.id.cardViewBronzage);
        cvDjoko = findViewById(R.id.cardViewDjoko);
        cvSingamurti = findViewById(R.id.cardViewSingamurti);

        cvBronzage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherGamelanActivity.this, OtherGamelanDetailsActivity.class);
                intent.putExtra("image", R.drawable.bronzage_gamelan);
                intent.putExtra("description", "Founded in 2009 by a group of students from Lasalle College of the Arts, with their gamelan teacher, Joyce Teo, BronzAge Gamelan has grown to include gamelan music enthusiasts from other tertiary institutions as well as several freelance professional musicians. The ensemble also collaborates with local and regional musicians to create unique and original pieces of music. Since its inception, BronzAge Gamelan has performed at several overseas festivals such as the Shanghai International Children’s Theatre Festival (2009); the 15th Yogya Gamelan Festival (2010) and the Inaugural Gamelan Forum in Bangkok (2010), Hyderabad Writers' Festival (2016), as well as at various local events.");
                intent.putExtra("twitter", "NIL");
                startActivity(intent);
            }
        });

        cvGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherGamelanActivity.this, OtherGamelanDetailsActivity.class);
                startActivity(intent);
            }
        });

        cvDjoko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherGamelanActivity.this, OtherGamelanDetailsActivity.class);
                startActivity(intent);
            }
        });

        cvSingamurti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OtherGamelanActivity.this, OtherGamelanDetailsActivity.class);
                startActivity(intent);
            }
        });


    }
}
