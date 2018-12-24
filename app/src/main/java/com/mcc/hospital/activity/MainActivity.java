package com.mcc.hospital.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mcc.hospital.R;
import com.mcc.hospital.adapter.HospitalCategoryAdapter;
import com.mcc.hospital.adapter.SlidingImageAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.img1 , R.drawable.img2 , R.drawable.img4 , R.drawable.img5};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    Toolbar toolbar;
    DrawerLayout mdrawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    ArrayList hospitalImage,hospitalName;
    RecyclerView rvhospitalName;
    LinearLayoutManager mLayoutManager;
    HospitalCategoryAdapter hospitalCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initeVariable();
        initview();

    }

    private void initview() {

        rvhospitalName=findViewById(R.id.rv_hospital_category);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mdrawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this , mdrawer , toolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        mdrawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager =findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImageAdapter(MainActivity.this , ImagesArray));


        NUM_PAGES = IMAGES.length;

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++ , true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        } , 3000 , 3000);



        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvhospitalName.setLayoutManager(mLayoutManager);


        hospitalCategoryAdapter = new HospitalCategoryAdapter(MainActivity.this, hospitalName, hospitalImage);
        rvhospitalName.setAdapter(hospitalCategoryAdapter);

    }

   public void initeVariable(){
       hospitalImage = new ArrayList<>(Arrays.asList(R.drawable.govt_logo, R.drawable.privatehospital, R.drawable.clinic));
       hospitalName = new ArrayList<>(Arrays.asList("Govt. Medical College & Hospital", "Private Medical College & Hospital", "Clinic"));
   }


    @Override
    public void onBackPressed() {
        mdrawer =  findViewById(R.id.drawer_layout);
        if (mdrawer.isDrawerOpen(GravityCompat.START)) {
            mdrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_govt_hospital) {
            Intent intent=new Intent(getApplicationContext(),GovtHospitalActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_private_hospital) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_about) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
