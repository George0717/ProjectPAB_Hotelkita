package com.if3b.pahlawan;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto, ivFoto1, ivFoto2, ivFoto3;
    private TextView tvNama,tvTentang,tvDesc;
    private String yNama,yTentang,yFoto, yFoto1, yFoto2, yFoto3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivFoto=findViewById(R.id.iv_foto);
        tvNama=findViewById(R.id.tv_nama);
        tvTentang=findViewById(R.id.tv_alamat);
        ivFoto1 = findViewById(R.id.iv_fot);
        ivFoto2=findViewById(R.id.iv_foto2);
        ivFoto3=findViewById(R.id.iv_foto3);


        Intent ambil=getIntent();
        yNama= ambil.getStringExtra("xNama");
        yTentang=ambil.getStringExtra("xTentang");
        yFoto= ambil.getStringExtra("xFoto");
        yFoto1 = ambil.getStringExtra("xFoto1");
        yFoto2 = ambil.getStringExtra("xFoto2");
        yFoto3 = ambil.getStringExtra("xFoto3");

        tvNama.setText(yNama);
        tvTentang.setText(yTentang);

        Glide
                .with(DetailActivity.this)
                .load(yFoto)
                .into(ivFoto);
        Glide
                .with(DetailActivity.this)
                .load(yFoto1)
                .into(ivFoto1);
        Glide
                .with(DetailActivity.this)
                .load(yFoto2)
                .into(ivFoto2);

        Glide
                .with(DetailActivity.this)
                .load(yFoto3)
                .into(ivFoto3);


    }
}