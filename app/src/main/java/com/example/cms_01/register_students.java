package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cms_01.DB.StudentDBHandler;

public class register_students extends AppCompatActivity {


        EditText fname,lname,bday,scl;
        RadioButton gendermale,genderfemale;
        Spinner batch;


    Context context=this;
    StudentDBHandler db;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_students);

        Spinner spinner =findViewById(R.id.batch);
        ArrayAdapter<String> adapter =new ArrayAdapter<>(register_students.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Batches));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);

       fname=(EditText)findViewById(R.id.fname);
       lname=(EditText)findViewById(R.id.lname);
       gendermale=(RadioButton)findViewById(R.id.male);
       genderfemale=(RadioButton)findViewById(R.id.female);
       bday=(EditText)findViewById(R.id.bday);
       batch=(Spinner)findViewById(R.id.batch);
       scl=(EditText)findViewById(R.id.scl);


    }
    public void AddStudent(View view){
        String NumberPattern = "[1-9][0-9]*|0";

            String Fname= fname.getText().toString();
            String Lname=lname.getText().toString();
            String Male=genderfemale.getText().toString();
            String Female=genderfemale.getText().toString();
            String Bday=bday.getText().toString();
            String Batch= batch.getSelectedItem().toString();
            String Scl= scl.getText().toString();

            db=new StudentDBHandler(context);
            sqLiteDatabase=db.getWritableDatabase();

        if(fname.length() != 0 && lname.length() != 0 && gendermale.length()!= 0 && genderfemale.length()!= 0 && bday.length()!= 0 && scl.length()!= 0 &&  lname.getText().toString().matches(NumberPattern)){


            if (Male == "male" || Male == "Male") {


                db.addStudent(Fname, Lname, Male, Bday, Batch, Scl);
                Toast.makeText(getApplicationContext(), "1 Student added", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(register_students.this, MainActivity.class);
                startActivity(intent);
            } else {
                db.addStudent(Fname, Lname, Female, Bday, Batch, Scl);
                Toast.makeText(getApplicationContext(), "1 Student added", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(register_students.this, MainActivity.class);
                startActivity(intent);
            }
        }else{
            Toast.makeText(getApplicationContext(), "Please enter all details!", Toast.LENGTH_LONG).show();


        }
            db.close();


    }
}
