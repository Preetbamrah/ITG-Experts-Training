package com.example.senderside.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.senderside.Bean.ImageBean;
import com.example.senderside.R;
import com.example.senderside.adapter.ImageAdapter;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Home extends Fragment {
    private View view;
    ViewPager viewPager;
    CirclePageIndicator indicator;
    Toolbar toolbar;
     private static int current_page = 0;
    private static int NUM_PAGES = 0;
    Timer timer;
    final long DELAY_MS = 3000;
    final long PERIOD_MS = 1500;
   ArrayList<ImageBean>  imageModelArrayList;
   private  int[] myImageList = new int[]{
            R.drawable.itgseminar, R.drawable.seminar,R.drawable.colgsemi ,R.drawable.itgwork,R.drawable.aryasemi,R.drawable.img,R.drawable.christmisprty
    };

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                // Inflate the layout for this fragment

                view = inflater.inflate(R.layout.fragment_home, container, false);
                viewPager = view.findViewById(R.id.view_flip);
                indicator = (CirclePageIndicator)view.findViewById(R.id.indicator);
                imageModelArrayList = new ArrayList<>();
                imageModelArrayList = populateList();
                init();
                return view;

            }

            private ArrayList<ImageBean> populateList() {
                ArrayList<ImageBean> list = new ArrayList<>();

                for(int i = 0; i <myImageList.length; i++){
                    ImageBean imageModel = new ImageBean();
                    imageModel.setImage_drawable(myImageList[i]);
                    list.add(imageModel);
                }

                return list;
            }


            @Override
            public void onCreate(@Nullable Bundle savedInstanceState) {
                setHasOptionsMenu(true);
                super.onCreate(savedInstanceState);
            }

            private void init() {

                ImageAdapter imageAdapter = new ImageAdapter(getActivity(),imageModelArrayList);
                viewPager.setAdapter(imageAdapter);
                indicator.setViewPager(viewPager);

                final float density = getResources().getDisplayMetrics().density;

                //Set circle indicator radius
                indicator.setRadius(5 * density);

                NUM_PAGES =imageModelArrayList.size();

                // Auto start of viewpager

                final Handler handler = new Handler();
                final Runnable Update = new Runnable() {
                    public void run() {
                        if (current_page == NUM_PAGES) {
                            current_page = 0;
                        }
                        viewPager.setCurrentItem(current_page++, true);
                    }
                };
                Timer swipeTimer = new Timer();
                swipeTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(Update);
                    }
                }, DELAY_MS, PERIOD_MS);

                // Pager listener over indicator
                indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                    @Override
                    public void onPageSelected(int position) {
                        current_page = position;

                    }

                    @Override
                    public void onPageScrolled(int pos, float arg1, int arg2) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int pos) {

                    }
                });

            }

    }


