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
import com.example.puza.saltcave.model.ServicesItem;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.MyViewHolder> {

    private Context mContext;
    private List<ServicesItem> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View itemView) {
            super(itemView);
            title =(TextView) itemView.findViewById(R.id.title);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
//            overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }
    }

    public ServicesAdapter(Context mContext, List<ServicesItem> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public ServicesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_services, parent, false);
        return new ServicesAdapter.MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final ServicesAdapter.MyViewHolder holder, int position) {
        ServicesItem album = albumList.get(position);
        holder.title.setText(album.getName());
//        holder.price.setText(album.getPrice() + "$6.99");

        //locating album cover using glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

//        holder.overflow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                showPopupMenu(holder.overflow);
//            }
//        });
    }

//    private void showPopupMenu(View view){
//        //inflate menu
//
//        PopupMenu popup = new PopupMenu(mContext, view);
//        MenuInflater inflater = popup.getMenuInflater();
//        inflater.inflate(R.menu.menu_album, popup.getMenu());
//        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
//        popup.show();
//    }

    //click listener for popup menu item
//    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
//
//        public MyMenuItemClickListener() {
//        }
//
//        @Override
//        public boolean onMenuItemClick(MenuItem item) {
//            switch(menuItem.getItemId()) {
//                case R.id.action_add_favourite:
//                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
//
//            }
//            return false;
//        }
//    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


}
