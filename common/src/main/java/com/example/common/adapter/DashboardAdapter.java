package com.example.common.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.activities.Dashboard;
import com.example.common.activities.FacultyProfile;
import com.example.common.activities.RegistrationFormActivity;
import com.example.common.activities.ViewRegisterStu;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {
ArrayList image;
ArrayList name;
Context context;
 public DashboardAdapter(Context context,ArrayList image,ArrayList name)
 {
     this.context = context;
     this.image = image;
     this.name = name;
 }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_dashboard_list_items,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
     holder.textView.setText((CharSequence)name.get(position));
     holder.imageView.setImageResource((Integer)image.get(position));
     holder.itemView.setOnClickListener(new View.OnClickListener()
     {
         public void onClick(View view)
         {
             if (position==0)
             {
                Intent registerIntent =  new Intent(context,RegistrationFormActivity.class);
                registerIntent.putExtra("image",(Integer)image.get(position));
                context.startActivity(registerIntent);
             }
             if (position==1)
             {
                 Intent viewIntent = new Intent(context,ViewRegisterStu.class);
                 viewIntent.putExtra("image",(Integer)image.get(position));
                 context.startActivity(viewIntent);
             }
             if (position==2)
             {
                 Intent profileIntent  = new Intent(context,FacultyProfile.class);
                 profileIntent.putExtra("image",(Integer) image.get(position));
                 context.startActivity(profileIntent);
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
            imageView = (ImageView)itemView.findViewById(R.id.image_view);
            textView = (TextView)itemView.findViewById(R.id.text_view);
        }
    }
}
