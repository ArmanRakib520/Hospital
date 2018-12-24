package com.mcc.hospital.activity;

import android.app.Activity;
import android.content.Context;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.mcc.hospital.R;
import com.mcc.hospital.adapter.HospitalCategoryAdapter;
import com.mcc.hospital.adapter.SlidingImageAdapter;
import com.mcc.hospital.api.HttpParams;
import com.mcc.hospital.api.RetrofitClient;
import com.mcc.hospital.model.Category;
import com.mcc.hospital.model.CategoryList;
import com.mcc.hospital.utilits.AppConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES = {R.drawable.img1 , R.drawable.img2 , R.drawable.img4 , R.drawable.img5};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    ArrayList hospitalImage, hospitalName;
    RecyclerView rvhospitalName;
    LinearLayoutManager mLayoutManager;
    HospitalCategoryAdapter hospitalCategoryAdapter;
    ArrayList<Category> categoriesData;
    Context mContext;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initeVariable();
        initview();
        initFunctionality();

    }

    public void initeVariable() {

        mContext = getApplicationContext();
        mActivity = MainActivity.this;
        categoriesData = new ArrayList<>();

    }

    private void initview() {

        rvhospitalName = findViewById(R.id.rv_hospital_category);


        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = findViewById(R.id.pager);
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


        hospitalCategoryAdapter = new HospitalCategoryAdapter(MainActivity.this , hospitalName);
        rvhospitalName.setAdapter(hospitalCategoryAdapter);

        initToolbar();
        initDrawer();

    }


    private void initFunctionality() {

    }

    private void loadCategories() {

        RetrofitClient.getClient().getCategoryList(HttpParams.SHEET_ID, HttpParams.SHEET_NAME_CATEGORY).enqueue(new Callback<CategoryList>() {
            @Override
            public void onResponse(Call<CategoryList> call, Response<CategoryList> response) {

                AppConstant.ALL_CATEGORY_LIST.clear();
                AppConstant.ALL_CATEGORY_LIST.addAll(response.body().getCategory());

                if (!categoriesData.isEmpty()) {
                    categoriesData.clear();
                }
                categoriesData.addAll(response.body().getCategory());

            }

            @Override
            public void onFailure(Call<CategoryList> call, Throwable t) {
                Log.d("TimeTesting", "Second Req DetailsDataNotFound");
            }
        });
    }



    @Override
    public void onBackPressed() {
        mDrawerLayout = findViewById(R.id.drawer_layout);
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}
