package com.example.senderside.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senderside.R;

public class VideoDashboard extends Fragment implements View.OnClickListener {
private View view;
Toolbar toolbar;
Context context;
TextView live_text, motivational_text;
ImageView live_img, motivational_img;
 public  VideoDashboard()
 {

 }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video_dashboard, container, false);
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        live_text = view.findViewById(R.id.live_btn);
        live_img = view.findViewById(R.id.live_image);
        motivational_img = view.findViewById(R.id.motivational_image);
        toolbar = view.findViewById(R.id.video_toolbar);
        motivational_text = view.findViewById(R.id.motivational_video);
        live_text.setOnClickListener(this);
        motivational_text.setOnClickListener(this);
        return view;
    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.live_btn:
                Intent live = new Intent(getActivity(), LiveVideoAcitvity.class);
                startActivity(live);
                break;
            case R.id.motivational_video:
                Intent motivational = new Intent(getActivity(),MotivationalVideoActivity.class);
                startActivity(motivational);

        }
    }

}
