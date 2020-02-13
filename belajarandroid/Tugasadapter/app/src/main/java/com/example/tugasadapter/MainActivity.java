package com.example.tugasadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tugasadapter.Adapter.UserAdapter;
import com.example.tugasadapter.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView userListView;
    UserAdapter UserAdapter;
    private List<User> listUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();

        initData();
        dataGroup();

         onClick();

    }

     void dataGroup() {
         User newUser = new User();
         newUser.setNama("Wati");
         newUser.setNumber("+62325143612");
         listUser.add(newUser);

         newUser = new User();
         newUser.setNama("Budi");
         newUser.setNumber("+637824637284");
         listUser.add(newUser);
         UserAdapter.notifyDataSetChanged();
    }

    void onClick() {
        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
//                startActivity(intent);
                Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("nama", listUser.get(position).getNama());
                bundle.putString("number", listUser.get(position).getNumber());

                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
    }


    void initData() {
         listUser = new ArrayList();
         listUser.clear();
         UserAdapter = new UserAdapter(getApplicationContext(),listUser);
         userListView.setAdapter(UserAdapter);
         UserAdapter.notifyDataSetChanged();

    }

    void findViewById() {
        userListView= findViewById(R.id.listview);
    }
}
