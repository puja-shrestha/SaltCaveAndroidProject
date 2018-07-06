package com.example.puza.saltcave.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.model.FeatureItems;
import com.example.puza.saltcave.model.FeaturedItems;

import java.util.List;

    public class FeaturedRecycler extends RecyclerView.Adapter<FeaturedRecycler.MyViewHolder> {

    private List<FeaturedItems> itemList;
    Activity context;

    public FeaturedRecycler(Activity context, List<FeaturedItems> itemList) {
        this.itemList = itemList;
        this.context = context;
        }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        private ImageView image;

        public MyViewHolder(View view) {
            super(view);

        name = (TextView) view.findViewById(R.id.name);
        price = (TextView) view.findViewById(R.id.price);
        image = (ImageView) view.findViewById(R.id.image);

    }
}

    @Override
    public FeaturedRecycler.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_featured, parent, false);
        return new FeaturedRecycler.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeaturedRecycler.MyViewHolder holder, final int position) {

        final FeaturedItems items = itemList.get(position);
        holder.name.setText(items.getName());
        holder.price.setText(items.getPrice());
        holder.image.setImageResource(items.getImage());

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

}
