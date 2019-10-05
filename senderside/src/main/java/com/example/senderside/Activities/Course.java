package com.example.senderside.Activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.senderside.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Course extends Fragment {
  private  View view;
  PDFView pdfView;
  Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_course, container, false);
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        toolbar = view.findViewById(R.id.course_toolbar);
        pdfView = view.findViewById(R.id.course_pdf);
        pdfView.fromAsset("industrial.pdf")
                .enableSwipe(true)
                .enableDoubletap(true)
                .enableAnnotationRendering(true)
                .swipeHorizontal(false)
                .load();
        return view;
    }


}
