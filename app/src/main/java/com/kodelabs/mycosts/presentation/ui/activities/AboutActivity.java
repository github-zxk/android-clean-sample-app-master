package com.kodelabs.mycosts.presentation.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.kodelabs.mycosts.R;

public class AboutActivity extends AppCompatActivity
{
   private String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1510298192&di=084bdd87f36cfc25e978181ad183598d&src=http://pic.chinaxinge.com/xinge/PHOTO/upload/shopimg/big/201202/20120217084804.jpg";
//String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510309003571&di=6e7fd63359f4012381340980ae1179df&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D61719f2dd3f9d72a0369185ebc434241%2F6159252dd42a28344fa6cd1951b5c9ea15cebfa4.jpg";

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_about);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      RequestOptions options = new RequestOptions().fitCenter()
            .placeholder(R.mipmap.ic_launcher)
            .priority(Priority.HIGH)
            .diskCacheStrategy(DiskCacheStrategy.ALL);
      ImageView imageView = (ImageView) findViewById(R.id.img);
      Glide.with(this).load(url).apply(options).thumbnail(0.4f).into(imageView);
      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener()
      {
         @Override
         public void onClick(View view)
         {
            // let the user choose his email client
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                  "mailto", "dario.milicic@gmail.com", null));
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
         }
      });
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
   }

}
