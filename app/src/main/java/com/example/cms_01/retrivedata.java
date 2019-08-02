package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class retrivedata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrivedata);
    }

    public void send(View V){
        Intent intent2=new Intent(retrivedata.this,Insert_Activity.class);
        startActivity(intent2);
    }

}
