package com.example.crud.rest;

import com.example.crud.model.BaseResponse;
import com.example.crud.model.GetListNasabah;
import com.example.crud.model.GetNasabah;
import com.example.crud.model.Nasabah;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiInterface {
    //nampilin list di main activity
    @GET("/api/nasabah/list")
    Call<GetListNasabah> getListNasabah();
    //nampilin data lengkap dari api
    @GET("api/nasabah/{userId}")
    Call<GetNasabah> getNasabah(@Path("userId") String userId);
    //edit data
    @PUT("api/nasabah/{userId}")
    Call<BaseResponse> putNasabah(@Path("userId") String userId,
                                  @Body JsonObject o);
    @POST("api/nasabah")
    Call<BaseResponse> postNasabah(@Body JsonObject o);

    @DELETE("api/nasabah/{userId}")
    Call<BaseResponse> delNasabah (@Path("userId") String userId);
}
