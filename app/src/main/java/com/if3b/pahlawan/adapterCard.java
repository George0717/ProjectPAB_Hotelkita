package com.if3b.pahlawan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapterCard extends RecyclerView.Adapter<adapterCard.varViewHolder> {
    private ArrayList<ModelHotel> dataHotel;
    private Context ctx;

    public adapterCard(ArrayList<ModelHotel> dataPahlawan, Context ctx) {
        this.dataHotel = dataPahlawan;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public varViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(ctx).inflate(R.layout.item_card, parent, false);
        return new varViewHolder(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull varViewHolder holder, int position) {
        ModelHotel hotel = dataHotel.get(position);
        holder.tvNama.setText(hotel.getNama());
        holder.tvTentang.setText(hotel.getTentang());
        Glide
                .with(ctx)
                .load(hotel.getFoto())
                .centerCrop()
                .into(holder.ivFoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xNama, xTentang, xFoto, xFoto1, xFoto2, xFoto3,xdetail;

                xNama = hotel.getNama();
                xTentang = hotel.getTentang();
                xFoto = hotel.getFoto();
                xFoto1 = hotel.getFoto1();
                xFoto2 = hotel.getFoto2();
                xFoto3 = hotel.getFoto3();
                xdetail= hotel.getDetail();


//                Log.d("CEKNRICEK", xNama+ " | " + xTentang + " | " + xFoto);

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                kirim.putExtra("xFoto1", xFoto1);
                kirim.putExtra("xFoto2", xFoto2);
                kirim.putExtra("xFoto3", xFoto3);
                kirim.putExtra("xDetail", xdetail);
                ctx.startActivity(kirim);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataHotel.size();
    }

    public class varViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvNama, tvTentang;

        public varViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.iv_foto);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvTentang = itemView.findViewById(R.id.tv_tentang);
        }
    }
}
