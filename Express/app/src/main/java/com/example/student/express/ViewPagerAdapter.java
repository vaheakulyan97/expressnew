package com.example.student.express;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.student.express.R;

public class ViewPagerAdapter extends PagerAdapter {

    private final Context context;
    private final int[] imageArray;

    public ViewPagerAdapter(final Context context, final int[] imageArray) {
        this.context = context;
        this.imageArray = imageArray;
    }


    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final View view = LayoutInflater.from(context).
                inflate(R.layout.image_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_item_pager);
        imageView.setImageResource(imageArray[position]);
        container.addView(view);
        return view;
    }


}