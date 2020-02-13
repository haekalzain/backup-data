package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.TextView;

import com.example.explicitintent.model.User;

public class ObjekNasabahActivity extends AppCompatActivity {
    Button refresh,btn1,btn2,btn3,btn4,btn5,reset,promosi;
    TextView nama,alamat,password,token,saldo,aktif;
    EditText hintNama,hintAlamat,hintPassword,hintToken,hintSaldo;
    User u;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objek_nasabah);
        findViewById();
        buttonaction();
        u = new User();

    }

     void buttonaction() {
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            nama.setText(u.getNama());
            alamat.setText(u.getAlamat());
            password.setText(u.getPassword());
            token.setText(u.getToken());
            saldo.setText(u.getSaldo()+"");
            u.setAktif(true);
            aktif.setText(u.isAktif()+"");

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 u.setNama(hintNama.getText().toString());


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setAlamat(hintAlamat.getText().toString());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setPassword(hintPassword.getText().toString());

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u.setToken(hintToken.getText().toString());
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            u.setSaldo(Integer.parseInt(hintSaldo.getText().toString()));
            }
        });
    }

    void findViewById() {
        refresh = findViewById(R.id.btnrefresh);
        btn1 = findViewById(R.id.btnsetnama);
        btn2=findViewById(R.id.btnsetalamat);
        btn3=findViewById(R.id.btnsetpassword);
        btn4=findViewById(R.id.btnsettoken);
        btn5=findViewById(R.id.btnsetsaldo);
        reset=findViewById(R.id.btnresetpassword);
        promosi=findViewById(R.id.btnpromosi);

        nama=findViewById(R.id.namaobjek);
        alamat=findViewById(R.id.alamatobjek);
        password=findViewById(R.id.passwordobjek);
        token=findViewById(R.id.tokenobjek);
        saldo=findViewById(R.id.saldoobjek);
        aktif=findViewById(R.id.aktifobjek);

        hintNama=findViewById(R.id.hintnama);
        hintAlamat=findViewById(R.id.hintalamat);
        hintPassword=findViewById(R.id.hintpassword);
        hintToken=findViewById(R.id.hinttoken);
        hintSaldo = findViewById(R.id.hintsaldo);


    }

}
