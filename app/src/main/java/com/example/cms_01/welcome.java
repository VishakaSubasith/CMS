package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class welcome extends AppCompatActivity {

    private static int Splach_time=5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
new Timer().schedule(new TimerTask() {
    @Override
    public void run() {
    startActivity(new Intent(getApplicationContext(),Login.class));
    finish();
    }

},3000);



        }

    }

