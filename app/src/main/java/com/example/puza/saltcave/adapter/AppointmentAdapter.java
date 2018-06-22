package com.example.puza.saltcave.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.model.AppointmentItem;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {

    private List<AppointmentItem> itemList;
    Activity context;
//    ImageView deleteIcon;
//    AlertDialog myDialog;

    public AppointmentAdapter(Activity context, List<AppointmentItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private CircleImageView image;


        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            image = (CircleImageView) view.findViewById(R.id.image);

            //delete icon click
//            deleteIcon = (ImageView)view.findViewById(R.id.deleteIcon);
//            deleteIcon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    //Toast.makeText(context, "icon clicked", Toast.LENGTH_SHORT).show();
//                    Alertdialog();
//                }
//            });

        }
    }


//    public void Alertdialog(){
//
//        myDialog = new AlertDialog.Builder(context).create();
//        myDialog.setTitle("Alert");
//        myDialog.setMessage("Are you sure?");
//        myDialog.setButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        myDialog.show();
//    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items_appointment, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final AppointmentItem items = itemList.get(position);
        holder.name.setText(items.getName());
        holder.image.setImageResource(items.getImage());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


}

