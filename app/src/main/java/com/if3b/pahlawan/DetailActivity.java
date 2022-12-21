package com.if3b.pahlawan;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivFoto, ivFoto1, ivFoto2, ivFoto3;
    private TextView tvNama,tvTentang,tvDesc;
    private String yNama,yTentang,yFoto, yFoto1, yFoto2, yFoto3,yDesc, getLokasi;
    private Button btnLokasi;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btnLokasi = findViewById(R.id.btn_lokasi);
        ivFoto=findViewById(R.id.iv_foto);
        tvNama=findViewById(R.id.tv_nama);
        tvTentang=findViewById(R.id.tv_alamat);
        ivFoto1 = findViewById(R.id.iv_fot);
        ivFoto2=findViewById(R.id.iv_foto2);
        ivFoto3=findViewById(R.id.iv_foto3);
        tvDesc=findViewById(R.id.tv_desk_hotel);


        Intent ambil=getIntent();
        yNama= ambil.getStringExtra("xNama");
        yTentang=ambil.getStringExtra("xTentang");
        yFoto= ambil.getStringExtra("xFoto");
        yFoto1 = ambil.getStringExtra("xFoto1");
        yFoto2 = ambil.getStringExtra("xFoto2");
        yFoto3 = ambil.getStringExtra("xFoto3");
        yDesc = ambil.getStringExtra("xdetail");


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

        //LACAK
        btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLokasi = yNama;

                Uri location = Uri.parse("geo:0,0?q=" + yNama + " Palembang");

                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW, location);
                startActivity(bukaLokasi);
            }
        });
    }

}