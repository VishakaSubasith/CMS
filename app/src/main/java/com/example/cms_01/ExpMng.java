package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpMng extends AppCompatActivity {
    Button button3;
    DatePicker picker;
    Button btnGet;
    TextView tvw;

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

        tvw=(TextView)findViewById(R.id.lname);
        picker=(DatePicker)findViewById(R.id.datePicker1);
        btnGet=(Button)findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
            }
        });
    }

    public void openData(){
        Intent intent = new Intent(this,AddExp.class);
        startActivity(intent);


    }




}
