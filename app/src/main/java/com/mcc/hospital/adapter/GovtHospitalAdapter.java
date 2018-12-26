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
import com.mcc.hospital.activity.MapViewActivity;
import com.mcc.hospital.model.Hospitalname;

import java.util.ArrayList;

public class GovtHospitalAdapter extends RecyclerView.Adapter<GovtHospitalAdapter.MyViewHolder> {

    ArrayList<Hospitalname> hospitalnameArrayList;
    Context context;
    GovtHospitalAdapter.MyViewHolder viewHoldertext;

    public GovtHospitalAdapter(Context context,ArrayList<Hospitalname> hospitalname) {
        this.context = context;
        this.hospitalnameArrayList = hospitalname;
    }

    @Override
    public GovtHospitalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_govt_hospital, parent, false);
        viewHoldertext = new GovtHospitalAdapter.MyViewHolder(v);
        return viewHoldertext;
    }

    @Override
    public void onBindViewHolder(@NonNull GovtHospitalAdapter.MyViewHolder myViewHolder, int position) {

        Glide.with(context).load(hospitalnameArrayList.get(position).getHospitalLogoUrl()).into(myViewHolder.imghospital);
        myViewHolder.txthospitalname.setText(hospitalnameArrayList.get(position).getHospitalName());
        myViewHolder.txthospitaladdress.setText(hospitalnameArrayList.get(position).getHospitalAddress());
        myViewHolder.txthospitalphone.setText(hospitalnameArrayList.get(position).getHospitalContact().toString());

    }

    @Override
    public int getItemCount() {
        return hospitalnameArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imghospital;
        TextView txthospitalname,txthospitaladdress,txthospitalphone;


        public MyViewHolder(View itemView) {
            super(itemView);

            imghospital = itemView.findViewById(R.id.img_hospital_logo);
            txthospitalname = itemView.findViewById(R.id.txt_hospital_name);
            txthospitaladdress = itemView.findViewById(R.id.txt_hospital_location);
            txthospitalphone = itemView.findViewById(R.id.txt_hospital_phone);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, MapViewActivity.class);
                    Hospitalname hospitalname = hospitalnameArrayList.get(getAdapterPosition());
                    intent.putExtra("HOSPITAL_OBJECT", hospitalname);
                    context.startActivity(intent);
                }
            });

        }
    }
}