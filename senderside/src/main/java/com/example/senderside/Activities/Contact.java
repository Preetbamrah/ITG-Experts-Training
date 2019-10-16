package com.example.senderside.Activities;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
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
import android.widget.TextView;
import android.widget.Toast;

import com.example.senderside.R;


public class Contact extends Fragment implements View.OnClickListener {
private View view;
private Menu menuItem;
    Context context;
    private static final int MY_REQUEST_READ_CODE = 1;
    Toolbar toolbar;
    TextView hrtext,itgtext,urltext,call_text,itg_text,url_view;
    ImageView hr_contact_image,itg_contact_img,url_imag;
    public Contact(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contact, container, false);
        hrtext = view.findViewById(R.id.hr);
        AppCompatActivity appCompatActivity = (AppCompatActivity)getActivity();
        toolbar = view.findViewById(R.id.toolbar_contact);
        appCompatActivity.setSupportActionBar(toolbar);
        itgtext = view.findViewById(R.id.itg);
        hr_contact_image = view.findViewById(R.id.image_no);
        itg_contact_img = view.findViewById(R.id.image_itg);
        url_imag = view.findViewById(R.id.image_url);
        urltext = view.findViewById(R.id.text_website);
        call_text = view.findViewById(R.id.text_callhr);
        itg_text = view.findViewById(R.id.text_callitg);
        url_view = view.findViewById(R.id.url);
        hrtext.setOnClickListener(this);
        itgtext.setOnClickListener(this);
        urltext.setOnClickListener(this);
        itg_contact_img.setOnClickListener(this);
        hr_contact_image.setOnClickListener(this);
        url_imag.setOnClickListener(this);
        call_text.setOnClickListener(this);
        itg_text.setOnClickListener(this);
        url_view.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v) {
        if(v==hrtext)
        {
            contactHr();
        } else if (v== itgtext)
        {
            callItg();
        }
        else if (v== urltext)
        {
            gotoUrl();
        }
        else if (v==hr_contact_image)
        {
            contactHr();
        }
        else if (v==itg_contact_img)
        {
            callItg();
        }
        else if (v== url_imag)
        {
            gotoUrl();
        }
        else if (v== call_text)
        {
            contactHr();
        }
        else if (v==itg_text)
        {
            callItg();
        }
        else if (v==url_view)
        {
            gotoUrl();
        }
    }
    private  void contactHr()
    {
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},MY_REQUEST_READ_CODE);
            }
        else
            {
                    String phno = "9700009148";
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phno));
                    startActivity(callIntent);
            }
    }
    private void callItg()
    {
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},MY_REQUEST_READ_CODE);
            }
        else
            {
                String phno = "8728039876";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phno));
                startActivity(intent);
            }
    }
    private  void gotoUrl()
    {
        if (ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.INTERNET},MY_REQUEST_READ_CODE);
            }
        else
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.infotechnogen.com/"));
                startActivity(intent);
            }
    }
}
