package com.example.student.express;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {
    private final Context context;
    private final int[] imageArray;
    private final int positionMod;

    InfoAdapter(Context context, int[] imageArray, int position) {
        this.context = context;
        this.imageArray = imageArray;
        this.positionMod = position;
    }





    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_info_item, parent, false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, final int position) {
        holder.infoImage.setImageResource(imageArray[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*CustomDialogViewPager cdvp = new CustomDialogViewPager(context, positionModel);
                cdvp.show();*/
                /*final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.layout_view_pager);
                ViewPagerAdapter adapter = new ViewPagerAdapter(context, imageArray);
                final ViewPager viewPager = (ViewPager) dialog.findViewById(R.id.view_pager);
                viewPager.setAdapter(adapter);
                dialog.show();*/
                final CustomDialogViewPager cdvp = new CustomDialogViewPager(context, positionMod, position);
                final android.app.FragmentManager fragmentManager = ((InfoActivity)context).getFragmentManager();
                cdvp.show(fragmentManager, "Tag");
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageArray.length;
    }

    class InfoViewHolder extends RecyclerView.ViewHolder {
        ImageView infoImage;
        InfoViewHolder(View itemView) {
            super(itemView);
            infoImage= itemView.findViewById(R.id.image_info_item);
        }
    }


}
