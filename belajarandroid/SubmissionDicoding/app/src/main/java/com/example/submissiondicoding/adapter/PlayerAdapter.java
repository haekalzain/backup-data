package com.example.submissiondicoding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submissiondicoding.R;
import com.example.submissiondicoding.model.Player;

import java.util.List;

public class PlayerAdapter extends BaseAdapter {

    Context context;
    private List<Player> list;
    public PlayerAdapter(Context context, List<Player> list){
        this.context=context;
        this.list = list;
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
            convertView=inflater.inflate(R.layout.item_player,null);
        }

        Player player=list.get(position);
        TextView namaTextView =(TextView) convertView.findViewById(R.id.nama);
        namaTextView.setText(player.getNama());
        ImageView foto =(ImageView) convertView.findViewById(R.id.fotoplayer);
        foto.setImageResource(player.getFoto());


        return convertView;
    }
}
