package com.example.puza.saltcave.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.puza.saltcave.R;
import com.example.puza.saltcave.adapter.FeatureRecycler;
import com.example.puza.saltcave.adapter.ServiceRecycler;
import com.example.puza.saltcave.model.FeatureItems;
import com.example.puza.saltcave.model.ServiceItems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //slider
//    private SliderPagerAdapter mAdapter;
//    private SliderIndicator mIndicator;

    //    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    Button abook_button;

    private SliderLayout mDemoSlider;


    /*---------------featured items----------------------*/
    RecyclerView featuredRecyclerView;
    private RecyclerView.LayoutManager fLayoutManager;
    FeatureRecycler featuredAdapter;
    List<FeatureItems> featuredItems;
    /*---------------------------------------------------*/

    /*-------------------popular Items-------------------*/
    RecyclerView serviceRecyclerView;
    private RecyclerView.LayoutManager sLayoutManager;
    ServiceRecycler serviceAdapter;
    List<ServiceItems> serviceItems;
    /*---------------------------------------------------*/

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //book appointment button
        abook_button = (Button) view.findViewById(R.id.abook_button);
        abook_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppointmentFragment fragmment = new AppointmentFragment();
                FragmentTransaction transaction = ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragmment);
                transaction.commit();
            }
        });

        mDemoSlider = (SliderLayout)view.findViewById(R.id.sliderView);

//        //slider
//        sliderView = (SliderView) view.findViewById(R.id.sliderView);
//        mLinearLayout = (LinearLayout) view.findViewById(R.id.pagesContainer);
//        setupSlider();

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Herbal Soup",R.drawable.image3);
        file_maps.put("Health Care",R.drawable.image2);
        file_maps.put("Massage and Spa",R.drawable.image7);
        file_maps.put("Hair Products", R.drawable.image5);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(2000);


        /*------------------Featured Items--------------------------*/
        featuredRecyclerView = (RecyclerView) view.findViewById(R.id.featuredRecycler);

        featuredItems = getFeaturedItems();

        featuredRecyclerView.setHasFixedSize(true);

        fLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        featuredRecyclerView.setLayoutManager(fLayoutManager);
        featuredAdapter = new FeatureRecycler(getActivity(), featuredItems);
        featuredRecyclerView.setAdapter(featuredAdapter);

        /*------------------------------------------------------------*/

        /*-------------Service Items-----------------------------*/

        serviceRecyclerView = (RecyclerView) view.findViewById(R.id.serviceRecycler);

        serviceItems = getServiceItems();

        serviceRecyclerView.setHasFixedSize(true);

        sLayoutManager = new LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                false
        );
        serviceRecyclerView.setLayoutManager(sLayoutManager);
        serviceAdapter = new ServiceRecycler(getActivity(), serviceItems);
        serviceRecyclerView.setAdapter(serviceAdapter);
        /*------------------------------------------------------------*/

        return view;
    }



    //slider
//    private void setupSlider() {
//        sliderView.setDurationScroll(800);
//        List<Fragment> fragments = new ArrayList<>();
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
//        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));
//
//        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
//        sliderView.setAdapter(mAdapter);
//        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
//        mIndicator.setPageCount(fragments.size());
//        mIndicator.show();
//    }


    private List<FeatureItems> getFeaturedItems() {
        featuredItems = new ArrayList<FeatureItems>();


        featuredItems.add(new FeatureItems(R.drawable.image4, "Product one", "$10.00"));
        featuredItems.add(new FeatureItems(R.drawable.image5, "Product two", "$20.00"));
        featuredItems.add(new FeatureItems(R.drawable.image7, "Product three", "$15.00"));
        featuredItems.add(new FeatureItems(R.drawable.image9, "Product four", "$11.00"));
        featuredItems.add(new FeatureItems(R.drawable.image6, "Product five", "$33.00"));
        featuredItems.add(new FeatureItems(R.drawable.image2, "Product six", "$9.00"));

        return featuredItems;
    }

    private List<ServiceItems> getServiceItems() {
        serviceItems = new ArrayList<ServiceItems>();


        serviceItems.add(new ServiceItems(R.drawable.image6, "Service one", "$10.00"));
        serviceItems.add(new ServiceItems(R.drawable.image8, "Service two", "$10.00"));
        serviceItems.add(new ServiceItems(R.drawable.image10, "Service three", "$10.00"));
        serviceItems.add(new ServiceItems(R.drawable.image1, "Service four", "$10.00"));
        serviceItems.add(new ServiceItems(R.drawable.image2, "Service five", "$10.00"));
        serviceItems.add(new ServiceItems(R.drawable.image3, "Service six", "$10.00"));

        return serviceItems;
    }

}
