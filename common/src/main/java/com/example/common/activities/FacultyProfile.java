package com.example.common.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.R;
import com.example.common.bean.UserBean;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class FacultyProfile extends AppCompatActivity {
    int SELECT_FILE = 0;
    ImageView img;
    EditText editTextPass,et1,et2;
    private  static  final  int CAMERA_CAPTURE_CODE = 1;
    private File image;
    DatabaseReference mDatabaseReference, reference;
    TextView txt_name,txt_email,txt_mobile,txt_log;
    private  StorageReference mStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_profile);
        txt_name = findViewById(R.id.user_name);
        txt_email = findViewById(R.id.user_email);
        txt_mobile = findViewById(R.id.user_mobile);
        txt_log = findViewById(R.id.logout_confi);
        mStorage = FirebaseStorage.getInstance().getReference();
        editTextPass = (EditText)findViewById(R.id.change_pass);
        FirebaseAuth.getInstance().signOut();
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        reference = FirebaseDatabase.getInstance().getReference("Image");
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
        reference.child("Image").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    String imageView = dataSnapshot.child("Image").getValue().toString();
                    img.setImageResource(Integer.parseInt(imageView));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String name = ds.child("user_name").getValue().toString();
                    String email = ds.child("user_email").getValue().toString();
                    String mobile = ds.child("user_mobile").getValue().toString();
                    txt_name.setText(name);
                    txt_email.setText(email);
                    txt_mobile.setText(mobile);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void logConfiguration() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(FacultyProfile.this);
        alertDialog.setTitle("Are you sure you want Logout?")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(FacultyProfile.this,LoginPage.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }

    private void   ChangePassDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(FacultyProfile.this);
        View promptView = layoutInflater.inflate(R.layout.activity_password_configuration, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(FacultyProfile.this);
        alertDialogBuilder.setView(promptView);
        et1 = (EditText) promptView.findViewById(R.id.old_edit);
        et2 = (EditText) promptView.findViewById(R.id.new_edit);

        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, final int id) {

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
                    startActivityForResult(intent, CAMERA_CAPTURE_CODE);
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
        if (requestCode == CAMERA_CAPTURE_CODE && requestCode == RESULT_OK)
        {
            Uri uri = data.getData();
            StorageReference storageReference =mStorage.child("Photos").child(uri.getLastPathSegment());
            storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getApplicationContext(),"Uploading finished.....",Toast.LENGTH_LONG).show();
                }
            });

        }
        /*
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


}


