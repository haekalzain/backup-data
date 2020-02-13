package com.riyantodicoding.warisandunia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    ImageView img_detail_foto, ic_favourite;
    TextView tv_detail_deskripsi;
    Boolean is_favourite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        img_detail_foto = findViewById(R.id.img_detail_foto);
        tv_detail_deskripsi = findViewById(R.id.tv_detail_deskripsi);
        ic_favourite = findViewById(R.id.ic_favourite);

        tampilDetail();


        ic_favourite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(is_favourite == false) {
                    is_favourite = true;
                    ic_favourite.setColorFilter(Color.RED);

                    Toast.makeText(view.getContext(), "Wow", Toast.LENGTH_SHORT).show();
                }
                else {
                    is_favourite = false;
                    ic_favourite.setColorFilter(Color.BLACK);
                }
            }
        });
    }





    private void tampilDetail() {
        Intent intent = getIntent();

        String nama = intent.getStringExtra("NAMA");
        String deskripsi = intent.getStringExtra("DESKRIPSI");
        String foto = intent.getStringExtra("FOTO");

        // tampilkan data di titlebar
        getSupportActionBar().setTitle(nama);
        getSupportActionBar().show();

        // tampilkan gambar dari internet
        Glide.with(this)
                .load(foto)
                .apply(new RequestOptions())
                .into(img_detail_foto);

        // tampilkan data deskripsi
        tv_detail_deskripsi.setText(deskripsi);
    }
}
