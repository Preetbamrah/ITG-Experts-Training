package com.example.senderside.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.senderside.R;
import com.example.senderside.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class CouseFragment extends Fragment {
    private View view;
    Toolbar toolbar;
    ArrayList recycleList = new ArrayList<>(Arrays.asList("MECHANICAL","CSE/BCA/MCA","ELECTRICAL/ELECTRONIC","BBA/MBA","CIVIL"));
    ArrayList image = new ArrayList<>(Arrays.asList(R.drawable.engme,R.drawable.pngcom,R.drawable.electr,R.drawable.mba,R.drawable.civil));
    public CouseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view = inflater.inflate(R.layout.fragment_couse, container, false);
       AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
       toolbar = (Toolbar) view.findViewById(R.id.course_toolar);
        RecyclerView recyclerView = view.findViewById(R.id.course_recycle_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(getContext(),image,recycleList);
        recyclerView.setAdapter(customAdapter);

       return view;
    }


}
