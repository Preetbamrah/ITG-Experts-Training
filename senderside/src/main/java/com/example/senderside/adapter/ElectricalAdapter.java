package com.example.senderside.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senderside.R;

import java.util.ArrayList;

public class ElectricalAdapter extends RecyclerView.Adapter<ElectricalAdapter.MyViewHolder> {
    ArrayList images;
    ArrayList name;
    Context context;

    public ElectricalAdapter(Context context, ArrayList images, ArrayList name)
    {
        this.context = context;
        this.images = images;
        this.name =  name;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycle_view_list,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.textView.setText((CharSequence) name.get(position));
        myViewHolder.imageView.setImageResource((Integer)images.get(position));
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if (position==0)
                {
                    Intent network = new Intent(Intent.ACTION_VIEW);
                    network.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/networking.pdf?alt=media&token=ca30b9bb-0efd-42b7-b76b-553cb8e18a98"));
                    context.startActivity(network);
                }
                if(position==1)
                {
                    Intent plc = new Intent(Intent.ACTION_VIEW);
                    plc.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Basics_of_PLC_Programming.pdf?alt=media&token=6242c1bb-328e-4ffb-8bb5-b337877d6a61"));
                    context.startActivity(plc);
                }
                if (position==2)
                {
                    Intent mat = new Intent(Intent.ACTION_VIEW);
                    mat.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/matlab.pdf?alt=media&token=20698514-833e-4846-9cd0-e08e363355d3"));
                    context.startActivity(mat);
                }
                if (position==3)
                {
                    Intent embedded = new Intent(Intent.ACTION_VIEW);
                    embedded.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Embedded%20Systems%20Design.pdf?alt=media&token=17860f09-adf8-4c9f-86aa-cbb7c69013f3"));
                    /*embedded.putExtra("embedded ")*/
                    context.startActivity(embedded);
                }
                if (position==4)
                {
                    Intent tele = new Intent(Intent.ACTION_VIEW);
                    tele.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/telecom.pdf?alt=media&token=2a048513-8c84-4191-8ba6-2d09ff599d67"));
                    context.startActivity(tele);
                }
                if (position==5)
                {
                    Intent internet = new Intent(Intent.ACTION_VIEW);
                    internet.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/internet_of_things_tutorial.pdf?alt=media&token=0b000113-ccbc-4573-be8f-b9c7c229456d"));
                    context.startActivity(internet);
                }
                if (position==6)
                {
                    Intent robot = new Intent(Intent.ACTION_VIEW);
                    robot.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Intro2Robotics.pdf?alt=media&token=8102468a-fa04-4a1e-a9a0-4f4e07d34801"));
                    context.startActivity(robot);
                }
                if (position==7)
                {
                    Intent sap = new Intent(Intent.ACTION_VIEW);
                    sap.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/sap_tutorial.pdf?alt=media&token=eb1a4049-1e9b-4a98-9a3e-a254fd138bae"));
                    context.startActivity(sap);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_views);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
