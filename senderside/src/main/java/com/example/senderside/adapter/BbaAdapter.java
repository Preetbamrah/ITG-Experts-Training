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

public class BbaAdapter extends RecyclerView.Adapter<BbaAdapter.BbaViewHolder> {
    ArrayList image;
    ArrayList name;
    Context context;
    public BbaAdapter(Context context, ArrayList image, ArrayList name)
    {
        this.context= context;
        this.image = image;
        this.name = name;
    }
    @NonNull
    @Override
    public BbaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recycle_view_list,viewGroup,false);
        BbaViewHolder bbaViewHolder = new BbaViewHolder(view);
        return bbaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BbaViewHolder mViewHolder, final  int position) {
        mViewHolder.textView.setText((CharSequence) name.get(position));
        mViewHolder.imageView.setImageResource((Integer)image.get(position));
        mViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                if (position==0)
                {
                    Intent marketing = new Intent(Intent.ACTION_VIEW);
                    marketing.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/marketing.pdf?alt=media&token=b30cf89f-853e-4051-9c3f-bd1b8e7b2ea6"));
                    context.startActivity(marketing);
                }
                if (position==1)
                {
                    Intent digital = new Intent(Intent.ACTION_VIEW);
                    digital.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/digital.pdf?alt=media&token=0a79f950-1eb1-4868-9c0e-bad6a816e2c4"));
                    context.startActivity(digital);
                }
                if (position==2)
                {
                    Intent finance = new Intent(Intent.ACTION_VIEW);
                    finance.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/finance.pdf?alt=media&token=27c01ae3-8de8-44d2-9f8d-874120f29ea0"));
                    context.startActivity(finance);
                }
                if (position==3)
                {
                    Intent hr = new Intent(Intent.ACTION_VIEW);
                    hr.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/HR.pdf?alt=media&token=0794081a-583b-412e-8743-2507254f7b14"));
                    context.startActivity(hr);
                }
                if (position==4)
                {
                    Intent seo = new Intent(Intent.ACTION_VIEW);
                    seo.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/seo.pdf?alt=media&token=0e15cd7d-751e-41f0-8f84-6b21cdd8e28a"));
                    context.startActivity(seo);
                }
                if (position==5)
                {
                    Intent accounting = new Intent(Intent.ACTION_VIEW);
                    accounting.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/accountingconcepts.pdf?alt=media&token=74cec01f-133b-43ad-a0f1-c12e1ed6a268"));
                    context.startActivity(accounting);
                }
                if (position==6)
                {
                    Intent tally = new Intent(Intent.ACTION_VIEW);
                    tally.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/tally.pdf?alt=media&token=cade2aec-d407-409f-8b02-13a56019b8d0"));
                    context.startActivity(tally);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class BbaViewHolder extends  RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView textView;
        public BbaViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image_views);
            textView = (TextView)itemView.findViewById(R.id.text);
        }
    }
}
