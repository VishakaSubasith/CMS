package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AddExp extends AppCompatActivity {
ImageView img1;
ListView listview1;
Button expUpdate;
Button expDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exp);

        img1 = (ImageView) findViewById(R.id.imageView3);
        expUpdate = (Button) findViewById(R.id.expUpdate);
        expDelete = (Button) findViewById(R.id.expDelete);



        // Capture button clicks
        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                openAddExp();
            }
        });

        expUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                ExpUpdate();
            }
        });



    }

    public void openAddExp(){
        Intent intent1 = new Intent(this,ExpMng.class);
        startActivity(intent1);

    }


    public void ExpUpdate(){
        Intent intent1 = new Intent(this,ExpUpdate.class);
        startActivity(intent1);

    }


}
