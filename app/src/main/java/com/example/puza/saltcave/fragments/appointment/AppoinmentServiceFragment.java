package com.example.puza.saltcave.fragments.appointment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.adapter.AppointmentAdapter;
import com.example.puza.saltcave.model.AppointmentItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppoinmentServiceFragment extends Fragment {
    RecyclerView appointmentRecyclerView;
    private RecyclerView.LayoutManager aLayoutManager;
    AppointmentAdapter appointmentAdapter;
    List<AppointmentItem> appointmentItems;

    CheckBox checkBox;

    public AppoinmentServiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appoinment_service, container, false);

        appointmentRecyclerView = (RecyclerView) view.findViewById(R.id.appointmentRecyclerView);

        appointmentItems = getAppointmentItems();

        appointmentRecyclerView.setHasFixedSize(true);


        aLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        appointmentRecyclerView.setLayoutManager(aLayoutManager);
        appointmentAdapter = new AppointmentAdapter(getActivity(), appointmentItems);
        appointmentRecyclerView.setAdapter(appointmentAdapter);


        //checkbox

        checkBox=(CheckBox) view.findViewById(R.id.checkBox1);


    return view;
    }

    private List<AppointmentItem> getAppointmentItems() {
        appointmentItems = new ArrayList<AppointmentItem>();

        appointmentItems.add(new AppointmentItem(R.drawable.one, "Pashmina Arts, made by Nepal Hand"));
        appointmentItems.add(new AppointmentItem(R.drawable.image2, "Pashmina Arts, made by Nepal Hand"));
        appointmentItems.add(new AppointmentItem(R.drawable.one, "Pashmina Arts, made by Nepal Hand"));

        return appointmentItems;
    }

}
