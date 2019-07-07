package com.example.gamelannagakencana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnnouncementInfoActivity extends AppCompatActivity {
    TextView tvTitle, tvDesc;
    ImageView imgInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_info);
        tvTitle = findViewById(R.id.textViewAnnInfoTitle);
        tvDesc = findViewById(R.id.textViewAnnInfoDesc);
        imgInfo = findViewById(R.id.imageViewAnnInfo);

        Intent intent = getIntent();
        String title = intent.getStringExtra("titleAnn");
        String desc = intent.getStringExtra("descAnn");
        int image = intent.getIntExtra("imageAnn", 0);

        tvTitle.setText(title);
        tvDesc.setText(desc);
        imgInfo.setImageResource(image);
    }
}
