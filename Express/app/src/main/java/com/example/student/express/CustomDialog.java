package com.example.student.express;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.VideoView;

public class CustomDialog extends Dialog {


    private Context context;
    private int position;

    public CustomDialog(final Context context, final int position) {
        super(context);
        this.context = context;
        this.position = position;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_custom_dialog);
        final VideoView videoView = findViewById(R.id.video_info);
        videoView.setVideoURI(Uri.parse(DataProvider.getList().get(position).getVideoUrl()));
        videoView.start();
    }
}
