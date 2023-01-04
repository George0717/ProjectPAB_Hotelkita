package com.if3b.pahlawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class aboutUs extends AppCompatActivity {
    TextView tvNama1, tvNama2, tvNama3, tvNpm1,tvNpm2,tvNpm3 , tvQuotes1, tvQuotes2, tvQuotes3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        getSupportActionBar().setTitle("About Us");

//        tvNama
        tvNama1 = findViewById(R.id.tv_nama1);
        tvNama2 = findViewById(R.id.tv_nama2);
        tvNama3 = findViewById(R.id.tv_nama3);
//        tvNpm
        tvNpm1 = findViewById(R.id.tv_npm1);
        tvNpm2 = findViewById(R.id.tv_npm2);
        tvNpm3 = findViewById(R.id.tv_npm3);
//        tvQuotes
        tvQuotes1 = findViewById(R.id.tv_quotes1);
        tvQuotes2 = findViewById(R.id.tv_quotes2);
        tvQuotes3 = findViewById(R.id.tv_quotes3);


    }
}