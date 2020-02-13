package com.example.submissiondicoding.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submissiondicoding.R;

public class DetailActivity extends AppCompatActivity {
    ImageView fotoplayer;
    TextView nama,tanggallahir,detail,negara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        findViewById();
        Bundle bundle = getIntent().getExtras();
        nama.setText( bundle.getString("nama"));
        tanggallahir.setText(bundle.getString("tanggallahir"));
        detail.setText(bundle.getString("detail"));
        negara.setText(bundle.getString("negara"));
        fotoplayer.setImageResource(bundle.getInt("foto"));


    }

     void findViewById() {
        fotoplayer=findViewById(R.id.foto);
        nama=findViewById(R.id.nama);
        tanggallahir=findViewById(R.id.tanggallahir);
        detail=findViewById(R.id.detail);
        negara=findViewById(R.id.negara);
    }
}
