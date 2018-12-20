package com.example.yudinata.cataloguemovie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDate {
    private static String simpleformat(String date){
        String result ="";
        DateFormat old = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date oldDate = old.parse(date);
            DateFormat newFormat = new SimpleDateFormat("EEEE, MMM d, yyyy");
            result = newFormat.format(oldDate);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


    public String getParse(String date){
        return simpleformat(date);
    }
}
