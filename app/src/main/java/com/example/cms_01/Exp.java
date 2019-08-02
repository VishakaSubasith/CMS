package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Exp extends AppCompatActivity {
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp);


        button = (Button) findViewById(R.id.button4);
        button2 = (Button) findViewById(R.id.button3);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

             openAct2();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                openAct3();
            }
        });


    }
public void openAct2(){
    Intent intent = new Intent(this,AddExp.class);
    startActivity(intent);

}

public void openAct3(){
    Intent intent2 = new Intent(this,ExpReport.class);
    startActivity(intent2);

}

}





