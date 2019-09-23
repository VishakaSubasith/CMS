package com.example.cms_01;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class ExpReport extends AppCompatActivity {
    Button but1;

    DatePicker picker;
    Button btnGet;
    TextView tvw;

    Button btnGet1;
    TextView tvw1;

    public  int year,month,day,hour,minute;

    public Calendar calander;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_report);


        calander=Calendar.getInstance(Locale.getDefault());
        year=calander.get(Calendar.YEAR);
        month=calander.get(Calendar.MONTH);
        day=calander.get(Calendar.DAY_OF_MONTH);




        but1 = (Button) findViewById(R.id.totalAmo);

        // Capture button clicks
        but1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                OpenTotal();
            }
        });

        tvw=(TextView)findViewById(R.id.editText9);
        tvw1=(TextView)findViewById(R.id.editText10);

        btnGet=(Button)findViewById(R.id.button13);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   tvw.setText("Selected Date: "+ picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
                tvw.setText("Selected Date: "+ Calendar.YEAR+"/"+ (Calendar.MONTH + 1)+"/"+Calendar.DAY_OF_MONTH);
            }
        });

        tvw1=(TextView)findViewById(R.id.editText10);

        btnGet1=(Button)findViewById(R.id.button2);
        btnGet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: "+ Calendar.YEAR+"/"+ (Calendar.MONTH + 1)+"/"+Calendar.DAY_OF_MONTH);
            }
        });





    }

    public void OpenTotal(){
        Intent intent = new Intent(this, ExpReportTot.class);
        startActivity(intent);

    }
    public void showdate(View view){
        DatePickerDialog dpd=new DatePickerDialog(this,dateListener,year,month,day);
        dpd.show();

    }

    public void showdate1(View view){
        DatePickerDialog dpd=new DatePickerDialog(this,dateListener1,year,month,day);
        dpd.show();

    }

    public DatePickerDialog.OnDateSetListener dateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

            tvw.setText( year+"/"+ (month + 1)+"/"+dayOfMonth);

        }
    };

    public DatePickerDialog.OnDateSetListener dateListener1=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            String s2 = "";
            String s1 = "";

            tvw1.setText( year+"/"+ (month + 1)+"/"+dayOfMonth);

            s1 = tvw.getText().toString();
            s2 = tvw1.getText().toString();

            Intent intent = new Intent(ExpReport.this, ExpReportTot.class);
            intent.putExtra("asf", s1);
            intent.putExtra("asff", s2);

            startActivity(intent);

        }
    };





}
