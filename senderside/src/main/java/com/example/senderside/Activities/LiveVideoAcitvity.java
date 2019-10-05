package com.example.senderside.Activities;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.senderside.R;

import java.util.ArrayList;

public class LiveVideoAcitvity extends AppCompatActivity {
Toolbar toolbar;
VideoView videoView;
ListView listView;
ArrayAdapter<String> arrayAdapter;
ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_video_acitvity);
        toolbar = findViewById(R.id.live_toolbar);
        videoView = findViewById(R.id.live_video_view);
        listView = findViewById(R.id.live_list_view);

        arrayList = new ArrayList<>();
        arrayList.add("Live Project Control with Remote");
        arrayList.add("Live Project Control with Mobile Phone");
        arrayList.add("Live Project 3x3x3 LED Cube");

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final ProgressDialog progressDialog = new ProgressDialog(LiveVideoAcitvity.this);
                progressDialog.setMessage("Loading.....");
                progressDialog.setCancelable(false);
                progressDialog.show();
                switch (position)
                {
                    case 0:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/l1.mp4?alt=media&token=0d69dc1e-dcc6-48dd-825f-cefc16600016"));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/l2.mp4?alt=media&token=475f9887-6ba4-4d29-8b88-c719ac2f24c7"));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/l3.mp4?alt=media&token=7adc0f14-3028-4cd0-9bbe-4a957f906fe6"));
                        break;

                    default:
                            break;

                }
                videoView.setMediaController(new MediaController(LiveVideoAcitvity.this));
                videoView.requestFocus();
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        progressDialog.dismiss();
                        if (position==0)
                        {
                            videoView.start();
                        }
                    }
                });
            }
        });

    }
}
