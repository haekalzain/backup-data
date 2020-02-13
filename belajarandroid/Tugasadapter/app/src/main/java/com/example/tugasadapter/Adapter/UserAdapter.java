package com.example.tugasadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tugasadapter.Model.User;
import com.example.tugasadapter.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    Context context;
    private List<User> list;
    public UserAdapter(Context context, List<User> list){
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
    @SuppressWarnings("deprecation")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(this.context);
            convertView=inflater.inflate(R.layout.item_user,null);
        }

        User user=list.get(position);

        TextView numberTextView =(TextView) convertView.findViewById(R.id.number);


        numberTextView.setText(user.getNumber());


        return convertView;
    }
}
