package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cms_01.DB.StudentDB;
import com.example.cms_01.DB.StudentDBHandler;

public class Student_Profile extends AppCompatActivity {

     Button button1;
     Button button2;

     TextView fname;
    EditText lname,bday,scl;
    Spinner gender,batch;

    Context context=this;
    StudentDBHandler db;
    SQLiteDatabase sqLiteDatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__profile);


        Spinner spinner =findViewById(R.id.txtbatch);
        ArrayAdapter<String> adapter =new ArrayAdapter<>(Student_Profile.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Batches));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        Spinner spinner1 =findViewById(R.id.gendertxt);
        ArrayAdapter<String> adapter1 =new ArrayAdapter<>(Student_Profile.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.gender));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);


            fname= (TextView) findViewById(R.id.fnametxt);
            lname= (EditText)findViewById(R.id.lnametxt);
            bday= (EditText)findViewById(R.id.bdaytxt);
            scl= (EditText)findViewById(R.id.scltxt);
            gender=(Spinner)findViewById(R.id.gendertxt);
            batch=(Spinner)findViewById(R.id.txtbatch);

        Intent intent = getIntent();

        //int Id = intent.getIntExtra("id");
            String Fname= intent.getStringExtra("FNAME");
            String Lname= intent.getStringExtra("LNAME");
            String Gender= intent.getStringExtra("GENDER");
            String Bday= intent.getStringExtra("BIRTHDAY");
            String Batch= intent.getStringExtra("BATCH");
            String Scl= intent.getStringExtra("SCHOOL");


            fname.setText(Fname);
            lname.setText(Lname);
            bday.setText(Bday);
            scl.setText(Scl);
            //gender.setAdapter();
            //batch.setText(Fname);




        db=new StudentDBHandler(context);
        sqLiteDatabase=db.getWritableDatabase();





        button1=(Button) findViewById((R.id.OKbtn));
        button2=(Button) findViewById(R.id.removeStudent);

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void onClick(View view){
                fname= (TextView) findViewById(R.id.fnametxt);
                lname= (EditText)findViewById(R.id.lnametxt);
                bday= (EditText)findViewById(R.id.bdaytxt);
                scl= (EditText)findViewById(R.id.scltxt);
                gender=(Spinner)findViewById(R.id.gendertxt);
                batch=(Spinner)findViewById(R.id.txtbatch);

                String Firstname=fname.getText().toString();
                String lastname=lname.getText().toString();
                String birthday=bday.getText().toString();
                String Gender=gender.getSelectedItem().toString();
                String Scl=scl.getText().toString();
                String Batch= batch.getSelectedItem().toString();


                db.UpdateStudent(Firstname,lastname,Gender,birthday,Batch,Scl);
                Toast.makeText(getApplicationContext(),Firstname+" Updated successfull",Toast.LENGTH_LONG).show();
                finish();




                //OpenOk();
            }


        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname= (TextView) findViewById(R.id.fnametxt);
                String Firstname=fname.getText().toString();
                db.DeleteStudent(Firstname);
                Toast.makeText(getApplicationContext(),Firstname+" Deleted successfull",Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(Student_Profile.this,MainActivity.class);
                startActivity(intent1);
            }
        });
    }
    public  void OpenOk(){

        viewsuccessfull viewsuccessfull =new viewsuccessfull();
        viewsuccessfull.show(getSupportFragmentManager(),"view OK");


    }









}
