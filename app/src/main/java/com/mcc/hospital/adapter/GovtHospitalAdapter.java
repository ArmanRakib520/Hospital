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
import com.mcc.hospital.R;
import java.util.ArrayList;

public class GovtHospitalAdapter extends RecyclerView.Adapter<GovtHospitalAdapter.MyViewHolder> {


    ArrayList<String> govtHospitalName;
    ArrayList<String> govtHospitalAddress;
    ArrayList<String> govtHospitalPhone;
    ArrayList<Integer> govtHospitalImage;
    Context context;
    GovtHospitalAdapter.MyViewHolder viewHoldertext;

    public GovtHospitalAdapter(Context context, ArrayList<String> govtHospitalNames, ArrayList<Integer> govtHospitalImage, ArrayList<String> govtHospitalAddress, ArrayList<String> govtHospitalPhone) {
        this.context = context;
        this.govtHospitalName = govtHospitalNames;
        this.govtHospitalImage = govtHospitalImage;
        this.govtHospitalAddress = govtHospitalAddress;
        this.govtHospitalPhone = govtHospitalPhone;
    }

    @Override
    public GovtHospitalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_govt_hospital, parent, false);
        viewHoldertext = new GovtHospitalAdapter.MyViewHolder(v);
        return viewHoldertext;
    }

    @Override
    public void onBindViewHolder(@NonNull GovtHospitalAdapter.MyViewHolder myViewHolder, int i) {

        //Glide.with(context).load(hospitalImage.get(i)).into(myViewHolder.imghospital);
        myViewHolder.txthospitalname.setText(govtHospitalName.get(i));
        myViewHolder.txthospitaladdress.setText(govtHospitalAddress.get(i));
        myViewHolder.txthospitalphone.setText(govtHospitalPhone.get(i));
        myViewHolder.imghospital.setImageResource(govtHospitalImage.get(i));


        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return govtHospitalName.size();
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

        }
    }
}