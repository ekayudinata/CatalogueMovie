package com.example.yudinata.cataloguemovie;
import org.json.JSONObject;

import java.util.Date;

public class MovieItems {
    private  int  id;
    private  String judul;
    private  String deskripsi;
    private  String poster_path;
    private String release ;
    private  String backdrop_path;

    public  MovieItems(JSONObject object){
        try{
            Integer id = object.getInt("id");
            String judul = object.getString("title");
            String deskripsi = object.getString("overview");
            String poster_pasth = object.getString("poster_path");
            String release = object.getString("release_date");
            String backdrop_path = object.getString("backdrop_path");
            this.id = id ;
            this.judul = judul;
            this.deskripsi = deskripsi;
            this.poster_path=poster_pasth;
            this.release = release;
            this.backdrop_path = backdrop_path;

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getId() {
        return id;
    }

    public String getRelease() { return release;  }

    public String getPoster_path() { return poster_path; }

    public String getBackdrop_path() { return backdrop_path; }
}
