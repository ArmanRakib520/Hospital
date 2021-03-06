package com.mcc.hospital.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.mcc.hospital.R;
import com.mcc.hospital.adapter.GovtHospitalAdapter;
import com.mcc.hospital.api.HttpParams;
import com.mcc.hospital.api.RetrofitClient;
import com.mcc.hospital.model.HospitalList;
import com.mcc.hospital.model.Hospitalname;
import com.mcc.hospital.utilits.AppConstant;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrivateHospitalActivity extends AppCompatActivity {

    RecyclerView rvPrivateHospital;
    ArrayList<Hospitalname> hospitalNameList = new ArrayList();
    LinearLayoutManager mlayoutManager;
    GovtHospitalAdapter govtHospitalAdapter;
    private InterstitialAd mInterstitialAd;

    Context mContext;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariable();
        initView();
        initFuntionality();
    }

    private void initView() {
        setContentView(R.layout.activity_private_hospital);

        rvPrivateHospital=findViewById(R.id.rv_private_hospital);

        mlayoutManager = new LinearLayoutManager(getApplicationContext());
        rvPrivateHospital.setLayoutManager(mlayoutManager);


        govtHospitalAdapter = new GovtHospitalAdapter(PrivateHospitalActivity.this,hospitalNameList);
        rvPrivateHospital.setAdapter(govtHospitalAdapter);

        setupInterstialAd();

    }

    private void initVariable() {
        mContext = getApplicationContext();
        mActivity = PrivateHospitalActivity.this;

    }

    private void initFuntionality() {
        loadHospital();
    }

    private void setupInterstialAd() {
        mInterstitialAd = new InterstitialAd(PrivateHospitalActivity.this);
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.full_screen_ad_unit_id));

        AdRequest adRequestFull = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequestFull);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                // Full screen advertise will show only after loading complete
                mInterstitialAd.show();
            }
        });
    }

    private void loadHospital() {

        // progressBar.setVisibility(View.VISIBLE);
        RetrofitClient.getClient().getHospitalList(HttpParams.SHEET_ID , HttpParams.SHEET_NAME).enqueue(new Callback<HospitalList>() {
            @Override
            public void onResponse(Call<HospitalList> call , Response<HospitalList> response) {

                AppConstant.ALL_HOSPITAL_LIST.clear();
                AppConstant.ALL_HOSPITAL_LIST.addAll(response.body().getHospitalname());

                if (!hospitalNameList.isEmpty()) {
                    hospitalNameList.clear();
                }

                for(int i=0; i<response.body().getHospitalname().size(); i++){
                    if(response.body().getHospitalname().get(i).getCategoryId() == 1){
                        hospitalNameList.add(response.body().getHospitalname().get(i));
                    }
                }

                govtHospitalAdapter.notifyDataSetChanged();
                //progressBar.setVisibility(View.GONE);
                //rvGovtHospital.setVisibility(View.VISIBLE);
            }


            @Override
            public void onFailure(Call<HospitalList> call , Throwable t) {
                Log.d("TimeTesting" , "Second Req DetailsDataNotFound");
            }

        });

    }
}
