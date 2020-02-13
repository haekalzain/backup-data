package com.example.viewerpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        onClick();

    }

     void onClick() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,pdf1.class);
                startActivity(i);
            }
        });
         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i2 = new Intent(MainActivity.this,pdf2.class);
                 startActivity(i2);
             }
         });
         btn3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i3 = new Intent(MainActivity.this,VideoActivity.class);
                 startActivity(i3);
             }
         });

    }

    void findViewById() {
        btn1=findViewById(R.id.btn);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
    }
}
