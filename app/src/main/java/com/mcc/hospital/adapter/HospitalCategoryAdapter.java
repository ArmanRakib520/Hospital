package com.mcc.hospital.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mcc.hospital.R;

import java.util.ArrayList;

public class HospitalCategoryAdapter extends RecyclerView.Adapter<HospitalCategoryAdapter.MyViewHolder> {


    ArrayList<String> hospitalName;
    ArrayList<Integer> hospitalImage;
    Context context;
    HospitalCategoryAdapter.MyViewHolder viewHoldertext;

    public HospitalCategoryAdapter(Context context, ArrayList<String> hospitalNames, ArrayList<Integer> hospitalImages) {
        this.context = context;
        this.hospitalName = hospitalNames;
        this.hospitalImage = hospitalImages;
    }

    @Override
    public HospitalCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital_category, parent, false);
        viewHoldertext = new HospitalCategoryAdapter.MyViewHolder(v);
        return viewHoldertext;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Glide.with(context).load(hospitalImage.get(i)).into(myViewHolder.imghospital);
        myViewHolder.txthospitalname.setText(hospitalName.get(i));

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return hospitalImage.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imghospital;
        TextView txthospitalname;


        public MyViewHolder(View itemView) {
            super(itemView);

            imghospital = itemView.findViewById(R.id.img_hospital);
            txthospitalname = itemView.findViewById(R.id.txt_hos_name);

        }
    }
}