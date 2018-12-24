package com.mcc.hospital.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HospitalList {

    @SerializedName("hospitalname")
    @Expose
    private List<Hospitalname> hospitalname = null;

    public List<Hospitalname> getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(List<Hospitalname> hospitalname) {
        this.hospitalname = hospitalname;
    }

}
