package com.example.crud.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.R;
import com.example.crud.adapter.NasabahAdapter;
import com.example.crud.helper.MqttHelper;
import com.example.crud.model.BaseResponse;
import com.example.crud.model.GetListNasabah;
import com.example.crud.model.Nasabah;
import com.example.crud.rest.ApiClient;
import com.example.crud.rest.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {
    Button btncreate,btnpublishmqtt;
    EditText namacreate,alamatcreate,emailcreate,topikEditText;
    ApiInterface mApiInterface;
    private MqttHelper mqttHelper;
    private List<Nasabah> listNasabah;
    NasabahAdapter nasabahAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        findViewById();
        mApiInterface = ApiClient.getClient(getBaseContext()).create(ApiInterface.class);
        initData();
        onClick();
        startmqtt();

    }

     void initData() {
         mqttHelper = new MqttHelper(getApplicationContext());

    }

    void startmqtt() {
         mqttHelper.setCallback(new MqttCallbackExtended() {
             @Override
             public void connectComplete(boolean b, String s) {
                 Toast.makeText(CreateActivity.this,"Mqqt connected",Toast.LENGTH_SHORT).show();
             }

             @Override
             public void connectionLost(Throwable throwable) {
                 Toast.makeText(CreateActivity.this,"Mqtt not connected",Toast.LENGTH_SHORT).show();
             }

             @Override
             public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                 Toast.makeText(getApplicationContext(),mqttMessage.toString(),Toast.LENGTH_SHORT).show();

                 try{
                     JsonParser parser = new JsonParser();
                     JsonElement mJson=parser.parse(mqttMessage.toString());
                     Gson gson = new Gson();
                     Nasabah nasabah = gson.fromJson(mJson,Nasabah.class);
                     listNasabah.add(nasabah);
                     nasabahAdapter.notifyDataSetChanged();
                 }catch (Exception e){
                     e.printStackTrace();
                 }


             }

             @Override
             public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

             }
         });
    }


     void onClick() {
         btnpublishmqtt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Nasabah nasabah=new Nasabah();
                 nasabah.setNama(namacreate.getText().toString());
                 nasabah.setAlamat(alamatcreate.getText().toString());
                 Gson gson= new Gson();
                 String json=gson.toJson(nasabah);
                 Toast.makeText(CreateActivity.this,"json",Toast.LENGTH_SHORT).show();
                 mqttHelper.publishMessage(json,topikEditText.getText().toString());

             }
         });
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
        topikEditText=findViewById(R.id.topikEditText);
        btnpublishmqtt=findViewById(R.id.btnpublishmqtt);
    }
}
