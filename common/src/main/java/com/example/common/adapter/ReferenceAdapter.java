package com.example.common.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.R;
import com.example.common.activities.LoginPage;
import com.example.common.activities.NewStudentFragment;
import com.example.common.activities.RegisterPage;
import com.example.common.activities.StudentRegistration;
import com.example.common.bean.ReferenceBean;
import com.example.common.bean.StudentReference;
import com.example.common.bean.TeacherBean;
import com.example.common.database.MyDbHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ReferenceAdapter extends RecyclerView.Adapter<ReferenceAdapter.ReferenceViewHolder> {
    ArrayList name;
    Context context;

    public ReferenceAdapter(Context context,ArrayList name)
    {
        this.name= name;
        this.context = context;
    }
    @NonNull
    @Override
    public ReferenceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_reference_list,viewGroup,false);
        ReferenceViewHolder referenceViewHolder = new ReferenceViewHolder(view);
        return referenceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ReferenceViewHolder viewholder, final int position) {
    viewholder.textView.setText((CharSequence)name.get(position));
    viewholder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            if (position==0)
            {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                final View promptView = layoutInflater.inflate(R.layout.activity_teacher_refer_alert,null);
                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(promptView)
                        .setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText teacher_edit = promptView.findViewById(R.id.teacher_edit);
                                EditText designation = promptView.findViewById(R.id.designation_edit);
                                String teachername = teacher_edit.getText().toString();
                                String designationTeacher = designation.getText().toString();
                                if (teachername.isEmpty())
                                {
                                    Toast.makeText(context,"Please enter the teacher name",Toast.LENGTH_LONG).show();
                                }
                                else if ( designationTeacher.isEmpty())
                                {
                                    Toast.makeText(context,"Please enter the teacher designation",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                   /* ReferenceBean referenceBean = new ReferenceBean();
                                    referenceBean.setStudent_teacher(teachername);
                                    referenceBean.setTeacher_designation(designationTeacher);

                                    MyDbHelper myDbHelper = new MyDbHelper(promptView.getContext());
                                    myDbHelper.addReference(referenceBean);*/
                                    TeacherBean teacherBean = new TeacherBean(teachername,
                                            designationTeacher);
                                    FirebaseDatabase.getInstance().getReference("Teacher")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(teacherBean).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(context,"Register reference",Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(context,StudentRegistration.class);
                                            context.startActivity(intent);
                                        }
                                    });
                                }

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
            if (position==1)
            {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                final View promptView = layoutInflater.inflate(R.layout.activity_friend_refer_alert,null);
               final AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                alertDialog.setView(promptView)
                        .setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText frd_edit = promptView.findViewById(R.id.frd_name);
                                EditText course = promptView.findViewById(R.id.frd_course);
                                String frdname = frd_edit.getText().toString();
                                String coursename = course.getText().toString();
                                if (frdname.isEmpty())
                                {
                                    Toast.makeText(context,"Please enter the friend name",Toast.LENGTH_LONG).show();
                                }
                                else if ( coursename.isEmpty())
                                {
                                    Toast.makeText(context,"Please enter the friend course",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    /*ReferenceBean referenceBean = new ReferenceBean();
                                    referenceBean.setStudent_friend(frdname);
                                    referenceBean.setFriend_cousre(coursename);

                                    MyDbHelper myDbHelper = new MyDbHelper(context);
                                    myDbHelper.addReference(referenceBean);
*/
                                    StudentReference studentReference = new StudentReference(frdname,
                                        coursename);
                                    FirebaseDatabase.getInstance().getReference("ReferenceStudent")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(studentReference).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(context,"Register reference",Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(context,StudentRegistration.class);
                                            context.startActivity(intent);
                                        }
                                    });
                                }

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }
        }
    });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ReferenceViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        public ReferenceViewHolder(View itemView)
        {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text_reference);
        }
    }
}
