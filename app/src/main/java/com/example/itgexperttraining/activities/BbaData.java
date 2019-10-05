package com.example.itgexperttraining.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.itgexperttraining.R;

public class BbaData extends AppCompatActivity implements View.OnClickListener {
    TextView marketing, digital, finance, hr, seo, accounting, tally;
    ImageView sign_marketing, sign_digital, sign_finance, sign_hr, sign_seo, sign_accounting, sign_tally;
    Toolbar toolbar;
    ImageView image_marketing,image_digital,image_finance,image_hr,image_seo,image_accounting,image_tally;
    RelativeLayout layout_marketing,layout_digital,layout_finance,layout_hr,layout_seo,layout_accounting,layout_tally;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bba_data);
        toolbar = findViewById(R.id.action_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout_marketing= findViewById(R.id.marketing_rela);
        layout_digital = findViewById(R.id.digital_rela);
        layout_accounting = findViewById(R.id.accounting_rela);
        layout_finance = findViewById(R.id.finance_rela);
        layout_hr = findViewById(R.id.hr_rela);
        layout_seo = findViewById(R.id.seo_rela);
        layout_tally = findViewById(R.id.tally_rela);
        marketing = findViewById(R.id.textmarketing);
        digital = findViewById(R.id.textdigital);
        finance = findViewById(R.id.textfinance);
        hr = findViewById(R.id.texthr);
        seo = findViewById(R.id.textseo);
        accounting = findViewById(R.id.textaccounting);
        tally = findViewById(R.id.texttally);
        sign_accounting = findViewById(R.id.accounting_sign);
        sign_digital = findViewById(R.id.digital_sign);
        sign_finance = findViewById(R.id.finance_sign);
        sign_hr = findViewById(R.id.hr_sign);
        sign_marketing = findViewById(R.id.marketing_sign);
        sign_seo = findViewById(R.id.seo_sign);
        sign_tally = findViewById(R.id.tally_sign);
        image_marketing = findViewById(R.id.image_marketing);
        layout_marketing.setOnClickListener(this);
        layout_tally.setOnClickListener(this);
        layout_finance.setOnClickListener(this);
        layout_seo.setOnClickListener(this);
        layout_hr.setOnClickListener(this);
        layout_accounting.setOnClickListener(this);
        layout_digital.setOnClickListener(this);
    }
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.marketing_rela:
               Intent marketing = new Intent(Intent.ACTION_VIEW);
               marketing.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/marketing.pdf?alt=media&token=b30cf89f-853e-4051-9c3f-bd1b8e7b2ea6"));
               startActivity(marketing);
                break;
            case R.id.digital_rela:
                Intent digital = new Intent(Intent.ACTION_VIEW);
                digital.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/digital.pdf?alt=media&token=0a79f950-1eb1-4868-9c0e-bad6a816e2c4"));
                startActivity(digital);
                break;
            case R.id.finance_rela:
                Intent finance = new Intent(Intent.ACTION_VIEW);
                finance.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/finance.pdf?alt=media&token=27c01ae3-8de8-44d2-9f8d-874120f29ea0"));
                startActivity(finance);
                break;
            case R.id.hr_rela:
                Intent hr = new Intent(Intent.ACTION_VIEW);
                hr.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/HR.pdf?alt=media&token=0794081a-583b-412e-8743-2507254f7b14"));
                startActivity(hr);
                break;
            case R.id.tally_rela:
                Intent tally = new Intent(Intent.ACTION_VIEW);
                tally.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/tally.pdf?alt=media&token=cade2aec-d407-409f-8b02-13a56019b8d0"));
                startActivity(tally);
                break;
            case R.id.seo_rela:
                Intent seo = new Intent(Intent.ACTION_VIEW);
                seo.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/seo.pdf?alt=media&token=0e15cd7d-751e-41f0-8f84-6b21cdd8e28a"));
                startActivity(seo);
                break;
            case R.id.accounting_rela:
                Intent accounting = new Intent(Intent.ACTION_VIEW);
                accounting.setData(Uri.parse("https://firebasestorage.googleapis.com/v0/b/itgexperttraining-edcab.appspot.com/o/accountingconcepts.pdf?alt=media&token=74cec01f-133b-43ad-a0f1-c12e1ed6a268"));
                startActivity(accounting);
                break;
                default:
                    break;

        }
    }
}
/*   signaccounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAccounting();
            }
        });
        signtally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTally();
            }
        });
        signseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSeo();
            }
        });
        signmarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMarketing();
            }
        });
        signhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHr();
            }
        });
        signfinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFinance();
            }
        });
        signdigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDigital();
            }
        });
        marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               callMarketing();
            }
        });

        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDigital();
            }
        });
        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callFinance();

            }
        });
        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callHr();

            }
        });
        seo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callSeo();

            }
        });

        accounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAccounting();

            }
        });
        tally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTally();
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void callTally() {
        Intent intent = new Intent(BbaData.this,Tally.class);
        startActivity(intent);
    }
    private void callSeo()
    {
        Intent intent = new Intent(BbaData.this,Seo.class);
        startActivity(intent);
    }
    private  void callMarketing()
    {
        Intent intent = new Intent(BbaData.this,Marketing.class);
        startActivity(intent);
    }
    private  void  callHr()
    {
        Intent intent = new Intent(BbaData.this,Hr.class);
        startActivity(intent);
    }
    private  void callDigital()
    {
        Intent intent = new Intent(BbaData.this,Digital.class);
        startActivity(intent);
    }
    private void callFinance()
    {
        Intent intent = new Intent(BbaData.this,Finanace.class);
        startActivity(intent);
    }
    private void callAccounting()
    {
        Intent intent = new Intent(BbaData.this,Accounting.class);
        startActivity(intent);
    }*/

