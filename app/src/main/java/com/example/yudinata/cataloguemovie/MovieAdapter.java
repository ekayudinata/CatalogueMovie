package com.example.yudinata.cataloguemovie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<MovieItems> mData = new ArrayList<>();
    private Context context;


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
        holder.judul.setText(mData.get(position).getJudul());
        holder.tvDeskripsi.setText(mData.get(position).getDeskripsi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,mData.get(position).getJudul(),Toast.LENGTH_SHORT).show();
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
