package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpReport extends AppCompatActivity {
    Button but1;

    DatePicker picker;
    Button btnGet;
    TextView tvw;

    Button btnGet1;
    TextView tvw1;


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

        tvw=(TextView)findViewById(R.id.editText9);

        picker=(DatePicker)findViewById(R.id.datePicker4);
        btnGet=(Button)findViewById(R.id.button13);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
            }
        });

        tvw1=(TextView)findViewById(R.id.editText10);

        picker=(DatePicker)findViewById(R.id.datePicker4);
        btnGet1=(Button)findViewById(R.id.button2);
        btnGet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw1.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
            }
        });


    }

    public void OpenTotal(){
        Intent intent = new Intent(this,ExpReportTot.class);
        startActivity(intent);


    }
}
