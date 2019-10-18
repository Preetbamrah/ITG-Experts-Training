package com.example.senderside.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senderside.Activities.BbaListData;
import com.example.senderside.Activities.CivilList;
import com.example.senderside.Activities.ComputerList;
import com.example.senderside.Activities.EclectricalList;
import com.example.senderside.Activities.MechanicalActivity;
import com.example.senderside.Activities.NextActivity;
import com.example.senderside.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList image;
    ArrayList name;
    Context context;
    public CustomAdapter(Context context, ArrayList image, ArrayList name) {
        this.context = context;
        this.image = image;
        this.name = name;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_items, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.name_txt.setText((CharSequence) name.get(position));
        myViewHolder.image_view.setImageResource((Integer) image.get(position));
        // implement setOnClickListener event on item view.
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                if (position==0)
                {
                    Intent mechanicalIntent = new Intent(context,MechanicalActivity.class);
                    mechanicalIntent.putExtra("image",(Integer)image.get(position));
                    context.startActivity(mechanicalIntent);
                }
                if (position==1)
                {
                    Intent intent = new Intent(context,ComputerList.class);
                    intent.putExtra("image", (Integer) image.get(position)); // put image data in Intent
                    context.startActivity(intent);
                }
                if (position==2)
                {
                    Intent electricalIntent = new Intent(context,EclectricalList.class);
                    electricalIntent.putExtra("image",(Integer)image.get(position));
                    context.startActivity(electricalIntent);
                }
                if (position==3)
                {
                    Intent bbaIntent = new Intent(context,BbaListData.class);
                    bbaIntent.putExtra("image",(Integer)image.get(position));
                    context.startActivity(bbaIntent);
                }
                if (position==4)
                {
                    Intent civilIntent = new Intent(context,CivilList.class);
                    civilIntent.putExtra("image",(Integer)image.get(position));
                    context.startActivity(civilIntent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView name_txt;
        ImageView image_view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt = (TextView) itemView.findViewById(R.id.name_text);
            image_view= (ImageView) itemView.findViewById(R.id.image_view);
        }
    }
}