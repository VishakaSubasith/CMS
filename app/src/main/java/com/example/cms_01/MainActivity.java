package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.cms_01.DB.StudentDBHandler;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    RecyclerView recy;
//    RecyclerView.Adapter adapter;
//    RecyclerView.LayoutManager layoutManager;


StudentDBHandler db;
SearchView search;
Button searchbuttton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //searchbuttton = (Button)findViewById(R.id.searchbtn);
        search=findViewById(R.id.searchtxt);
        final ListView student=(ListView) findViewById(R.id.StudentList);


         db=new StudentDBHandler(this);

        ArrayList<String> students= new ArrayList<>();
        Cursor cursor= db.showStudents();

        if(cursor.getCount()==0){
            Toast.makeText(this,"No Students",Toast.LENGTH_SHORT).show();
        }else{

            while(cursor.moveToNext()){

                students.add(cursor.getString(0));
               ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,students);
                student.setAdapter(listAdapter);


            }



        }

     

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                             @Override
                                             public boolean onQueryTextSubmit(String s) {
                                                 return false;
                                             }
                                             @Override
                                             public boolean onQueryTextChange(String name) {
                                                 Cursor data = db.searchStudentData(name);
                                                 ArrayList<String> Student = new ArrayList<>();
                                                 while (data.moveToNext()) {
                                                     Student.add(data.getString(1));
                                                 }

                                                 ListAdapter adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Student);
                                                 student.setAdapter(adapter);

                                                 return true;
                                             }
                                         }


        );



        viewStudent();



    }



    public void goRegister(View view) {
        Intent intent = new Intent(this,register_students.class);



        startActivity(intent);
    }
    public void goProfile(View view) {
        Intent intent = new Intent(this,Student_Profile.class);



        startActivity(intent);
    }

    public void viewStudent(){
         ListView std=(ListView) findViewById(R.id.StudentList);

        std.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                String name = adapterView.getItemAtPosition(i).toString();
                //Log.d("List data Activity","Onclicj Item "+name);


                Toast.makeText(getApplicationContext(),name,Toast.LENGTH_SHORT).show();
                Cursor data = db.getStudent(name);
                String firstname="";
                String lastname="";
                String Gender="";
                String Birthday="";
                String Batch="";
                String School="";


                while (data.moveToNext()) {

                    //int ID =data.getInt(0);
                    firstname = data.getString(0);
                    lastname = data.getString(1);
                    Gender = data.getString(2);
                    Birthday = data.getString(3);
                    Batch = data.getString(4);
                    School = data.getString(5);

                }



                Intent intent = new Intent(MainActivity.this,Student_Profile.class);

                intent.putExtra("FNAME",firstname);
                intent.putExtra("LNAME",lastname);
                intent.putExtra("GENDER",Gender);
                intent.putExtra("BIRTHDAY",Birthday);
                intent.putExtra("BATCH",Batch);
                intent.putExtra("SCHOOL",School);
//                intent.putExtra("name",student.getItemAtPosition(i).toString());
                startActivity(intent);


            }
        });
    }





    }







