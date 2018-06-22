package com.example.puza.saltcave.fragments.appointment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.adapter.AppointmentAdapter;
import com.example.puza.saltcave.model.AppointmentItem;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentFragment extends Fragment {

    private static final String SELECTED_ITEM = "arg_selected_item";
    private int aSelectedItem;
    FragmentTransaction transaction;

    private LinearLayout linearOne, linearTwo, linearThree, linearFour;



    public AppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_appointment, container, false);

        Fragment service = new AppoinmentServiceFragment();
        FragmentTransaction one =  getActivity().getSupportFragmentManager().beginTransaction();
        one.replace(R.id.appointment_container, service).addToBackStack(null).commit();

        linearOne = (LinearLayout)view.findViewById(R.id.linear_one);
        linearTwo = (LinearLayout)view.findViewById(R.id.linear_two);
        linearThree = (LinearLayout)view.findViewById(R.id.linear_three);
        linearFour = (LinearLayout)view.findViewById(R.id.linear_four);

        linearOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.setSelected(true);
                transportTo("service");
            }
        });

        linearTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.setSelected(true);
                transportTo("date");
            }
        });

        linearThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.setSelected(true);
                transportTo("info");
            }
        });

        linearFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                view.setSelected(true);
                transportTo("confirm");
            }
        });


        return view;
    }


    public void transportTo(String frag){
        switch (frag){

            case "service":
                Fragment service = new AppoinmentServiceFragment();
                FragmentTransaction one =  getActivity().getSupportFragmentManager().beginTransaction();
                one.replace(R.id.appointment_container, service).addToBackStack(null).commit();
                break;

                case "date":
                    Fragment date = new AppointmentDateFragment();
                    FragmentTransaction two=  getActivity().getSupportFragmentManager().beginTransaction();
                    two.replace(R.id.appointment_container, date).addToBackStack(null).commit();
                    break;

                case "info":
                Fragment info = new AppointmentInfoFragment();
                    FragmentTransaction three =  getActivity().getSupportFragmentManager().beginTransaction();
                    three.replace(R.id.appointment_container, info).addToBackStack(null).commit();
                    break;

                case "confirm":
                Fragment confirm = new AppointmentConfirmFragment();
                    FragmentTransaction four =  getActivity().getSupportFragmentManager().beginTransaction();
                    four.replace(R.id.appointment_container, confirm).addToBackStack(null).commit();
                    break;
        }
    }
}
