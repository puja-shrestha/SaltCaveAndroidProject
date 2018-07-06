package com.example.puza.saltcave.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.puza.saltcave.R;
import com.example.puza.saltcave.model.ProductItems;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context mContext;
    private List<ProductItems> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title, price;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }

    public ProductAdapter(Context mContext, List<ProductItems> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_product, parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final ProductAdapter.MyViewHolder holder, int position) {
        ProductItems album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.price.setText(album.getPrice());

        //locating album cover using glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


}
