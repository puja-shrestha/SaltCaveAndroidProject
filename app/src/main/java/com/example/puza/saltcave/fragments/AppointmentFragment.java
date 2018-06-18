package com.example.puza.saltcave.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    TextView textView;

    RecyclerView appointmentRecyclerView;
    private RecyclerView.LayoutManager aLayoutManager;
    AppointmentAdapter appointmentAdapter;
    List<AppointmentItem> appointmentItems;

    public AppointmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment, container, false);

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


//        //<------------------------ Horizontal date picker -------------------------->
//        textView = (TextView)view.findViewById(R.id.textView);
//
//        Calendar startDate = Calendar.getInstance();
//        startDate.add(Calendar.MONTH, -1);
//
//        Calendar endDate = Calendar.getInstance();
//        endDate.add(Calendar.MONTH, 1);
//
//        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
//                .range(startDate, endDate)
//                .datesNumberOnScreen(5)
//                .build();
//
//        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
//            @Override
//            public void onDateSelected(Calendar date, int position) {
//                //do something
//            }
//        });
//
//        //<------------------------ Horizontal date picker -------------------------->


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
