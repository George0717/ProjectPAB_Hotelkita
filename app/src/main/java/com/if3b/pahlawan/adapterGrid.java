package com.if3b.pahlawan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapterGrid extends RecyclerView.Adapter<adapterGrid.varViewHolder> {
    private ArrayList<ModelHotel> dataPahlawan;
    private Context ctx;

    public adapterGrid(ArrayList<ModelHotel> dataPahlawan, Context ctx) {
        this.dataPahlawan = dataPahlawan;
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
        ModelHotel pahlawan = dataPahlawan.get(position);
        
        Glide
                .with(ctx)
                .load(pahlawan.getFoto())
                .centerCrop()
                .into(holder.ivGrid);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xNama, xTentang, xFoto;

                xNama = pahlawan.getNama();
                xTentang = pahlawan.getTentang();
                xFoto = pahlawan.getFoto();

//                Log.d("CEKNRICEK", xNama+ " | " + xTentang + " | " + xFoto);

                Intent kirim = new Intent(ctx, DetailActivity.class);
                kirim.putExtra("xNama", xNama);
                kirim.putExtra("xTentang", xTentang);
                kirim.putExtra("xFoto", xFoto);
                ctx.startActivity(kirim);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }

    public class varViewHolder extends RecyclerView.ViewHolder {
        ImageView ivGrid;


        public varViewHolder(@NonNull View itemView) {
            super(itemView);
            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}
