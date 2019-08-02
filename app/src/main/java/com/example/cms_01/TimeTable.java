package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TimeTable extends AppCompatActivity {

  // private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);



       // recyclerView=findViewById(R.id.recycle_view);
       //clerView.setLayoutManager(layoutManager);
    }

    public void send1(View v1){
        Intent intent2=new Intent(TimeTable.this,retrivedata.class);
        startActivity(intent2);
    }
}
