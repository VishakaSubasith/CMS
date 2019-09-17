package com.example.cms_01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.cms_01.DB.TimetableDBHelper;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class retrivedata extends AppCompatActivity {
    private static final String TAG ="TimetableDBHelper" ;

    // RecyclerView recy;
   // RecyclerView.Adapter adapter;
    //RecyclerView.LayoutManager layoutManager;

    ArrayList<String> listtask;
    ArrayAdapter adapter1;
    TimetableDBHelper mydb;
SearchView searchtask;
    ListView userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrivedata);

       // recy=findViewById(R.id.recycletime);
        //recy.setHasFixedSize(true);

      /*  layoutManager= new LinearLayoutManager(this);
        recy.setLayoutManager(layoutManager);
        adapter= new MyAdapter3();
        recy.setAdapter(adapter);*/

        listtask=new ArrayList<>();
        userlist=findViewById(R.id.add_task);
        mydb=new TimetableDBHelper(this);
        searchtask = findViewById(R.id.searchtask);


        viewData();
        /*userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text=userlist.getItemAtPosition(i).toString();

                Toast.makeText(retrivedata.this,""+text,Toast.LENGTH_SHORT).show();

                Intent intent3=new Intent(retrivedata.this,UpdateTimetable.class);
                startActivity(intent3);
            }
        });*/
        searchtask.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                             @Override
                                             public boolean onQueryTextSubmit(String s) {
                                                 return false;
                                             }
                                             @Override
                                             public boolean onQueryTextChange(String expnme) {
                                                 Cursor data = mydb.searchTaskData(expnme);
                                                 ArrayList<String> listTask = new ArrayList<>();
                                                 while (data.moveToNext()) {
                                                     listTask.add(data.getString(1));

                                                 }

                                                 ListAdapter adapter = new ArrayAdapter<String>(retrivedata.this, android.R.layout.simple_list_item_1, listTask);
                                                 userlist.setAdapter(adapter);

                                                 return true;
                                             }
                                         }


        );
    }
    private void viewData() {
        Cursor cursor= mydb.viewData();

        if(cursor.getCount()==0){
            Toast.makeText(this,"no data to show",Toast.LENGTH_SHORT).show();

        }else {
            while (cursor.moveToNext()) {
                listtask.add(cursor.getString(1));


            }

            adapter1=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listtask);
            userlist.setAdapter(adapter1);

            userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String subject=adapterView.getItemAtPosition(i).toString();
                    //String batch=adapterView.getItemAtPosition(i).toString();
                    Log.d(TAG, "onItemClick: You Clicked on " + subject);

                    int taskID = -1;
                    String Batch="";
                    String Subject="";
                    String venue="";
                    String date="";
                    String durast = "";
                    String durato="";
                    String notice ="";

                    Cursor data =  mydb.getTaskID(subject);
                   // Cursor data1 =  mydb.updateName(subject, String.valueOf(data),subject);

                    while(data.moveToNext()){
                        taskID = data.getInt(0);
                        Subject=data.getString(1);
                        Batch =data.getString(2);
                        venue = data.getString(3);
                        date = data.getString(4);
                        durast = data.getString(5);
                        durato = data.getString(6);
                        notice = data.getString(8);
                    }
                    if(taskID > -1){
                       // Log.d(TAG, "onItemClick: The ID is: " + taskID);
                        //Log.d(TAG, "onItemClick: You Clicked on " + batch);


                        Intent editScreenIntent = new Intent(retrivedata.this, UpdateTimetable.class);
                        editScreenIntent.putExtra("id",taskID);
                        editScreenIntent.putExtra("subject",Subject);
                        editScreenIntent.putExtra("batch",Batch);
                        editScreenIntent.putExtra("venue",venue);
                        editScreenIntent.putExtra("date",date);
                        editScreenIntent.putExtra("durast",durast);
                        editScreenIntent.putExtra("durato",durato);
                        editScreenIntent.putExtra("notice",notice);
                        startActivity(editScreenIntent);
                    }
                    else{
                        toastMessage("No ID associated with that name");
                    }
                }

            });
        }
    }
    public void send(View V){
        Intent intent2=new Intent(retrivedata.this, Insert_Activity.class);
        startActivity(intent2);
    }

    public void onupdateDelete(View V){

        Intent intent3=new Intent(retrivedata.this, UpdateTimetable.class);
        startActivity(intent3);
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
