package com.example.common.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.bean.FacultyBean;

import java.util.ArrayList;

public class Faculty_status extends ArrayAdapter {
Context context;
    public Faculty_status(@NonNull Context context, ArrayList<FacultyBean> objects) {
        super(context, R.layout.activity_faculty_status,objects);
    }

    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.activity_faculty_status,null);
        TextView tvUsername=view.findViewById(R.id.text_name);
        TextView tvStatus=view.findViewById(R.id.text_status);
        TextView tvNumber = view.findViewById(R.id.text_number);
        return view;
    }
}
