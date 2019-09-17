package com.example.cms_01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cms_01.DB.ClassDBHelper;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;
import static android.widget.Toast.LENGTH_SHORT;

public class Classhome extends AppCompatActivity {
ImageView txt;
ProgressBar pgsbar;
ClassDBHelper db;
ListView classlist;
SearchView searchEvent;
ArrayList<String> listitem;
ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classhome);
         txt=findViewById(R.id.imageView10);
        classlist=findViewById(R.id.listv);
        searchEvent=findViewById(R.id.searchbar);
        db= new ClassDBHelper(this);
        listitem= new ArrayList<>();


        searchEvent.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String name) {
                Cursor data = db.searchclassData(name);
                ArrayList<String> listitem = new ArrayList<>();
                while (data.moveToNext()) {
                    listitem.add(data.getString(1));
                }

                adapter= new ArrayAdapter(Classhome.this,simple_list_item_1,listitem);
                classlist.setAdapter(adapter);

                return true;
            }
        });
        classlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String text = classlist.getItemAtPosition(i).toString();
        Cursor cursor = db.viewdata();

        String sub = null;
        String year = null;
        String location = null;
        String day=null;

        while (cursor.moveToNext()) {
            sub = cursor.getString(2);
            year = cursor.getString(3);
            location = cursor.getString(4);
            day=cursor.getString(5);


            Cursor data = db.getItemID(text, sub,year,location);

            int itemID = -1;

            while (data.moveToNext()) {
                itemID = data.getInt(0);


                Intent editsreenIntent = new Intent(Classhome.this, update_delete.class);
                editsreenIntent.putExtra("id", itemID);
                editsreenIntent.putExtra("name", text);
                editsreenIntent.putExtra("subject", sub);
                editsreenIntent.putExtra("year", year);
                editsreenIntent.putExtra("locatation", location);
                editsreenIntent.putExtra("day",day);
                startActivity(editsreenIntent);
            }
        }
    }

});


        viewdata();
    }

    private void viewdata() {
        Cursor cursor= db.viewdata();
        if(cursor.getCount()==0){
            Toast.makeText(this, "No data Show", LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                listitem.add(cursor.getString(1));

            }
            adapter= new ArrayAdapter(this, simple_list_item_1,listitem);
            classlist.setAdapter(adapter);
        }
    }

    public void sendData(View v){
        Intent myintent = new Intent(Classhome.this, ADD_CLASS.class);
        startActivity(myintent);

    }

}
