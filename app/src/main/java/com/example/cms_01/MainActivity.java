package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






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







