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

import java.nio.CharBuffer;
import java.util.ArrayList;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.MyViewHolder> {
    ArrayList image;
    ArrayList name;
    Context context;
    public ComputerAdapter(Context context, ArrayList image, ArrayList name)
    {
        this.context = context;
        this.image = image;
        this.name = name;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycle_view_list, viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {
        myViewHolder.textView.setText((CharSequence)name.get(position));
        myViewHolder.imageView.setImageResource((Integer) image.get(position));
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0)
                {
                    Intent c = new Intent(Intent.ACTION_VIEW);
                    c.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/c.pdf?alt=media&token=311451a0-3c0b-46e3-bae8-496fc0bc0990"));
                    context.startActivity(c);
                }
                if (position==1)
                {
                    Intent advance = new Intent(Intent.ACTION_VIEW);
                    advance.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/advancec.pdf?alt=media&token=7c484ede-bea4-4f87-a5fe-9bf57025eea2"));
                    context.startActivity(advance);
                }
                if (position==2)
                {
                    Intent java = new  Intent(Intent.ACTION_VIEW);
                    java.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/java.pdf?alt=media&token=1b033352-dae8-4adf-bc87-9b289d6d558f"));
                    context.startActivity(java);
                }
                if (position==3)
                {
                    Intent android = new Intent(Intent.ACTION_VIEW);
                    android.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/android.pdf?alt=media&token=562b17a2-5dfa-4df7-8496-a8813cc9fcc4"));
                    context.startActivity(android);
                }
                if (position==4)
                {
                    Intent network = new Intent(Intent.ACTION_VIEW);
                    network.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/networking.pdf?alt=media&token=ca30b9bb-0efd-42b7-b76b-553cb8e18a98"));
                    context.startActivity(network);
                }
                if (position==5)
                {
                    Intent php = new Intent(Intent.ACTION_VIEW);
                    php.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/php.pdf?alt=media&token=92410b67-ba15-4715-b9d4-afb05371e1c5"));
                    context.startActivity(php);
                }
                if (position==6)
                {
                    Intent python = new Intent(Intent.ACTION_VIEW);
                    python.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/Python.pdf?alt=media&token=8c9454b5-c140-4cfd-a81e-96274c5577b4"));
                    context.startActivity(python);
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
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_views);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
