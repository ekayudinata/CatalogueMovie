package com.example.yudinata.cataloguemovie;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;


import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MyAsyncTaskLoader extends AsyncTaskLoader<ArrayList<MovieItems>> {
    private  ArrayList<MovieItems> mData;
    private  boolean mHasResult  = false;
    private  String mJudul;

    private static final String API_KEY= "d694d161e98f96863ba051a6de2cca89";

    public  MyAsyncTaskLoader (final Context context, String judul){
        super(context);
        onContentChanged();
        this.mJudul = judul;
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged())
            forceLoad();
        else if (mHasResult)
            deliverResult(mData);
    }

    @Override
    public void deliverResult(@Nullable ArrayList<MovieItems> data) {
        mData = data;
        mHasResult = true;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (mHasResult) {
            onReleaseResources(mData);
            mData = null;
            mHasResult = false;
        }
    }



    @Nullable
    @Override
    public ArrayList<MovieItems> loadInBackground() {
        SyncHttpClient client = new SyncHttpClient();
        final  ArrayList<MovieItems> movieItems = new ArrayList<>();
        String url = "https://api.themoviedb.org/3/search/movie?api_key="+API_KEY+"&language=en-US&query="+mJudul+"&page=1&include_adult=false";
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onStart() {
                super.onStart();
                setUseSynchronousMode(true);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
              try {
                  String result = new String(responseBody);
                  JSONObject responseObject = new JSONObject(result);
                  JSONArray list = responseObject.getJSONArray("results");

                  for (int i=0;i<list.length();i++){
                      JSONObject movie = list.getJSONObject(i);
                      MovieItems MovieItem = new MovieItems(movie);
                      movieItems.add(MovieItem);
                      Log.d("JSON", String.valueOf(MovieItem));
                  }


              }catch (Exception e){
                  e.printStackTrace();
              }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

        return movieItems;
    }

    private void onReleaseResources(ArrayList<MovieItems> mData) {
    }
}
