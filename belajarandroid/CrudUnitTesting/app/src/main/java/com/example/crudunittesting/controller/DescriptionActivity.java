package com.example.crudunittesting.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudunittesting.R;
import com.example.crudunittesting.model.BaseResponse;
import com.example.crudunittesting.model.GetNasabah;
import com.example.crudunittesting.model.Nasabah;
import com.example.crudunittesting.rest.ApiClient;
import com.example.crudunittesting.rest.ApiInterface;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionActivity extends AppCompatActivity {

    TextView namadesc, alamatdesc, emaildesc, saldodesc, createdesc, updatedesc,deletedesc;
    EditText namaupdate,alamatupdate,emailupdate;
    Button refresh,update,delete;
    String id;


    Nasabah nasabah = new Nasabah();
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        findViewById();
        initData();
        onClick();
    }

     void onClick() {
         refresh.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Call<GetNasabah> nasabahCall = mApiInterface.getNasabah(id);
                 nasabahCall.enqueue(new Callback<GetNasabah>() {
                     @Override
                     public void onResponse(Call<GetNasabah> call, Response<GetNasabah> response) {
                         if (response.isSuccessful()) {
                             nasabah = response.body().getNasabah();

                             namadesc.setText("Nama: "+nasabah.getNama());
                             alamatdesc.setText("Alamat: "+nasabah.getAlamat());
                             emaildesc.setText("Email: "+nasabah.getEmail());
                             saldodesc.setText("Saldo: "+nasabah.getSaldo() +"");
                             updatedesc.setText("Update: "+nasabah.getUpdated_date()+"");
                             createdesc.setText("Create: "+nasabah.getCreated_date()+"");
                             namaupdate.setText(nasabah.getNama());
                             alamatupdate.setText(nasabah.getAlamat());
                             emailupdate.setText(nasabah.getEmail());


                         } else {
                             Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                         }

                     }


                     @Override
                     public void onFailure(Call<GetNasabah> call, Throwable t) {
                         Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                     }

                 });
             }
         });
         refresh.callOnClick();
         delete.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {



                 try {


                     Call<BaseResponse> nasabahCall = mApiInterface.delNasabah(id);
                     nasabahCall.enqueue(new Callback<BaseResponse>() {
                         @Override
                         public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                             if (response.isSuccessful()){
                                 refresh.callOnClick();
                                 Intent intent = new Intent(DescriptionActivity.this,MainActivity.class);
                                 startActivity(intent);

                             }
                             else {
                                 Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG).show();
                             }
                         }

                         @Override
                         public void onFailure(Call<BaseResponse> call, Throwable t) {
                             Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                         }
                     });
                 } catch (Exception e){
                     System.out.println("error");
                 }

             }
         });
         update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 try {
                     JsonObject o = new JsonObject();
                     o.addProperty("nama",namaupdate.getText().toString());
                     o.addProperty("email",emailupdate.getText().toString());
                     o.addProperty("alamat",alamatupdate.getText().toString());
                     Call<BaseResponse> nasabahcall= mApiInterface.putNasabah(id,o);
                     nasabahcall.enqueue(new Callback<BaseResponse>() {
                         @Override
                         public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                             if (response.isSuccessful()){
                                 refresh.callOnClick();
                             }
                         }

                         @Override
                         public void onFailure(Call<BaseResponse> call, Throwable t) {

                         }
                     });
                 }catch (Exception e){
                     System.out.println("Error"+e.toString());
                 }
             }
         });
    }

    void initData() {
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    void findViewById() {
        namadesc = findViewById(R.id.hintnama);
        alamatdesc = findViewById(R.id.hintalamat);
        emaildesc = findViewById(R.id.hintemail);
        saldodesc = findViewById(R.id.hintsaldo);
        createdesc = findViewById(R.id.hintcreate);
        updatedesc = findViewById(R.id.hintupdate);
        refresh = findViewById(R.id.btnrefreshdesc);
        update=findViewById(R.id.btnupdatedesc);
        delete=findViewById(R.id.btndeletedesc);
        namaupdate=findViewById(R.id.editnama);
        alamatupdate=findViewById(R.id.editalamat);
        emailupdate=findViewById(R.id.editemail);
        deletedesc=findViewById(R.id.btndeletedesc);
    }
}
