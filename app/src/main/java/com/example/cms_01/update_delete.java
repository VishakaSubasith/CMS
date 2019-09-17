package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cms_01.DB.ClassDBHelper;

public class update_delete extends AppCompatActivity {
Button btnupdate,btndelete;
EditText name,subject,year,locatation,days;
ClassDBHelper cdb;
private String selectname,selectsub,selectyear,selectloc,selectday;
private int selectID,selectID1;
Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        btnupdate= findViewById(R.id.save);
        btndelete=findViewById(R.id.button2);
        cdb= new ClassDBHelper(this);
        name=findViewById(R.id.name);
        subject=findViewById(R.id.sub);
        year=findViewById(R.id.year);
        days=findViewById(R.id.day);
        locatation=findViewById(R.id.location);

        Intent recivedIntent= getIntent();
        selectID=recivedIntent.getIntExtra("id",0);
        selectID1=recivedIntent.getIntExtra("id",0);


        selectname=recivedIntent.getStringExtra("name");
       selectsub=recivedIntent.getStringExtra("subject");
    selectyear=recivedIntent.getStringExtra("year");
    selectloc=recivedIntent.getStringExtra("locatation");
    selectday=recivedIntent.getStringExtra("day");
            name.setText(selectname);
            subject.setText(selectsub);
            year.setText(selectyear);
            locatation.setText(selectloc);
            days.setText(selectday);

            btnupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(subject.getText()) || TextUtils.isEmpty(year.getText())|| TextUtils.isEmpty(locatation.getText())) {
                        if (name.length() == 0) {
                            name.setError("Please Fill Name");
                        } else if (subject.length() == 0) {
                            subject.setError("Please Fill Year");
                        } else if (year.length() == 0) {
                            year.setError("Please Fill Location");
                        }else if (locatation.length() == 0) {
                            locatation.setError("Please Fill Location");
                        }

                    } else {
                        String item = name.getText().toString();
                        cdb.updateName(item, selectID, selectname);

                        String item2 = subject.getText().toString();
                        cdb.updatesubject(item2, selectID1, selectsub);

                        String item3 = year.getText().toString();
                        cdb.updateyear(item3, selectID1, selectyear);

                        String item4 = locatation.getText().toString();
                        cdb.updatelocatation(item4, selectID1, selectloc);

                        String item5 = days.getText().toString();
                        cdb.updatedays(item5, selectID1, selectday);

                        Toast.makeText(getApplicationContext(), "Updated Sucsefully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            });


            btndelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cdb.deleteName(selectID,selectname);
                    Toast.makeText(getApplicationContext(),"Delete Sucsefully",Toast.LENGTH_LONG).show();
                    finish();
                }
            });
    }



}
