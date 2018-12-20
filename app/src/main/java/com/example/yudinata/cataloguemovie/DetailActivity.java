package com.example.yudinata.cataloguemovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView backdrop;
    TextView release, overview;

    ParseDate parseDate = new ParseDate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        backdrop = (ImageView) findViewById(R.id.backdrop_path);
        release =(TextView) findViewById(R.id.tv_release);
        overview = (TextView) findViewById(R.id.tv_detail);

        Intent intent = getIntent();
        Glide.with(this)
                .load("http://image.tmdb.org/t/p/w500"+intent.getStringExtra("backdrop"))
                .into(backdrop);
        overview.setText(intent.getStringExtra("overview"));
        release.setText(parseDate.getParse(intent.getStringExtra("daterelease")));

        Toolbar toolbar = findViewById(R.id.toolbar_movie);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(intent.getStringExtra("title"));
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
