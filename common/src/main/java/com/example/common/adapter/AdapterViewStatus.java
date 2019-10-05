package com.example.common.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.common.R;
import com.example.common.activities.ViewStatusList;
import com.example.common.bean.ViewBean;
import com.google.android.gms.common.api.Status;

import java.util.List;

public class AdapterViewStatus extends RecyclerView.Adapter<AdapterViewStatus.ViewHolder> {
private Context context;
protected List<ViewBean> list;

    public AdapterViewStatus(Context context, List<ViewBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_view_status_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       ViewBean movie = (ViewBean) list.get(position);

        holder.textName.setText(movie.getUserEmail());
        holder.textEmail.setText(String.valueOf(movie.getUserEmail()));
        holder.textMobile.setText(String.valueOf(movie.getUserMobile()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textName, textEmail, textMobile;
        public ViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.name_text);
            textEmail = itemView.findViewById(R.id.email_text);
            textMobile = itemView.findViewById(R.id.mobile_text);
        }
    }



}
