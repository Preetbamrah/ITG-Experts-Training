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

public class MotivationalVideoActivity extends AppCompatActivity {
VideoView videoView;
ListView listView;
ArrayAdapter adapter;
ArrayList<String> videoList;
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivational_video);
        listView = findViewById(R.id.video_list_view);
        toolbar = findViewById(R.id.motivational_toolbar);
        videoView = findViewById(R.id.video_view);
        videoList = new ArrayList<>();

        
        videoList.add("Power of Focus");
        videoList.add("Success Dreams");
        videoList.add("No Money");
        videoList.add("Don't Underestimate Yourself");
        videoList.add("Apna Andar ke Dar ko Jeeto");
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final ProgressDialog progressDialog = new ProgressDialog(MotivationalVideoActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                switch (position)
                {
                    case 0:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/1.mp4?alt=media&token=5ffa8e95-78cf-47a9-a830-6fbda122a47b"));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/2.mp4?alt=media&token=6faa38ef-fa4e-4976-bd54-84d4970c417e"));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/3.mp4?alt=media&token=e5bf3b8a-7fe7-454d-a11c-e053b0fbbf96"));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/4.mp4?alt=media&token=c3695196-4f23-42c3-a69c-95fb1e9fba7f"));
                        break;
                    case 4:
                        videoView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/5.mp4?alt=media&token=e01111f2-848a-4d00-8053-f252326eb38b"));
                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(MotivationalVideoActivity.this));
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
