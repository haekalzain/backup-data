package com.example.unittestinglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.unittestinglistview.util.KotaUtil;

import static com.example.unittestinglistview.util.KotaUtil.listKota;

public class MainActivity extends AppCompatActivity {

    TextView textViewSelected;
    ListView listView;
    ArrayAdapter adapterKota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSelected =(TextView) findViewById(R.id.selectedTextView);
        listView=(ListView) findViewById(R.id.kotaListView);

        adapterKota = new ArrayAdapter(this,R.layout.item_row, KotaUtil.listKota);
        listView.setAdapter(adapterKota);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textViewSelected.setText("Kota: "+ listKota[position]);
            }
        });
    }
}
