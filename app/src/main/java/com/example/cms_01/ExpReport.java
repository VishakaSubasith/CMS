package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExpReport extends AppCompatActivity {
    Button but1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_report);

        but1 = (Button) findViewById(R.id.totalAmo);

        // Capture button clicks
        but1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                OpenTotal();
            }
        });
    }

    public void OpenTotal(){
        Intent intent = new Intent(this,ExpReportTot.class);
        startActivity(intent);


    }
}
