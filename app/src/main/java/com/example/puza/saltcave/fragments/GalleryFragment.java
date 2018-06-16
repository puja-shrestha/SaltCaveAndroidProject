//package com.example.puza.saltcave.fragments;
//
//
//import android.database.DataSetObserver;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListAdapter;
//
//
//import com.example.puza.saltcave.R;
//import com.felipecsl.asymmetricgridview.library.Utils;
//import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
//import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
//import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class GalleryFragment extends Fragment {
//
//    AsymmetricGridView listView;
//    ListAdapter adapter;
//
//    public GalleryFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
//
//        listView = (AsymmetricGridView) view.findViewById(R.id.listView);
//
//        // Choose your own preferred column width
//        listView.setRequestedColumnWidth(Utils.dpToPx(getContext(), 120));
//        final List<AsymmetricItem> items = new ArrayList<>();
//
//        // initialize your items array
//        adapter = new ListAdapter() {
//            @Override
//            public boolean areAllItemsEnabled() {
//                return false;
//            }
//
//            @Override
//            public boolean isEnabled(int position) {
//                return false;
//            }
//
//            @Override
//            public void registerDataSetObserver(DataSetObserver observer) {
//
//            }
//
//            @Override
//            public void unregisterDataSetObserver(DataSetObserver observer) {
//
//            }
//
//            @Override
//            public int getCount() {
//                return 0;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public boolean hasStableIds() {
//                return false;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                return null;
//            }
//
//            @Override
//            public int getItemViewType(int position) {
//                return 0;
//            }
//
//            @Override
//            public int getViewTypeCount() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//        }
//        AsymmetricGridViewAdapter asymmetricAdapter =
//                new AsymmetricGridViewAdapter<>(getContext(), listView, adapter);
//        listView.setAdapter(asymmetricAdapter);
//
//        return  view;
//
//    }
//
//}
