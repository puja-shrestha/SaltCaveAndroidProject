package com.example.puza.saltcave.fragments;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.adapter.ProductAdapter;
import com.example.puza.saltcave.adapter.ServicesAdapter;
import com.example.puza.saltcave.model.ProductItems;
import com.example.puza.saltcave.model.ServicesItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ServicesAdapter servicesAdapter;
    private List<ServicesItem> servicesList;

    public ServicesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        servicesList = new ArrayList<>();
        servicesAdapter = new ServicesAdapter(getContext(), servicesList);

        RecyclerView.LayoutManager nLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(nLayoutManager);
        recyclerView.addItemDecoration(new ServicesFragment.GridSpacingItemDecoration(2, dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(servicesAdapter);

        prepareAlbums();

        return view;
    }

    private void prepareAlbums(){
        int[] covers = new int[]{
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10
        };
        ServicesItem a =new ServicesItem("Beauty Products", covers[0]);
        servicesList.add(a);
        a =new ServicesItem("Herbal Soap", covers[1]);
        servicesList.add(a);
        a =new ServicesItem("Hair Oil", covers[2]);
        servicesList.add(a);
        a =new ServicesItem("Patanjali Facewash", covers[3]);
        servicesList.add(a);
        a =new ServicesItem("Herbal Oil", covers[4]);
        servicesList.add(a);
        a =new ServicesItem("Herbal Cream", covers[5]);
        servicesList.add(a);
        a =new ServicesItem("Spa and Massage", covers[6]);
        servicesList.add(a);
        a =new ServicesItem("Syampo", covers[7]);
        servicesList.add(a);
        a =new ServicesItem("Yoga", covers[8]);
        servicesList.add(a);
        a =new ServicesItem("Green Tea", covers[9]);
        servicesList.add(a);

        servicesAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration{

        private int spanCount;
        private int spacing;
        private boolean inclidEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean inclidEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.inclidEdge = inclidEdge;
        }

        public void getItemOffsets(Rect outrect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view); //item position
            int column = position % spanCount; //item columns

            if (inclidEdge){
                outrect.left = spacing - column * spacing / spanCount;
                outrect.right = (column + 1) * spacing / spanCount;

                if (position < spanCount){
                    outrect.top = spacing;
                }
                outrect.bottom = spacing;
            }else {
                outrect.left = column * spacing / spanCount;
                outrect.right = spacing - (column + 1) * spacing / spanCount;
                if(position>=spanCount){
                    outrect.top = spacing;
                }
            }
        }
    }

    private int dpToPx(int dp){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

}
