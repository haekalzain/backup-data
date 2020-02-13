package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout fl_menu;
    LinearLayout llhistory,llterjadwal,llpemilik,efekhistory,efekterjadwal,efekpemilik,llutama;
    FragmentTransaction fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initAction();
        fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fl_menu,new HistoryFragment());
        fm.commit();

    }

     public void findViewById() {
        fl_menu=findViewById(R.id.fl_menu);
        llhistory=findViewById(R.id.llhistory);
        llpemilik=findViewById(R.id.llpemilik);
        llterjadwal=findViewById(R.id.llterjadwal);
        efekhistory=findViewById(R.id.efekhistory);
        efekpemilik=findViewById(R.id.efekpemilik);
        efekterjadwal=findViewById(R.id.efekterjadwal);
        llutama=findViewById(R.id.llutama);
    }

    public void initAction(){


        llhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fl_menu,new HistoryFragment());
                fm.commit();
                efekhistory.setVisibility(View.VISIBLE);
                efekpemilik.setVisibility(View.GONE);
                efekterjadwal.setVisibility(View.GONE);


            }
        });
        llpemilik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fl_menu,new PemilikFragment());
                fm.commit();
                efekhistory.setVisibility(View.GONE);
                efekpemilik.setVisibility(View.VISIBLE);
                efekterjadwal.setVisibility(View.GONE);

            }
        });
        llterjadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fl_menu,new TerjadwalFragment());
                fm.commit();
                efekhistory.setVisibility(View.GONE);
                efekpemilik.setVisibility(View.GONE);
                efekterjadwal.setVisibility(View.VISIBLE);
            }
        });
    }
}
