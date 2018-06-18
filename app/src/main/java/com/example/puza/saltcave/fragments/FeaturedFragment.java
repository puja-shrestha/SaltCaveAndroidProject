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
import com.example.puza.saltcave.adapter.FeaturedRecycler;
import com.example.puza.saltcave.adapter.ProductAdapter;
import com.example.puza.saltcave.model.FeaturedItems;
import com.example.puza.saltcave.model.ProductItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeaturedFragment extends Fragment {

    private RecyclerView recyclerView;
    private FeaturedRecycler featuredAdapter;
    Context pContext;
    private List<FeaturedItems> featuredList;


    public FeaturedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_featured, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.featured_recycler_view);

        featuredList = new ArrayList<>();
        featuredAdapter = new FeaturedRecycler(getActivity(), featuredList);

        RecyclerView.LayoutManager nLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(nLayoutManager);
        recyclerView.addItemDecoration(new FeaturedFragment.GridSpacingItemDecoration(1, dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(featuredAdapter);

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
        FeaturedItems a =new FeaturedItems(covers[0], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[0], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[1], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[3], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[4], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[5], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[6], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[7], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[8], "Herbal soup", "$6.77");
        featuredList.add(a);
        a =new FeaturedItems(covers[9], "Herbal soup", "$6.77");
        featuredList.add(a);

        featuredAdapter.notifyDataSetChanged();
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
