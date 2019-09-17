package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cms_01.DB.ExpenseDBHelper;

import androidx.appcompat.app.AppCompatActivity;

public class ExpUpdate extends AppCompatActivity {


    DatePicker picker;
    Button btnGet, updatebtn, deletebtn;
    TextView tvw, edit1, edit2, edit3, edit4;
    int exp_id;
    TextView expupID;
    ExpenseDBHelper datab;

    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_update);
        datab = new ExpenseDBHelper(this);

        deletebtn = findViewById(R.id.exptdelete);
        updatebtn = (Button)findViewById(R.id.exptupdate2);

        tvw = (TextView) findViewById(R.id.exptudate);
        picker = (DatePicker) findViewById(R.id.datePicker1);
        btnGet = (Button) findViewById(R.id.expgetdate);

        edit1 = findViewById(R.id.exptuname);
        edit2 = findViewById(R.id.exptucat);
        edit3 = findViewById(R.id.exptuamount);
        edit4 = findViewById(R.id.exptudate);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText(" " + picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear());

            }
        });





//        Intent intent = getIntent();
        //selectedID = intent.getIntExtra("ID",0);

        //  exp_id = intent.getIntExtra("ID",-1);
        Intent intent = getIntent();
        String exp_nme, exp_cat, exp_amo, exp_dat;

        exp_nme = intent.getStringExtra("expnme");
        exp_cat = intent.getStringExtra("expcat");
        exp_amo = intent.getStringExtra("expamo");
        exp_dat = intent.getStringExtra("expdat");

        edit1.setText(exp_nme);
        edit2.setText(exp_cat);
        edit3.setText(exp_amo);
        edit4.setText(exp_dat);


        //updateData();

        updateData();
        DeleteData();

    }

    public void updateData() {
        updatebtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {

                        //int selectedID = recint.getIntExtra("ID",0);

                        boolean isUpdated = datab.updateExp(edit1.getText().toString(),edit2.getText().toString(),edit3.getText().toString(),edit4.getText().toString());

                        if(edit1.length() != 0 && edit2.length() != 0 && edit3.length()!= 0 && edit4.length()!= 0) {

                        if(isUpdated == true) {
                            Toast.makeText(getApplicationContext(), "Data Updated!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ExpUpdate.this, AddExp.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(ExpUpdate.this, "Data Not Updated!", Toast.LENGTH_LONG).show();
                        }
                    }else{
                            Toast.makeText(ExpUpdate.this, "Please enter all details!", Toast.LENGTH_LONG).show();

                        }
                    }
                }
        );
    }
    public void DeleteData() {
        deletebtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        //int selectedID = recint.getIntExtra("ID",0);


                        Integer deletedRow = datab.delete(edit1.getText().toString());

                        if(deletedRow >0) {
                            Toast.makeText(ExpUpdate.this, "Data Deleted!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(ExpUpdate.this, AddExp.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(ExpUpdate.this, "Data Not Deleted!", Toast.LENGTH_LONG).show();


                        }
                    }

                }

        );


    }
}
