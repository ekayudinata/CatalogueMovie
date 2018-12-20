package com.example.yudinata.cataloguemovie;
import org.json.JSONObject;

public class MovieItems {
    private  int  id;
    private  String judul;
    private  String deskripsi;
    private  String release ;

    public  MovieItems(JSONObject object){
        try{
            Integer id = object.getInt("id");
            String judul = object.getString("title");
            String deskripsi = object.getString("overview");
            this.id = id ;
            this.judul = judul;
            this.deskripsi = deskripsi;

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
}
