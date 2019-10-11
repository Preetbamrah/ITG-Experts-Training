package com.example.senderside.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.senderside.R;

public class Home extends Fragment {
    private View view;
    ViewFlipper viewFlipper;
    Toolbar toolbar;

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                view = inflater.inflate(R.layout.fragment_home, container, false);
                viewFlipper = view.findViewById(R.id.view_flip);
                toolbar = view.findViewById(R.id.home_toolbar);
                int images[] = {R.drawable.seminar,R.drawable.interview,R.drawable.christmisprty,R.drawable.itgseminar};

                for (int image: images)
                {
                    flipImages(image);
                }
                return view;
            }

                @Override
                public void onCreate(@Nullable Bundle savedInstanceState) {
                    setHasOptionsMenu(true);
                    super.onCreate(savedInstanceState);
                }

            public void flipImages(int image)
                {
                    ImageView imageView = new ImageView(getActivity());
                    imageView.setBackgroundResource(image);

                    viewFlipper.addView(imageView);
                    viewFlipper.setFlipInterval(4000);
                    viewFlipper.setAutoStart(true);

                    viewFlipper.setInAnimation(getActivity(),R.anim.slide_in_left);

                }



}
 /*swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                            @Override
                            public void onRefresh() {
                                swipeRefreshLayout.setRefreshing(true);
                                new Handler().postDelayed(new Runnable() {

                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(false);
                                    }
                                }, 3000);
                            }
                        });
*/
