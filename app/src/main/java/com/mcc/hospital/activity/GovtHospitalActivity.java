package com.mcc.hospital.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mcc.hospital.R;
import com.mcc.hospital.adapter.GovtHospitalAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class GovtHospitalActivity extends AppCompatActivity {

    RecyclerView rvGovtHospital;
    ArrayList govtHospitalImage, govtHospitalName,govtHospitalAddress,govtHospitalPhone;
    LinearLayoutManager mlayoutManager;
    GovtHospitalAdapter govtHospitalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariable();
        initView();
    }


    private void initView() {
        setContentView(R.layout.activity_govt_hospital);

        rvGovtHospital=findViewById(R.id.rv_govt_hospital);

        mlayoutManager = new LinearLayoutManager(getApplicationContext());
        rvGovtHospital.setLayoutManager(mlayoutManager);


        govtHospitalAdapter = new GovtHospitalAdapter(GovtHospitalActivity.this, govtHospitalName, govtHospitalImage,govtHospitalAddress,govtHospitalPhone);
        rvGovtHospital.setAdapter(govtHospitalAdapter);

    }

    private void initVariable() {

        govtHospitalImage = new ArrayList<>(Arrays.asList(R.drawable.rmc, R.drawable.smomc, R.drawable.jmc));
        govtHospitalName = new ArrayList<>(Arrays.asList("Rajshahi Medical College", "Sylhet Osmangoni Medical College", "Jessore Medicale College"));
        govtHospitalAddress = new ArrayList<>(Arrays.asList("Rajshahi", "Sylhet", "Jessore"));
        govtHospitalPhone = new ArrayList<>(Arrays.asList("01747473856", "01747473856", "01747473856"));

    }


}
