package com.example.chelseafc.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ChelseaFC on 2015/3/6.
 */
public class MyAdapter extends PagerAdapter {

    private ImageView [] mImageViews;

    public MyAdapter(Context context, ImageView [] imageViews){
        mImageViews = imageViews;
    }

    @Override
    public int getCount() {
        int adapterLength;
        if (mImageViews.length > 1){
            adapterLength = mImageViews.length * 100;
        }
        else {
            adapterLength = 1;
        }
        return adapterLength;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mImageViews.length > 3){
            (container).removeView(mImageViews[position % mImageViews.length]);
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        (container).addView(mImageViews[position % mImageViews.length],0);
        return mImageViews[position % mImageViews.length];
    }
}
