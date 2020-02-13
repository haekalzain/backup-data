package com.riyantodicoding.warisandunia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<WarisanDunia> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        list.addAll(WarisanDuniaData.getListData());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        WarisanDuniaAdapter warisanDuniaAdapter = new WarisanDuniaAdapter(list);
        recyclerView.setAdapter(warisanDuniaAdapter);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent goToAbout = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(goToAbout);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
