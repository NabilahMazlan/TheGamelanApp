package com.example.gamelannagakencana;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.content.Intent;

import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Random;

public class VideoDisplay extends AppCompatActivity {
    VideoView vv;
    TextView tvTitle, tvCommentHeader;
    ListView lvComments;
    EditText etComment;
    Button btnComment;
    MediaController mc;
    ArrayList<CommentClass> alComments;
    ArrayAdapter arrayAdapter;
    final int min = 0;
    final int max = 200;
    final int random = new Random().nextInt((max - min ) + 1) + min;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_display);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportActionBar().hide();
        }
        vv = findViewById(R.id.videoView);
        tvTitle = findViewById(R.id.textViewVideoViewTitle);
        lvComments = findViewById(R.id.listViewVideoViewComments);
        tvCommentHeader = findViewById(R.id.textViewComment);
        etComment = findViewById(R.id.editTextComment);
        btnComment = findViewById(R.id.buttonPostComment);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        tvTitle.setText(title);
        String videoPath = "android.resource://com.example.gamelannagakencana/" + R.raw.gnk_rampak_video;
        Uri uri = Uri.parse(videoPath);
        vv.setVideoURI(uri);
        vv.pause();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.LinearLayout.LayoutParams params = (android.widget.LinearLayout.LayoutParams) vv.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;
        vv.setLayoutParams(params);

        vv.start();

        alComments = new ArrayList<>();
        commentaries();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alComments);
        lvComments.setAdapter(arrayAdapter);
        tvCommentHeader.setText("Comment " + lvComments.getAdapter().getCount());

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alComments.add(new CommentClass("annonymous" + random , etComment.getText().toString()));
                etComment.setText("");
            }
        });

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mc = new MediaController(VideoDisplay.this);
                        vv.setMediaController(mc);
                        mc.setAnchorView(vv);

                    }
                });
            }
        });
        int pos = 0;
        if(savedInstanceState != null){
            pos = savedInstanceState.getInt("pos");
        }

        vv.seekTo(pos);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(vv.isPlaying()){
            outState.putInt("pos",vv.getCurrentPosition());
        }
    }

    void commentaries(){
        alComments.add(new CommentClass("annonymous111" , "They are good"));
        alComments.add(new CommentClass("annonymous112" , "They are good"));
        alComments.add(new CommentClass("annonymous113" , "They are good"));

    }
}
