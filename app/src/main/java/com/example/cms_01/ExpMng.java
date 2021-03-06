package com.example.cms_01;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cms_01.DB.ExpenseDBHelper;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class ExpMng extends AppCompatActivity {
    Button expSave, expview;
    DatePicker picker;
    Button btnGet, expsavebtn;
    TextView tvw;
    EditText expname, expcate, expamount, expdate;
    ExpenseDBHelper expdb;


    private  int year,month,day,hour,minute;
    private Calendar calander;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_mng);
        expdb = new ExpenseDBHelper(this);

        // Capture button clicks


        //get text values
        expname = findViewById(R.id.exptname);
        expcate = findViewById(R.id.exptcat);
        expamount = findViewById(R.id.exptamount);
        expdate = findViewById(R.id.exptdate);
        expSave = (Button) findViewById(R.id.exptsave);
        tvw=(TextView)findViewById(R.id.exptdate);

        addData();
    }

    public void addData(){
        expSave.setOnClickListener(
                new View.OnClickListener(){
                    String NumberPattern = "[1-9][0-9]*|0";

                    public void onClick(View view){
                        boolean expInserted = expdb.insertExpData(expname.getText().toString(),
                                expcate.getText().toString(),
                                expamount.getText().toString(),
                                expdate.getText().toString());
                        if(expname.length() != 0 && expcate.length() != 0 && expamount.length()!= 0 && expdate.length()!= 0  && expamount.getText().toString().matches(NumberPattern)) {



                            if (expInserted == true) {
                                Toast.makeText(ExpMng.this, "Data inserted", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(ExpMng.this, AddExp.class);
                                startActivity(intent);

                            }else{

                                    Toast.makeText(ExpMng.this, "Data Not inserted" , Toast.LENGTH_LONG).show();

                                }

                            }else{
                            Toast.makeText(ExpMng.this, "Please Enter all data correctly!" , Toast.LENGTH_LONG).show();


                        }
                        }


                }


        );



    }


    public void showdate(View view){
        DatePickerDialog dpd=new DatePickerDialog(this,dateListener,year,month,day);
        dpd.show();

    }
    private DatePickerDialog.OnDateSetListener dateListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

            tvw.setText( year+"/"+ (month + 1)+"/"+dayOfMonth);

        }
    };




}
