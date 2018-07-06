package com.example.puza.saltcave.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.puza.saltcave.R;
import com.example.puza.saltcave.adapter.ProductAdapter;
import com.example.puza.saltcave.model.ProductItems;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    Context pContext;
    private List<ProductItems> productList;

    ToggleButton toggleButton;
    AlertDialog myDialog;
    TextView button_sortby;


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        productList = new ArrayList<>();
        productAdapter = new ProductAdapter(getContext(), productList);

        RecyclerView.LayoutManager nLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(nLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);

        prepareAlbums();

        button_sortby = (TextView) view.findViewById(R.id.button_sortby);
        button_sortby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Alertdialog();

            }
        });

        return view;
    }



    public void Alertdialog(){
        final CharSequence[] items = {" Best Rating "," Price up "," Price down "," New "};

        // arraylist to keep the selected items
        final ArrayList seletedItems=new ArrayList();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Short by");
        builder.setMultiChoiceItems(items, null,
                new DialogInterface.OnMultiChoiceClickListener() {
                    // indexSelected contains the index of item (of which checkbox checked)
                    @Override
                    public void onClick(DialogInterface dialog, int indexSelected,
                                        boolean isChecked) {
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            // write your code when user checked the checkbox
                            seletedItems.add(indexSelected);
                        } else if (seletedItems.contains(indexSelected)) {
                            // Else, if the item is already in the array, remove it
                            // write your code when user Uchecked the checkbox
                            seletedItems.remove(Integer.valueOf(indexSelected));
                        }
                    }
                })
                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on OK
                        //  You can write the code  to save the selected item here

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //  Your code when user clicked on Cancel

                    }
                });

        myDialog = builder.create();//AlertDialog dialog; create like this outside onClick
        myDialog.show();
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
        ProductItems a =new ProductItems("Beauty Products", "$6.77", covers[0]);
        productList.add(a);
        a =new ProductItems("Herbal Soap", "$8.95", covers[1]);
        productList.add(a);
        a =new ProductItems("Hair Oil", "$4.5", covers[2]);
        productList.add(a);
        a =new ProductItems("Patanjali Facewash", "$8.6", covers[3]);
        productList.add(a);
        a =new ProductItems("Herbal Oil", "$10.4", covers[4]);
        productList.add(a);
        a =new ProductItems("Herbal Cream", "$110", covers[5]);
        productList.add(a);
        a =new ProductItems("Spa and Massage", "$42.6", covers[6]);
        productList.add(a);
        a =new ProductItems("Syampo", "$5.7", covers[7]);
        productList.add(a);
        a =new ProductItems("Yoga", "$44.4", covers[8]);
        productList.add(a);
        a =new ProductItems("Green Tea", "$21.4", covers[9]);
        productList.add(a);

        productAdapter.notifyDataSetChanged();
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
