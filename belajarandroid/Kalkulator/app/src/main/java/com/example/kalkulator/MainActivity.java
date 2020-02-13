package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kalkulator.Model.Model;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    EditText angka1,angka2;
    TextView hasill;
    Model x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        btnaction();
        x = new Model();
    }

     void btnaction() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setAngka1(Integer.parseInt(angka1.getText().toString()));
                x.setAngka2(Integer.parseInt(angka2.getText().toString()));
                x.setHasil(x.getAngka1()* x.getAngka2());
                hasill.setText(x.getHasil()+"");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setAngka1(Integer.parseInt(angka1.getText().toString()));
                x.setAngka2(Integer.parseInt(angka2.getText().toString()));
                x.setHasil(x.getAngka1()/ x.getAngka2());
                hasill.setText(x.getHasil()+"");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setAngka1(Integer.parseInt(angka1.getText().toString()));
                x.setAngka2(Integer.parseInt(angka2.getText().toString()));
                x.setHasil(x.getAngka1()+ x.getAngka2());
                hasill.setText(x.getHasil()+"");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x.setAngka1(Integer.parseInt(angka1.getText().toString()));
                x.setAngka2(Integer.parseInt(angka2.getText().toString()));
                x.setHasil(x.getAngka1()- x.getAngka2());
                hasill.setText(x.getHasil()+"");
            }
        });


    }

    void findViewById() {
        btn1 = findViewById(R.id.btnkali);
        btn2 = findViewById(R.id.btnbagi);
        btn3=findViewById(R.id.btntambah);
        btn4=findViewById(R.id.btnkurang);

        angka1=findViewById(R.id.angka1);
        angka2=findViewById(R.id.angka2);

        hasill=findViewById(R.id.hasil);
    }


}
