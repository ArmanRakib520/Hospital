package com.mcc.hospital.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mcc.hospital.R;
import com.mcc.hospital.model.Hospitalname;

public class MapViewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView name,address,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        imageView=findViewById(R.id.iv_hospital_image);
        name=findViewById(R.id.tv_hospital_name);
        address=findViewById(R.id.tv_hospital_address);
        phone=findViewById(R.id.tv_hospital_phone);


        Hospitalname hospitalname = getIntent().getParcelableExtra("HOSPITAL_OBJECT");

        //imageView.setImageResource(Integer.parseInt(hospitalname.getHospitalLogoUrl()));
        Glide.with(MapViewActivity.this)
                .load(hospitalname.getHospitalLogoUrl())
                .into(imageView);

        name.setText(hospitalname.getHospitalName());
        address.setText(hospitalname.getHospitalAddress());
        phone.setText(hospitalname.getHospitalContact().toString());


    }
}
