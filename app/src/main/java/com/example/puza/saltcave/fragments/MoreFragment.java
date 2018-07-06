package com.example.puza.saltcave.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.puza.saltcave.R;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    private static int SPLASH_TIME_OUT = 4000;

    Animation rotateAnimation;
    ImageView imageView;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);


        imageView=(ImageView)view.findViewById(R.id.imageView);
        rotateAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                ServicesFragment fragmment = new ServicesFragment();
                FragmentTransaction transaction = ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragmment);
                transaction.commit();

            }
        },SPLASH_TIME_OUT);

        return view;
    }


    private void rotateAnimation() {

        rotateAnimation= AnimationUtils.loadAnimation(getContext(),R.anim.rotate);
        imageView.startAnimation(rotateAnimation);

    }

}
