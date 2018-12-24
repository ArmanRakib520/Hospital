package com.mcc.hospital.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hospitalname {

    @SerializedName("hospital_id")
    @Expose
    private Integer hospitalId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("hospital_name")
    @Expose
    private String hospitalName;
    @SerializedName("hospital_address")
    @Expose
    private String hospitalAddress;
    @SerializedName("hospital_contuct")
    @Expose
    private Integer hospitalContuct;
    @SerializedName("hospital_logo_url")
    @Expose
    private String hospitalLogoUrl;

    public Hospitalname(int hospital_id , int category_id , String hospital_name , String hospital_address , int hospital_contuct , String hospital_logo_url) {

        this.hospitalId=hospital_id;
        this.categoryId=category_id;
        this.hospitalName=hospital_name;
        this.hospitalAddress=hospital_address;
        this.hospitalContuct=hospital_contuct;
        this.hospitalLogoUrl=hospital_logo_url;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public Integer getHospitalContuct() {
        return hospitalContuct;
    }

    public void setHospitalContuct(Integer hospitalContuct) {
        this.hospitalContuct = hospitalContuct;
    }

    public String getHospitalLogoUrl() {
        return hospitalLogoUrl;
    }

    public void setHospitalLogoUrl(String hospitalLogoUrl) {
        this.hospitalLogoUrl = hospitalLogoUrl;
    }
}
