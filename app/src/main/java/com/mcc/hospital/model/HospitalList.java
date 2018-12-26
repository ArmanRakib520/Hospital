package com.mcc.hospital.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HospitalList {

    @SerializedName("hospitalname")
    @Expose
    private ArrayList<Hospitalname> hospitalname = null;

    public ArrayList<Hospitalname> getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(ArrayList<Hospitalname> hospitalname) {
        this.hospitalname = hospitalname;
    }

}
