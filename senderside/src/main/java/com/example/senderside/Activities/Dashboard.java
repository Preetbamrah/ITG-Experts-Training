package com.example.senderside.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.senderside.R;

public class Dashboard extends AppCompatActivity {

    private TextView mTextMessage;
    Toolbar toolbar;
    SwipeRefreshLayout swipeRefreshLayout;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
 Fragment fragment = null;
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new Home();
                    break;
                case R.id.navigation_dashboard:
                   fragment = new VideoDashboard();
                   break;
                case R.id.navigation_notifications:
                    fragment = new Contact();
                    break;
                case R.id.navigation_registration:
                    fragment = new OnlineRegistrationForm();
                    break;
            }
            return loadFragment(fragment);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        toolbar = findViewById(R.id.dashboard_toolbar);
        FrameLayout frameLayout = findViewById(R.id.gallery_itg);
        setSupportActionBar(toolbar);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        loadFragment(new Home());
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
    private boolean loadFragment(Fragment fragment){
        if (fragment!= null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.gallery_itg,fragment)
                    .commit();

            return true;
        }
        return false;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return true;
      /*  menuInflater.inflate(R.menu.menu_toolbar, menu);
        super.onCreateOptionsMenu(menu,menuInflater);*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                swipeRefreshLayout = new SwipeRefreshLayout(this);
                swipeRefreshLayout.setRefreshing(true);
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        swipeRefreshLayout.setRefreshing(true);
                        new Handler().postDelayed(new Runnable() {

                            public void run() {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        }, 3000);
                    }
                });/*
                        doYourUpdate();*/
                Toast.makeText(Dashboard.this,"Refresh",Toast.LENGTH_LONG).show();
                break;
            case R.id.action_about:
                Intent about = new Intent(Dashboard.this,AboutActivity.class);
                startActivity(about);
                Toast.makeText(Dashboard.this, "About", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_profile:
                Intent profile = new Intent(Dashboard.this,ProfileDetail.class);
                startActivity(profile);
                Toast.makeText(Dashboard.this, "Profile", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
                builder.setMessage("ARE YOU SURE YOU WANT TO LOGOUT?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                               finish();
                            }
                        })

                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                //Toast.makeText(getActivity(),"Logout",Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(Dashboard.this,"invalid",Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    private void doYourUpdate()
    {
        swipeRefreshLayout.setRefreshing(false);
    }

}
