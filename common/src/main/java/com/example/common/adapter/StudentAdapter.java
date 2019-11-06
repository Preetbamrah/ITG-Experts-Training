package com.example.common.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.bean.StudentBean;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context context;
    ArrayList stname;
    public StudentAdapter(Context context, ArrayList stname) {
        this.context = context;
        this.stname = stname;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list_students,viewGroup,false);
        StudentViewHolder studentViewHolder =  new StudentViewHolder(view);
        return studentViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, final int position) {
        holder.textView.setText((CharSequence)stname.get(position));
    }

    @Override
    public int getItemCount() {
        return stname.size();
    }

    public  class StudentViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        public StudentViewHolder(View itemView)
        {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.students_name);
        }
    }
}
