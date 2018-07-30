package com.example.student.express;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class InfoActivity extends AppCompatActivity {
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int position= getIntent().getExtras().getInt("KEY");
        TextView allDescription = (TextView) findViewById(R.id.descript_info);
        ImageView imageInfo= (ImageView) findViewById(R.id.image_info);
        VideoView videoView= (VideoView) findViewById(R.id.video_info);
        final ImageView imageVideo = (ImageView) findViewById(R.id.image_video);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.rec_info);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        final int[] imageArray= DataProvider.getList().get(position).getImageArrayId();
        InfoAdapter infoAdapter = new InfoAdapter(this, imageArray, position);
        Product product = DataProvider.getList().get(position);
        imageVideo.setImageResource(imageArray[0]);
        //// TODO: 7/25/2018
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(infoAdapter);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(product.getVideoUrl()));
        videoView.start();
        allDescription.setText(product.getAllDescription());
        imageInfo.setImageResource(imageArray[0]);

        imageVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(InfoActivity.this, position);
                customDialog.show();
            }
        });


    }



}
