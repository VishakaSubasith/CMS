package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    RecyclerView recy;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recy=findViewById(R.id.myrcy);
        recy.setHasFixedSize(true);

        layoutManager= new LinearLayoutManager(this);
        recy.setLayoutManager(layoutManager);
        adapter= new MyAdapter2();
        recy.setAdapter(adapter);


        }

    public void goRegister(View view) {
        Intent intent = new Intent(this,register_students.class);



        startActivity(intent);
    }
    public void goProfile(View view) {
        Intent intent = new Intent(this,Student_Profile.class);



        startActivity(intent);
    }



    }







