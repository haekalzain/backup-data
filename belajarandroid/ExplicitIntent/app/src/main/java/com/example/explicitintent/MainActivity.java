package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSignin,btnRegister;
    EditText emailMain,passwordMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initAction();
    }

    void findViewById() {
        btnSignin = findViewById(R.id.btnSignin);
        btnRegister = findViewById(R.id.btnRegister);
        emailMain = findViewById(R.id.emailMain);
        passwordMain=findViewById(R.id.passwordMain);
    }
    void initAction(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "belajar@android.com";
                String password ="android";
                if(emailMain.getText().toString().equals(email)&& passwordMain.getText().toString().equals(password)){
                    Intent intent = new Intent(MainActivity.this,PreviewActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("password", password);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Salah email dan password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
