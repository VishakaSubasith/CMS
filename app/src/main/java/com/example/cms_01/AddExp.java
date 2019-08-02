package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AddExp extends AppCompatActivity {
ImageView img1;
ListView listview1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exp);

        img1 = (ImageView) findViewById(R.id.imageView3);

        // Capture button clicks
        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                openAddExp();
            }
        });
    }

    public void openAddExp(){
        Intent intent1 = new Intent(this,ExpMng.class);
        startActivity(intent1);

    }
}
