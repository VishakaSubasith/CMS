package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Student_Profile extends AppCompatActivity {

    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);


        Spinner spinner =findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter =new ArrayAdapter<>(Student_Profile.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Batches));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        button1=(Button) findViewById((R.id.OKbtn));
        button2=(Button) findViewById(R.id.removeStudent);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View view){

                OpenOk();
            }


        });
    }
    public  void OpenOk(){

        viewsuccessfull viewsuccessfull =new viewsuccessfull();
        viewsuccessfull.show(getSupportFragmentManager(),"view OK");


    }


}
