package com.example.crudunittesting.rest;

import com.example.crudunittesting.model.BaseResponse;
import com.example.crudunittesting.model.GetListNasabah;
import com.example.crudunittesting.model.GetNasabah;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/api/nasabah/list")
    Call<GetListNasabah> getListNasabah();

    @GET("api/nasabah/{userId}")
    Call<GetNasabah> getNasabah(@Path("userId") String userId);

    @PUT("api/nasabah/{userId}")
    Call<BaseResponse> putNasabah (@Path("userId") String userId,
                                   @Body JsonObject o);

    @POST("api/nasabah")
    Call<BaseResponse> postNasabah (@Body JsonObject o);

    @DELETE("api/nasabah/{userId}")
    Call<BaseResponse> delNasabah (@Path("userId") String userId);


}
