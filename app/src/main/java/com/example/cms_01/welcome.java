package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class welcome extends AppCompatActivity {
ProgressBar pg;
    private static int Splach_time=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        pg=findViewById(R.id.progressBar2);
new Timer().schedule(new TimerTask() {
    @Override
    public void run() {
    startActivity(new Intent(getApplicationContext(),Login.class));
    finish();
    }

},3000);



        }
    public void sendData(View v){
        Intent myintent = new Intent();
        startActivity(myintent);
        pg.setVisibility(v.VISIBLE);

    }
    }

