package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {
    TextView email,password;
//    String emaill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        findViewById();
        Bundle bundle = getIntent().getExtras();
        email.setText("email= " + bundle.getString("email"));
//        emaill = bundle.getString("email");
        password.setText("Password= " +bundle.getString("password"));


    }



    private void findViewById() {

        email=findViewById(R.id.emailpreview);
        password=findViewById(R.id.passwordpreview);
    }
}
