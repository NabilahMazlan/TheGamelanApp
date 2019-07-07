package com.example.gamelannagakencana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OriginActivity extends AppCompatActivity {
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_origin);
        tv2 = findViewById(R.id.textView2);
        tv2.setText("Gamelan is a traditional music ensemble which originates from Indonesia. Gamelan is mostly made out of percussive instruments. The common instruments" +
                "are generally made out of metallaphones and a set of hand played drums. Gamelan plays a huge role in Indonesia when it comes to their performing arts. Gamelan is almost seen everywhere in Indonesia. ");
    }
}
