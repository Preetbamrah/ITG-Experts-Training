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

public class ArrayListAdapter extends RecyclerView.Adapter<ArrayListAdapter.ArrayViewHolder> {
    ArrayList name;
    ArrayList image;
    Context context;

    public ArrayListAdapter(Context context, ArrayList image,ArrayList name)
    {
        this.context = context;
        this.name = name;
        this.image = image;
    }
    @NonNull
    @Override
    public ArrayViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycle_view_list, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        ArrayViewHolder vh = new ArrayViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArrayViewHolder arrayViewHolder,final int position) {
        arrayViewHolder.name_txt.setText((CharSequence) name.get(position));
        arrayViewHolder.image_view.setImageResource((Integer) image.get(position));
        // implement setOnClickListener event on item view.
        arrayViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                if (position==0)
                {
                    Intent autocad = new Intent(Intent.ACTION_VIEW);
                    autocad.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/autocad.pdf?alt=media&token=61830da5-bb39-4377-8d8f-7f1a1600d568"));
                    context.startActivity(autocad);
                }
                if (position==1)
                {
                    Intent catia = new Intent(Intent.ACTION_VIEW);
                    catia.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/catia.pdf?alt=media&token=86153925-f356-4da0-ba50-630de227f5b1"));
                    context.startActivity(catia);
                }
                if (position==2)
                {
                    Intent nx = new Intent(Intent.ACTION_VIEW);
                    nx.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/nxcam.pdf?alt=media&token=bf362583-a704-44f7-b240-da0f3344b196"));
                    context.startActivity(nx);
                }
                if (position==3)
                {
                    Intent solid = new Intent(Intent.ACTION_VIEW);
                    solid.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/solidword.pdf?alt=media&token=8af14570-d4a4-4d89-bafa-6f091c272c59"));
                    context.startActivity(solid);
                }
                if (position==4)
                {
                    Intent cnc = new Intent(Intent.ACTION_VIEW);
                    cnc.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/cnc.pdf?alt=media&token=f40d6c2b-48d6-4458-ac82-f1e1c3c9ea90"));
                    context.startActivity(cnc);
                }

                /*Intent intent = new Intent(context,NextActivity.class);
                intent.putExtra("image", (Integer) image.get(position)); // put image data in Intent
                context.startActivity(intent); */// start Intent
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ArrayViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView name_txt;
        public ArrayViewHolder(@NonNull View itemView) {
            super(itemView);
            name_txt = (TextView) itemView.findViewById(R.id.text);
            image_view= (ImageView) itemView.findViewById(R.id.image_views);
        }
    }
}
