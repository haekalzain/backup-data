package com.example.tugasandroid2.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tugasandroid2.R;
import com.example.tugasandroid2.adapter.transaksiAdapter;
import com.example.tugasandroid2.model.transaksi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView click;
    ListView listview;
    ImageView imageView;
    private List<transaksi> t;
    transaksiAdapter transaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        initData();
        onClickGroup();

    }

     void onClickGroup() {
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.clear();
                transaksi newT=new transaksi();
                newT.setFoto(R.drawable.foto1);
                newT.setTransaksi("Cash");
                newT.setSaldo("8,1000,000");
                newT.setTanggal("14 Dec 2019");
                newT.setStatus("Outgoing");
                t.add(newT);

                newT=new transaksi();
                newT.setFoto(R.drawable.foto2);
                newT.setTransaksi("Cashback MONYAY");
                newT.setSaldo("+6,500");
                newT.setTanggal("2 Dec 2019");
                newT.setStatus("Incoming");
                t.add(newT);

                newT=new transaksi();
                newT.setFoto(R.drawable.foto2);
                newT.setTransaksi("Interest");
                newT.setSaldo("+1");
                newT.setTanggal("3 Dec 2019");
                newT.setStatus("Incoming");
                t.add(newT);

                transaksi.notifyDataSetChanged();
            }
        });
        click.callOnClick();
    }

    void initData() {
        t= new ArrayList();
        t.clear();
        transaksi= new transaksiAdapter(getApplicationContext(),t);
        listview.setAdapter(transaksi);
        transaksi.notifyDataSetChanged();
    }

    void findViewById() {
        listview = findViewById(R.id.listView);
        click=findViewById(R.id.indanout);
        imageView=findViewById(R.id.foto);
    }
}
