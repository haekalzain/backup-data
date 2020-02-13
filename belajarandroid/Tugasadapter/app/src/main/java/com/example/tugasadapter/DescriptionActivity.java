package com.example.tugasadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
TextView namadesc,nomordesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        findViewById();
        Bundle bundle = getIntent().getExtras();
        namadesc.setText( bundle.getString("nama"));

        nomordesc.setText(bundle.getString("number"));
    }

     void findViewById() {
    namadesc=findViewById(R.id.namadesc);
    nomordesc=findViewById(R.id.nomordesc);
    }
}
