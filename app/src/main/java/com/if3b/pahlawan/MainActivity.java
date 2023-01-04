package com.if3b.pahlawan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnPindah;
private RecyclerView rvPahlawan;
private ArrayList<ModelHotel>data = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPindah = findViewById(R.id.btn_pindah);
        rvPahlawan=findViewById(R.id.rv_pahlwn);
        rvPahlawan.setHasFixedSize(true);
        data.addAll(DataHotel.ambilDataHotel());
        tampilDataCard();
    }
    private void tampilDataCard(){
        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        adapterCard varAdapterCard= new adapterCard(data,MainActivity.this);
        rvPahlawan.setAdapter(varAdapterCard);

    }
    private void tampilDataGrid(){
        rvPahlawan.setLayoutManager(new GridLayoutManager(this,2));
        adapterGrid varAdapterGrid = new adapterGrid(data, MainActivity.this);
        rvPahlawan.setAdapter(varAdapterGrid);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mode,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_aboutA:
                Intent pindah = new Intent(MainActivity.this, aboutUs.class);
                startActivity(pindah);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}