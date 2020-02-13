package com.example.androidadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.androidadapter.adapter.nasabahadapter;
import com.example.androidadapter.model.Nasabah;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView nasabahListView;
    Button refreshTextView;
    nasabahadapter nasabahadapter;
    private List<Nasabah> listNasabah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        onClick();
        initData();
    }

     void initData() {
            listNasabah = new ArrayList();
            listNasabah.clear();
            nasabahadapter = new nasabahadapter(getApplicationContext(),listNasabah);
            nasabahListView.setAdapter(nasabahadapter);
            nasabahadapter.notifyDataSetChanged();


    }

    void onClick() {
        refreshTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listNasabah.clear();
                Nasabah newNasabah = new Nasabah();
                newNasabah.setNama("Wati");
                newNasabah.setAlamat("Jakarta Selatan");
                listNasabah.add(newNasabah);

                newNasabah = new Nasabah();
                newNasabah.setNama("Budi");
                newNasabah.setAlamat("Jakarta Utara");
                listNasabah.add(newNasabah);
                nasabahadapter.notifyDataSetChanged();
            }
        });
    }

    void findViewById() {
        nasabahListView = (ListView) findViewById(R.id.listview);
        refreshTextView =(Button) findViewById(R.id.btn);
    }


}
