package com.mcc.hospital.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.mcc.hospital.activity.ClinicActivity;
import com.mcc.hospital.activity.GovtHospitalActivity;
import com.mcc.hospital.activity.PrivateHospitalActivity;
import com.mcc.hospital.model.Category;

import java.util.ArrayList;

public class HospitalCategoryAdapter extends RecyclerView.Adapter<HospitalCategoryAdapter.MyViewHolder> {


    ArrayList<Category> categories;
    Context context;
    HospitalCategoryAdapter.MyViewHolder viewHoldertext;

    public HospitalCategoryAdapter(Context context, ArrayList<Category> hospitalNames) {
        this.context = context;
        this.categories = hospitalNames;

    }

    @Override
    public HospitalCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital_category, parent, false);
        viewHoldertext = new HospitalCategoryAdapter.MyViewHolder(v);
        return viewHoldertext;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int position) {

        Glide.with(context).load(categories.get(position).getCategoryLogo()).into(myViewHolder.imgcategory);
        myViewHolder.txthospitalcategoryname.setText(categories.get(position).getCategoryName());



        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position==0){
                    Intent govthospital=new Intent(context,GovtHospitalActivity.class);
                    context.startActivity(govthospital);
                }else if (position==1){
                    Intent govthospital=new Intent(context,PrivateHospitalActivity.class);
                    context.startActivity(govthospital);
                }else if (position==2){
                    Intent govthospital=new Intent(context,ClinicActivity.class);
                    context.startActivity(govthospital);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imgcategory;
        TextView txthospitalcategoryname;


        public MyViewHolder(View itemView) {
            super(itemView);

            txthospitalcategoryname = itemView.findViewById(R.id.txt_hos_name);
            imgcategory=itemView.findViewById(R.id.img_hospital);

        }
    }
}