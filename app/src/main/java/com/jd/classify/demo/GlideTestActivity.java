package com.jd.classify.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gxmall.GlideImageView;
import com.gxmall.progress.CircleProgressView;
import com.gxmall.progress.OnProgressListener;

public class GlideTestActivity extends Activity{

    GlideImageView image31;
    GlideImageView image11, image12, image13;
    CircleProgressView progressView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        findViewById();
        setListener();
    }

    private void findViewById() {
        findViewById(R.id.btn_glide).setOnClickListener(view -> startActivity(new Intent(GlideTestActivity.this, ClassifyJDActivity.class)));
        image31 = findViewById(R.id.image31);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        progressView1 = findViewById(R.id.progressView1);
    }

    private void setListener() {
        image31.centerCrop().error(R.mipmap.image_load_err).diskCacheStrategy(DiskCacheStrategy.NONE).load("http://pic17.nipic.com/20111031/8166867_002049106165_2.jpg", R.color.placeholder, new OnProgressListener() {
            @Override
            public void onProgress(boolean isComplete, int percentage, long bytesRead, long totalBytes) {
                if (isComplete) {
                    progressView1.setVisibility(View.GONE);
                } else {
                    progressView1.setVisibility(View.VISIBLE);
                    progressView1.setProgress(percentage);
                }
            }
        });
        image11.load("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
        image12.load("http://img1.imgtn.bdimg.com/it/u=4027212837,1228313366&fm=23&gp=0.jpg", R.mipmap.product_default, 10);
        image13.fitCenter().load("http://5b0988e595225.cdn.sohucs.com/images/20171202/a1cc52d5522f48a8a2d6e7426b13f82b.gif", R.mipmap.product_default, 10);

    }
}
