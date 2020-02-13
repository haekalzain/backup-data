package com.example.crud.model;

import com.google.gson.annotations.SerializedName;

public class GetNasabah extends BaseResponse{

    @SerializedName("data")
    Nasabah nasabah;



    public Nasabah getNasabah() {
        return nasabah;
    }

    public void setNasabah(Nasabah nasabah) {
        this.nasabah = nasabah;
    }
}
