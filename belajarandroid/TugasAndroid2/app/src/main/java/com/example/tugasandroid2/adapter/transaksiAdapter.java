package com.example.tugasandroid2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugasandroid2.R;
import com.example.tugasandroid2.model.transaksi;

import org.w3c.dom.Text;

import java.util.List;

public class transaksiAdapter extends BaseAdapter {
    Context context;
    private List<transaksi> list;
    public transaksiAdapter(Context context,List<transaksi> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(this.context);
            convertView=inflater.inflate(R.layout.list_transaksi,null);
        }
        transaksi t= list.get(position);
        TextView transaksi=(TextView) convertView.findViewById(R.id.transaksi);
        TextView saldo=(TextView) convertView.findViewById(R.id.saldo);
        TextView tanggal =(TextView) convertView.findViewById(R.id.tanggal);
        TextView status = (TextView) convertView.findViewById(R.id.status);
        ImageView foto =(ImageView) convertView.findViewById(R.id.foto);

        transaksi.setText(t.getTransaksi());
        saldo.setText(t.getSaldo());
        tanggal.setText(t.getTanggal());
        status.setText(t.getStatus());
        foto.setImageResource(t.getFoto());


        return convertView;

    }
}
