package com.example.puza.saltcave.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.model.ServiceItems;

import java.util.List;

public class ServiceRecycler extends RecyclerView.Adapter<ServiceRecycler.MyViewHolder> {

    private List<ServiceItems> itemList;
    Activity context;

    public ServiceRecycler(Activity context, List<ServiceItems> itemList) {
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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_service, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final ServiceItems items = itemList.get(position);
        holder.name.setText(items.getName());
        holder.price.setText(items.getPrice());
        holder.image.setImageResource(items.getImage());

    }

    @Override
    public int getItemCount() {

        return this.itemList.size();
    }

}
