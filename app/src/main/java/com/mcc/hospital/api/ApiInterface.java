package com.mcc.hospital.api;

import com.mcc.hospital.model.CategoryList;
import com.mcc.hospital.model.HospitalList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(HttpParams.SHEET_API_END_POINT)
    Call<HospitalList> getHospitalList(@Query("id") String sheetId, @Query("sheet") String sheetName);

    @GET(HttpParams.SHEET_API_END_POINT)
    Call<CategoryList> getCategoryList(@Query("id") String sheetId, @Query("sheet") String sheetName);

}
