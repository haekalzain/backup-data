package com.example.explicitintent.model;

public class User {
    String nama=" ";
    String password=" ";
    String alamat=" ";
    String Token=" ";
    int saldo = 0;
    boolean aktif=false;
    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }


}
