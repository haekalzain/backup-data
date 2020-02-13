package com.example.crudunittesting.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudunittesting.R;
import com.example.crudunittesting.model.BaseResponse;
import com.example.crudunittesting.rest.ApiClient;
import com.example.crudunittesting.rest.ApiInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {

    Button btncreate;
    EditText namacreate,alamatcreate,emailcreate;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        findViewById();
        mApiInterface= ApiClient.getClient().create(ApiInterface.class);
        onClick();
    }

     void onClick() {
         btncreate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 JsonObject o= new JsonObject();
                 o.addProperty("nama",namacreate.getText().toString());
                 o.addProperty("alamat",alamatcreate.getText().toString());
                 o.addProperty("email",emailcreate.getText().toString());

                 Call<BaseResponse> nasabahCalled = mApiInterface.postNasabah(o);

                 nasabahCalled.enqueue(new Callback<BaseResponse>() {
                     @Override
                     public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                         if (response.isSuccessful()){
                             Intent intent = new Intent(CreateActivity.this,MainActivity.class);
                             startActivity(intent);
                         }else{
                             Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                         }
                     }

                     @Override
                     public void onFailure(Call<BaseResponse> call, Throwable t) {
                         Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                     }
                 });



             }
         });

    }

    void findViewById() {
        btncreate=findViewById(R.id.btncreate);
        namacreate=findViewById(R.id.editnamacreate);
        alamatcreate=findViewById(R.id.editalamatcreate);
        emailcreate=findViewById(R.id.editemailcreate);
    }
}
