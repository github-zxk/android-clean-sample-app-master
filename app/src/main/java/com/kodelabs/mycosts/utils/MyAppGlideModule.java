package com.kodelabs.mycosts.utils;

import android.content.Context;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by think on 2017/11/12.
 */
@GlideModule
public class MyAppGlideModule extends AppGlideModule
{
   @Override
   public void applyOptions(Context context, GlideBuilder builder)
   {
      super.applyOptions(context, builder);
   }


}
