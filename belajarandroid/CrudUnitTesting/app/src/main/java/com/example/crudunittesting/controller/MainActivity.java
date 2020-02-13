package com.example.crudunittesting.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.crudunittesting.R;
import com.example.crudunittesting.adapter.NasabahAdapter;
import com.example.crudunittesting.model.GetListNasabah;
import com.example.crudunittesting.model.Nasabah;
import com.example.crudunittesting.rest.ApiClient;
import com.example.crudunittesting.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnRefresh,btncreatemain;
    ListView nasabahListView;
    NasabahAdapter nasabahAdapter;
    private List<Nasabah> listNasabah;
    ApiInterface mApiInterface;
    TextView nama,alamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initData();
        onClickGroup();
        btnRefresh.callOnClick();
    }

    void onClickGroup() {
        btncreatemain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<GetListNasabah> nasabahCall = mApiInterface.getListNasabah();
                nasabahCall.enqueue(new Callback<GetListNasabah>() {
                    @Override
                    public void onResponse(Call<GetListNasabah> call, Response<GetListNasabah> response) {
                        if (response.isSuccessful()){
                            List<Nasabah> listNasabahTemp = response.body().getListNasabah();
                            listNasabah.clear();
                            listNasabah.addAll(listNasabahTemp);
                            nasabahAdapter.notifyDataSetChanged();
                            nasabahListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("id", listNasabah.get(position).getId());
                                    //bundle.putString("alamat", listNasabah.get(position).getAlamat());
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                }
                            });

                        } else{
                            Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetListNasabah> call, Throwable t) {
                        Log.e("Error :",t.toString());
                    }
                });
            }
        });
    }

    void initData() {
        listNasabah = new ArrayList();
        listNasabah.clear();
        nasabahAdapter = new NasabahAdapter(getApplicationContext(), listNasabah);
        nasabahListView.setAdapter(nasabahAdapter);
        nasabahAdapter.notifyDataSetChanged();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    void findViewById() {
        nasabahListView = (ListView) findViewById(R.id.listviewutama);
        btnRefresh =  findViewById(R.id.btnrefresh);
        nama=findViewById(R.id.nama);
        alamat=findViewById(R.id.alamat);
        btncreatemain=findViewById(R.id.btncreatemain);
    }
}
