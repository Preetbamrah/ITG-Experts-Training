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

public class CivilAdapter extends RecyclerView.Adapter<CivilAdapter.MyViewHolder> {
ArrayList image;
ArrayList name;
Context context;

    public CivilAdapter(Context context, ArrayList image, ArrayList name)
    {
        this.context = context;
        this.name  = name;
        this.image = image;
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
        myViewHolder.textView.setText((CharSequence)name.get(position));
        myViewHolder.imageView.setImageResource((Integer)image.get(position));
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if (position== 0)
                {
                    Intent autocad = new Intent(Intent.ACTION_VIEW);
                    autocad.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/autocad.pdf?alt=media&token=61830da5-bb39-4377-8d8f-7f1a1600d568"));
                    context.startActivity(autocad);
                }
                if (position==1)
                {
                    Intent staad = new Intent(Intent.ACTION_VIEW);
                    staad.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/staadpro.pdf?alt=media&token=c1eb36ef-824b-47d2-a694-4e22e348dab0"));
                    context.startActivity(staad);
                }
                if (position==2)
                {
                    Intent revit = new Intent(Intent.ACTION_VIEW);
                    revit.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/revit.pdf?alt=media&token=f96c7bd6-b07e-41a1-aa6c-1c3b2a952f27"));
                    context.startActivity(revit);
                }
                if (position==3)
                {
                    Intent ds = new Intent(Intent.ACTION_VIEW);
                    ds.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/ds.pdf?alt=media&token=8d962005-8fd5-432a-b866-5b7b15432904"));
                    context.startActivity(ds);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
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
