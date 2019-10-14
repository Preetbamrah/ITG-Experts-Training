package com.example.itgexperttraining.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.itgexperttraining.R;
import com.example.itgexperttraining.session.UserSession;

import java.io.File;

public class ProfileDetail extends AppCompatActivity {
    TextView txt1,txt2,txt3,txt4,txt5;
    ImageView imageView, profile_image;
    private  final int MY_REQUEST_CODE_READ_STORAGE = 46;
    int SELECT_FILE = 0;
    EditText et1,et2;
    private File image;
    boolean result=false;
    String message=null;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        txt1=findViewById(R.id.textemail);
        txt2=findViewById(R.id.textchangepassword);
        txt3=findViewById(R.id.textlogout);
        txt4=findViewById(R.id.textusername);
        txt5 = findViewById(R.id.resume_text);
        imageView = findViewById(R.id.right_image);
        profile_image = findViewById(R.id.user_image);
        toolbar = findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ProfileDetail.this,Manifest.permission.WRITE_EXTERNAL_STORAGE )!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ProfileDetail.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_REQUEST_CODE_READ_STORAGE);
                }
                else
                {
                    SelectImage();
                }

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resume = new Intent(ProfileDetail.this,CreateResume.class);
                startActivity(resume);
            }
        });
        txt4.setText(UserSession.getInstance(ProfileDetail.this).getUserName());
        txt1.setText(UserSession.getInstance(ProfileDetail.this).getUserEmail());
        ///change password
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePassDialog();
            }
        });

        //logout
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();

            }
        });
    }
    protected void showInputDialog() {
        /*final ProgressDialog progress=new ProgressDialog(ProfileDetail.this);
        progress.setTitle("");
        progress.setMessage("Please wait...");
        progress.setCancelable(false);
        progress.show();*/


        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(ProfileDetail.this);
        View promptView = layoutInflater.inflate(R.layout.activity_logout_configuration, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileDetail.this);
        alertDialogBuilder.setView(promptView);


        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       /* if( UserSession.getInstance(ProfileDetail.this).setUserLoggedIn(false))
                        {
                            if(progress.isShowing()) {
                                progress.dismiss();
                            }
                            Toast.makeText(ProfileDetail.this,"Logout Successfully",Toast.LENGTH_LONG).show();

                            Intent i=new Intent(ProfileDetail.this,Login.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(ProfileDetail.this,"Logout Unsuccessful",Toast.LENGTH_LONG).show();
                        }*/

                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }


    protected void   ChangePassDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(ProfileDetail.this);
        View promptView = layoutInflater.inflate(R.layout.activity_password_configuration, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileDetail.this);
        alertDialogBuilder.setView(promptView);
        et1 = (EditText) promptView.findViewById(R.id.old_edit);
        et2 = (EditText) promptView.findViewById(R.id.new_edit);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                      /*  String user_id=UserSession.getInstance(getApplicationContext()).getUserId();
                        String old_password=et1.getText().toString();
                        String new_password=et2.getText().toString();
                        changepassword(user_id,old_password,new_password);*/


                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void changepassword( String user_id, String old_password, String new_password){
        /*final ProgressDialog progress=new ProgressDialog(ProfileDetail.this);
        progress.setTitle("");
        progress.setMessage("Please wait...");
        progress.setCancelable(false);
        progress.show();
        ApiManager.getInstance().changepassword(new ApiManager.Callback()
        {
            @Override
            public String onResult(boolean z, String response)
            {
                try
                {
                    JSONObject jsonObject=new JSONObject(response);
                    result=jsonObject.getBoolean("success");
                    message=jsonObject.getString("message");
                    if(result == false)
                    {
                        Toast.makeText(ProfileDetail.this,message,Toast.LENGTH_LONG).show();

                    }
                    else
                    {

                        Toast.makeText(ProfileDetail.this,message,Toast.LENGTH_LONG).show();
                        if(progress.isShowing()) {
                            progress.dismiss();
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                return null;
            }
        },user_id,old_password,new_password);*/

    }
    private  void SelectImage()
    {
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileDetail.this);
        builder.setTitle("Add Image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (items[i].equals("Camera")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 7);
                } else if (items[i].equals("Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);
                } else if (items[i].equals("Cancel")) {
                    dialog.dismiss();
                }

            }
        });
        builder.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 7) {


            if (data == null) {

                profile_image.setImageResource(R.drawable.default_img);
            } else {
                Bitmap map = (Bitmap) data.getExtras().get("data");
                profile_image.setImageBitmap(map);
                image = new File(getRealPathFromURI(data.getData()));
            }
        } else if (requestCode == SELECT_FILE) {

            if (data == null) {

                profile_image.setImageResource(R.drawable.default_img);
            } else {
                Uri selectedImageUri = data.getData();
                profile_image.setImageURI(selectedImageUri);
                image = new File(getRealPathFromURI(data.getData()));
            }
        } else if (requestCode == 0) {
            profile_image.setImageResource(R.drawable.default_img);
        }

    }
    public String getRealPathFromURI(Uri contentUri)
    {
        String[] proj = { MediaStore.Audio.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
