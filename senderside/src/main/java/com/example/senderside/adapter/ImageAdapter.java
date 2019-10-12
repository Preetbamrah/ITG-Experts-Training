package com.example.senderside.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.senderside.Activities.Home;
import com.example.senderside.Bean.ImageBean;
import com.example.senderside.R;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {
    ArrayList<ImageBean> imageBeanArrayList;
    public Context mContext;

    public ImageAdapter(Context context, ArrayList<ImageBean> imageBeanArrayList) {
        this.mContext = context;
        this.imageBeanArrayList = imageBeanArrayList;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(imageBeanArrayList.get(position).getImage_drawable());
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return imageBeanArrayList.size();
    }
}
