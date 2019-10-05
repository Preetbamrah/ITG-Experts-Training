package com.example.itgexperttraining.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itgexperttraining.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;
    Toolbar toolbar;
    private static final int REQUEST_CALL = 1;
    TextView hrtext,itgtext,urltext,call_text,itg_text,url_view;
    ImageView hr_contact_image,itg_contact_img,url_imag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        hrtext =  findViewById(R.id.hr);
        itgtext= findViewById(R.id.itg);
        hr_contact_image =findViewById(R.id.image_no);
        itg_contact_img = findViewById(R.id.image_itg);
        url_imag = findViewById(R.id.image_url);
        urltext = findViewById(R.id.text_website);
        call_text = findViewById(R.id.text_callhr);
        itg_text = findViewById(R.id.text_callitg);
        url_view = findViewById(R.id.url);
        toolbar = findViewById(R.id.toolbar_contact);
                setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        hrtext.setOnClickListener(this);
        itgtext.setOnClickListener(this);
        urltext.setOnClickListener(this);
        itg_contact_img.setOnClickListener(this);
        hr_contact_image.setOnClickListener(this);
        url_imag.setOnClickListener(this);
        call_text.setOnClickListener(this);
        itg_text.setOnClickListener(this);
        url_view.setOnClickListener(this);

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
        String phno = "9700009148";
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phno));
        startActivity(callIntent);
    }
    private void callItg()
    {
        String phno = "8728039876";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phno));
        startActivity(intent);
    }
    private  void gotoUrl()
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.infotechnogen.com/"));
        startActivity(intent);
    }
    /*textcontacthr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ContactActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

                }
                else {
                    String phno = "9700009148";
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phno));
                    startActivity(callIntent);
                }
            }
        });
        textcontactitg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ContactActivity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
                }
                else
                {
                    String phno = "8728039876";
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+phno));
                    startActivity(intent);
                }
            }
        });
        textwebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.infotechnogen.com/"));
                startActivity(intent);
            }
        });
*/

}
