package com.example.common.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.activities.NewStudentFragment;
import com.example.common.activities.StudentRegistration;

import java.util.ArrayList;

public class ReferenceAdapter extends RecyclerView.Adapter<ReferenceAdapter.MyViewHolder> {
    ArrayList name;
    Context context;

    public ReferenceAdapter(Context context,ArrayList name)
    {
        this.name= name;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_reference_list,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,final int position) {
    holder.textView.setText((CharSequence)name.get(position));
    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (position==0)
            {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promptView = layoutInflater.inflate(R.layout.activity_teacher_refer_alert,null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(promptView)
                        .setTitle("Reference By Techer")
                        .setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(context,StudentRegistration.class);
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
            if (position==1)
            {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promptView = layoutInflater.inflate(R.layout.activity_friend_refer_alert,null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(promptView)
                        .setTitle("Reference By Friend")
                        .setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(context,StudentRegistration.class);
                                context.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
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
        TextView textView;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text_reference);
        }
    }
}
