package com.riyantodicoding.warisandunia;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class WarisanDuniaAdapter extends RecyclerView.Adapter<WarisanDuniaAdapter.Viewholder> {

    private ArrayList<WarisanDunia> listWarisanDunia;

    public WarisanDuniaAdapter(ArrayList<WarisanDunia> listWarisanDunia) {
        this.listWarisanDunia = listWarisanDunia;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, int position) {
        final WarisanDunia warisanDunia = listWarisanDunia.get(position);

        Glide.with(holder.itemView.getContext())
                .load(warisanDunia.getFoto())
                .apply(new RequestOptions().override(84, 84))
                .into(holder.img_foto);

        holder.tv_nama.setText(warisanDunia.getNama());
        holder.tv_deskripsi.setText(warisanDunia.getDeskripsi());



        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent goToDetail = new Intent(view.getContext().getApplicationContext(), DetailActivity.class);
                goToDetail.putExtra("NAMA", warisanDunia.getNama());
                goToDetail.putExtra("DESKRIPSI", warisanDunia.getDeskripsi());
                goToDetail.putExtra("FOTO", warisanDunia.getFoto());

                view.getContext().startActivity(goToDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listWarisanDunia.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView img_foto;
        TextView tv_nama, tv_deskripsi;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            img_foto = itemView.findViewById(R.id.img_item_foto);
            tv_nama = itemView.findViewById(R.id.tv_item_nama);
            tv_deskripsi = itemView.findViewById(R.id.tv_item_deskripsi);
        }
    }
}
