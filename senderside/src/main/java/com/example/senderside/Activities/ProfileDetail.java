package com.example.senderside.Activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.senderside.R;
import com.example.senderside.Session.UserSession;

import java.io.File;

public class ProfileDetail extends AppCompatActivity {
ImageView imageView;
TextView name_text,mobile_text,email_text, pass_text;
FloatingActionButton floatingActionButton;
EditText old_edt, new_edt;
    private File image;
    int SELECT_FILE = 0;
    private final int MY_REQUEST_CODE_WRITE_STORAGE = 45, MY_REQUEST_CODE_READ_STORAGE = 46;
    private final int MY_REQUEST_CODE_CAMERA = 47;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        imageView = findViewById(R.id.image_set);
        name_text = findViewById(R.id.name_text_view);
        mobile_text = findViewById(R.id.mobile_text_view);
        email_text = findViewById(R.id.email_text_view);
        pass_text = findViewById(R.id.password_text);
        floatingActionButton = findViewById(R.id.fab);
        pass_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(ProfileDetail.this);
                View promptView  = layoutInflater.inflate(R.layout.activity_password_configuration,null);
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ProfileDetail.this);
                alertDialog.setView(promptView);
                old_edt = promptView.findViewById(R.id.old_pass);
                new_edt = promptView.findViewById(R.id.new_pass);
                alertDialog.setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user_id= UserSession.getInstance(getApplicationContext()).getUserId();
                        String old_password = old_edt.getText().toString();
                        String new_password = new_edt.getText().toString();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = alertDialog.create();
                alert.show();
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ActivityCompat.checkSelfPermission(ProfileDetail.this,Manifest.permission.WRITE_EXTERNAL_STORAGE )!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ProfileDetail.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_REQUEST_CODE_READ_STORAGE
                    );
                }
                else {
                    SelectImage();
                }
            }
        });
    }

    private void SelectImage() {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if(requestCode == 7 && requestCode  == RESULT_OK)
        /*if(requestCode == 7)
        {
            Bitmap map=(Bitmap) data.getExtras().get("data");
            img.setImageBitmap(map);
        }*/
        //if (requestCode == Activity.RESULT_OK)

        if (requestCode == 7) {


            if (data == null) {

                imageView.setImageResource(R.drawable.default_img);
            } else {
                Bitmap map = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(map);
                image = new File(getRealPathFromURI(data.getData()));
            }
        } else if (requestCode == SELECT_FILE) {
            //  Uri.selectedImageUri=data.getData();
            // img.setImageURI(selectedImageUri);
            if (data == null) {

                imageView.setImageResource(R.drawable.default_img);
            } else {
                Uri selectedImageUri = data.getData();
                imageView.setImageURI(selectedImageUri);
                image = new File(getRealPathFromURI(data.getData()));
            }
        } else if (requestCode == 0) {
            imageView.setImageResource(R.drawable.default_img);
        }
                /*if (null != selectedImageUri) {
                    // File
                    //File imageFilePath = new File(selectedImageUri);
            }*/
    }
    public String getRealPathFromURI(Uri contentUri)
    {
        String[] proj = { MediaStore.Audio.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }

    /*///////addcabdetail
    private void CallInsertProductApi(File image, String user_id, String cabno) {

        final ProgressDialog progress=new ProgressDialog(CameraDetail.this);
        progress.setTitle("");
        progress.setMessage("Please wait...");
        progress.setCancelable(false);
        progress.show();


        ApiManager.getInstance().addcabdetail(new ApiManager.Callback() {
            @Override
            public String onResult(boolean z, String response) {
                try {



                    JSONObject jsonObject = new JSONObject(response);
                    result = jsonObject.getBoolean("success");
                    message = jsonObject.getString("message");
                    if(result == false)
                    {
                        Toast.makeText(CameraDetail.this,message,Toast.LENGTH_LONG).show();
                    }
                    else
                    {

                        Toast.makeText(CameraDetail.this,message,Toast.LENGTH_LONG).show();
                        if(progress.isShowing()) {
                            progress.dismiss();
                        }
                        Intent i=new Intent(CameraDetail.this,dashboard.class);
                        startActivity(i);

                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        },image, user_id,cabno);

    }
*/
}
