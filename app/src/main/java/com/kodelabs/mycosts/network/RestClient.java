package com.kodelabs.mycosts.network;

import android.util.Log;

//import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p/>
 * This is the main entry point for network communication. Use this class for instancing REST services which do the
 * actual communication.
 */
public class RestClient
{

   /**
    * This is our main backend/server URL.
    */
   public static final String REST_API_URL = "https://mycosts-app.herokuapp.com/";
//   public static final String REST_API_URL = "http://106.15.180.65/";


   private static Retrofit s_retrofit;

   static
   {

      // enable logging
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger()
      {
         @Override
         public void log(String message)
         {
            Log.e("RetrofitLog", "retrofitBack = " + message);
         }
      });
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

      OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)
//            .addNetworkInterceptor(new StethoInterceptor())
            .build();

      s_retrofit = new Retrofit.Builder()
            .baseUrl(REST_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
   }

   public static <T> T getService(Class<T> serviceClass)
   {
      return s_retrofit.create(serviceClass);
   }
}
