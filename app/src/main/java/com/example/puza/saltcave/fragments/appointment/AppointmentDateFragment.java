package com.example.puza.saltcave.fragments.appointment;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.puza.saltcave.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppointmentDateFragment extends Fragment {

   private TextView chooseTime, selectDate;

    public AppointmentDateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_appointment_date, container, false);

        chooseTime = view.findViewById(R.id.etChooseTime);
        chooseTime.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);

            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        chooseTime.setText(hourOfDay + ":" + minutes);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });


        selectDate = view.findViewById(R.id.btnDate);
       // final TextView date = view.findViewById(R.id.tvSelectedDate);

        selectDate.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                selectDate.setText(day + "/" + month + "/" + year);

                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.show();
            }
        });


        return view;
    }

}
