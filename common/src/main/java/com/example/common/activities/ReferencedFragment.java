package com.example.common.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common.R;
import com.example.common.adapter.ReferenceAdapter;

import java.util.ArrayList;
import java.util.Arrays;


public class ReferencedFragment extends Fragment {
  RecyclerView recyclerView;
  ReferenceAdapter referenceAdapter;
  ArrayList name = new ArrayList(Arrays.asList("REFERENCE BY TEACHER","REFERENCE BY FRIEND"));
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_referenced, container, false);
        recyclerView= (RecyclerView)view.findViewById(R.id.recycler_refer);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        referenceAdapter = new ReferenceAdapter(getContext(),name);
        recyclerView.setAdapter(referenceAdapter);
        return view;
    }


}
