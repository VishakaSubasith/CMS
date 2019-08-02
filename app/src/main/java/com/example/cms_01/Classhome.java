package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Classhome extends AppCompatActivity {
ImageView txt;
ProgressBar pgsbar;
    RecyclerView recy;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classhome);
         txt=findViewById(R.id.imageView);
         pgsbar=findViewById(R.id.progressBar);

         recy=findViewById(R.id.recycle);
         recy.setHasFixedSize(true);

        layoutManager= new LinearLayoutManager(this);
        recy.setLayoutManager(layoutManager);
        adapter= new MyAdapter();
        recy.setAdapter(adapter);
    }

    public void sendData(View v){
        Intent myintent = new Intent(Classhome.this,ADD_CLASS.class);
        startActivity(myintent);
        pgsbar.setVisibility(v.VISIBLE);

    }


}
