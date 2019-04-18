package com.wuyuxi.hxci_service.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.wuyuxi.hxci_service.R;

import java.util.ArrayList;

public class ViewPageAdapter extends PagerAdapter {
    private ArrayList<ImageView> images;//用于存储ImageView的集合
     int[] img=new int[]{R.drawable.shouye_top01,R.drawable.shouye_top02,R.drawable.shouye_top03};

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;
    }

}
