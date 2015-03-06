package com.example.chelseafc.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private int [] mImages;
    private ImageView [] mImageViews;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.vp_main_activity);
        mImages = new int[] {
                R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5,
                R.drawable.m6, R.drawable.m7, R.drawable.m8, R.drawable.m9, R.drawable.m10
        };

        mImageViews = new ImageView[mImages.length];
        for (int i=0;i<mImages.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImages[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mImageViews[i] = imageView;
        }

        mAdapter = new MyAdapter(this,mImageViews);
        mViewPager.setAdapter(mAdapter);
        if(mImages.length>1){
            mViewPager.setCurrentItem(mImages.length*50);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
