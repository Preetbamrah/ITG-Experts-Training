package com.example.common.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.activities.FacultyProfile;
import com.example.common.activities.RegistrationFormActivity;
import com.example.common.activities.ViewRegisterStu;
import com.google.firebase.database.collection.LLRBNode;

import java.util.ArrayList;

public class ViewHeading extends RecyclerView.Adapter<ViewHeading.HeadingViewHolder> {
Context context;
ArrayList name;

    public ViewHeading(Context context, ArrayList name) {
        this.context = context;
        this.name = name;
    }

    @NonNull
    @Override
    public HeadingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_view_list,viewGroup,false);
        HeadingViewHolder headingViewHolder = new HeadingViewHolder(view);
        return headingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HeadingViewHolder holder, int position) {
        holder.textView.setText((CharSequence)name.get(position));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class HeadingViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public HeadingViewHolder(View items)
        {
            super(items);
            textView = (TextView)items.findViewById(R.id.list_item_view);
            textView.setBackgroundColor(Color.parseColor("#f7f7f7"));
           // textView.setTextColor(Color.parseColor("0000"));
        }
    }
}
