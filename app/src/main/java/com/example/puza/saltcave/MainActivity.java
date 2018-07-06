package com.example.puza.saltcave;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.puza.saltcave.fragments.appointment.AppointmentFragment;
import com.example.puza.saltcave.fragments.FeaturedFragment;
import com.example.puza.saltcave.fragments.GalleryFragment;
import com.example.puza.saltcave.fragments.HomeFragment;
import com.example.puza.saltcave.fragments.MoreFragment;
import com.example.puza.saltcave.fragments.ProductsFragment;
import com.example.puza.saltcave.fragments.ServicesFragment;
import com.example.puza.saltcave.fragments.SettingFragment;
import com.example.puza.saltcave.helper.BottomNavigationHelper;

public class
MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String SELECTED_ITEM = "arg_selected_item";

    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    FragmentTransaction transaction;

    Toolbar toolbar;
    TextView toolbarTitle;

    ImageView searchIcon;
    EditText search;

    private DrawerLayout mDrawerLayout;

    ImageView imageView;
    ImageView notificationIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbarTitle = (TextView) findViewById(R.id.toolbarName);

        setSupportActionBar(toolbar);
        setUpBottomNavigation();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);


        imageView = (ImageView)findViewById(R.id.navigationMenu);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });


        notificationIcon = (ImageView)findViewById(R.id.notificationIcon);
        notificationIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(2);
        if (mSelectedItem != homeItem.getItemId()) {
            // select home item
            selectFragment(homeItem);
        } else if (mSelectedItem == homeItem.getItemId()) {
            onBackPressed();

        }
    }

    private void setUpBottomNavigation() {
        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(mBottomNav);
        if (mBottomNav != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = mBottomNav.getMenu();
            selectFragment(menu.getItem(2));
            mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    selectFragment(item);
                    return true;
                }
            });
        }

    }

    private void selectFragment(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.menu_featured:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new FeaturedFragment());
                toolbarTitle.setText("Featured");
                break;
            case R.id.menu_services:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new ServicesFragment());
                toolbarTitle.setText("Services");
                break;
            case R.id.menu_home:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HomeFragment());
                toolbarTitle.setText("Home");
                break;
            case R.id.menu_products:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new ProductsFragment());
                toolbarTitle.setText("Products");
                break;
            case R.id.menu_more:
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new MoreFragment());
                toolbarTitle.setText("More");
                break;
        }
        transaction.commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        int id = item.getItemId();

        if( id == R.id.home){
            fragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.appointment){
            fragment = new AppointmentFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();


        }else if (id == R.id.product){
            fragment = new ProductsFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.service){
            fragment = new ServicesFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.gallery){
            fragment = new GalleryFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }else if (id == R.id.settings){
            fragment = new SettingFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

        }

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}