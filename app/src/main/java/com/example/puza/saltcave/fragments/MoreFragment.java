package com.example.puza.saltcave.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.saltcave.R;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

//    DayScrollDatePicker mPicker;


    public MoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

//        mPicker = (DayScrollDatePicker) findViewById(R.id.day_date_picker);
//
//        mPicker.setStartDate(10, 10, 2010);
//        mPicker.setEndDate(11, 11, 2011);
//
//        mPicker.getSelectedDate(new OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(@Nullable Date date) {
//                if(date != null){
//                    // do something with selected date
//                }
//            }
//        });

        return view;
    }

}
