package com.example.actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(getApplicationContext(), "Search klik", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.tool:
                Toast.makeText(getApplicationContext(), "Tool klik", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.update:
                Toast.makeText(getApplicationContext(), "Update klik", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.refresh:
                Toast.makeText(getApplicationContext(), "Refresh klik", Toast.LENGTH_LONG).show();
                return (true);
            case R.id.help:
                Toast.makeText(getApplicationContext(), "Help klik", Toast.LENGTH_LONG).show();
                return (true);

        }

        return (super.onOptionsItemSelected(item));
    }
}
