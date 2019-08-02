package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExpMng extends AppCompatActivity {
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_mng);

        button3 = (Button) findViewById(R.id.save);

        // Capture button clicks
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                openData();
            }
        });
    }

    public void openData(){
        Intent intent = new Intent(this,AddExp.class);
        startActivity(intent);


    }




}
