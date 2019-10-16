package com.example.common.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.common.R;

import java.io.File;

public class FacultyProfile extends AppCompatActivity {
    int SELECT_FILE = 0;
    ImageView img;
    EditText editTextPass,et1,et2;
    private File image;
    TextView txt_name,txt_email,txt_mobile,txt_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_profile);
        txt_name = findViewById(R.id.user_name);
        txt_email = findViewById(R.id.user_email);
        txt_mobile = findViewById(R.id.user_mobile);
        txt_log = findViewById(R.id.logout_confi);
        editTextPass = (EditText)findViewById(R.id.change_pass);
        img = findViewById(R.id.profile);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectImage();
            }
        });
        txt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logConfiguration();
            }
        });
        editTextPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePassDialog();
            }
        });
    }
    protected void   ChangePassDialog() {

        // get prompts.xml view
        LayoutInflater layoutInflater = LayoutInflater.from(FacultyProfile.this);
        View promptView = layoutInflater.inflate(R.layout.activity_password_configuration, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FacultyProfile.this);
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
    private  void SelectImage()
    {
        final CharSequence[] items = {"Camera", "Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(FacultyProfile.this);
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

                img.setImageResource(R.drawable.default_img);
            } else {
                Bitmap map = (Bitmap) data.getExtras().get("data");
                img.setImageBitmap(map);
                image = new File(getRealPathFromURI(data.getData()));
            }
        } else if (requestCode == SELECT_FILE) {

            if (data == null) {

                img.setImageResource(R.drawable.default_img);
            } else {
                Uri selectedImageUri = data.getData();
                img.setImageURI(selectedImageUri);
                image = new File(getRealPathFromURI(data.getData()));
            }
        } else if (requestCode == 0) {
            img.setImageResource(R.drawable.default_img);
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
    public void logConfiguration()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(FacultyProfile.this);
        alertDialog.setTitle("Are you sure do you want logout?");
        alertDialog.setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mlogout  = new Intent(FacultyProfile.this,LoginPage.class);
                        startActivity(mlogout);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog1 = alertDialog.create();
        alertDialog1.show();
    }
}


