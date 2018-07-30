package com.example.student.express;


import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class CustomDialogViewPager extends DialogFragment {


        private final Context context;
        private final int position;
        private final int currentPosition;


        @SuppressLint("ValidFragment")
        public CustomDialogViewPager(Context context, int position, final int currentPosition) {
            this.context = context;
            this.position = position;
            this.currentPosition = currentPosition;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            final View view = LayoutInflater.from(context).inflate(R.layout.layout_view_pager, container, false);
            final ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
            final ViewPagerAdapter adapter = new ViewPagerAdapter(context, DataProvider.getList().get(position).getImageArrayId());
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(currentPosition);
            return view;
        }


    }

