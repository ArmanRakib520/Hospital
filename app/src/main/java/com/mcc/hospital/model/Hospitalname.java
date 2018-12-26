package com.mcc.hospital.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hospitalname implements Parcelable {

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

    protected Hospitalname(Parcel in) {
        if (in.readByte() == 0) {
            hospitalId = null;
        } else {
            hospitalId = in.readInt();
        }
        if (in.readByte() == 0) {
            categoryId = null;
        } else {
            categoryId = in.readInt();
        }
        hospitalName = in.readString();
        hospitalAddress = in.readString();
        if (in.readByte() == 0) {
            hospitalContuct = null;
        } else {
            hospitalContuct = in.readInt();
        }
        hospitalLogoUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest , int flags) {
        if (hospitalId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hospitalId);
        }
        if (categoryId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(categoryId);
        }
        dest.writeString(hospitalName);
        dest.writeString(hospitalAddress);
        if (hospitalContuct == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hospitalContuct);
        }
        dest.writeString(hospitalLogoUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Hospitalname> CREATOR = new Creator<Hospitalname>() {
        @Override
        public Hospitalname createFromParcel(Parcel in) {
            return new Hospitalname(in);
        }

        @Override
        public Hospitalname[] newArray(int size) {
            return new Hospitalname[size];
        }
    };

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

    public Integer getHospitalContact() {
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
