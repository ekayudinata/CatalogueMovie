package com.example.yudinata.cataloguemovie;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<MovieItems> mData = new ArrayList<>();
    private Context context;
    ParseDate parseDate = new ParseDate();


    public  MovieAdapter(Context context ){
        this.context = context;
    }

    public void setData(ArrayList<MovieItems> data){
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_items, null);

        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context)
                .load("http://image.tmdb.org/t/p/w185"+mData.get(position).getPoster_path())
                .into(holder.Poster);
        holder.judul.setText(mData.get(position).getJudul());
        holder.tvDeskripsi.setText(mData.get(position).getDeskripsi());
        holder.tvTanggal.setText(parseDate.getParse(mData.get(position).getRelease()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("backdrop",mData.get(position).getBackdrop_path());
                intent.putExtra("title",mData.get(position).getJudul());
                intent.putExtra("overview",mData.get(position).getDeskripsi());
                intent.putExtra("daterelease",mData.get(position).getRelease());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Poster;
        TextView judul, tvDeskripsi, tvTanggal;
        public ViewHolder(View itemView) {
            super(itemView);
            Poster = (ImageView)itemView.findViewById(R.id.posterlist);
            judul = (TextView) itemView.findViewById(R.id.judulMovie);
            tvDeskripsi=(TextView) itemView.findViewById(R.id.deskripsi);
            tvTanggal =(TextView) itemView.findViewById(R.id.dateRelease);
        }
    }

}
