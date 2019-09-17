package com.example.cms_01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.cms_01.DB.ExpenseDBHelper;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class AddExp extends AppCompatActivity {
    ImageView img1;
    ListView listview1;
    Button expUpdate, expDelete;
    ListView listview;
    ExpenseDBHelper expdb;
    int id;
SearchView expsearch;
    ExpenseDBHelper db;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exp);

        img1 = (ImageView) findViewById(R.id.imageView3);

        expdb = new ExpenseDBHelper(this);
        listview = findViewById(R.id.expListView);


        // Capture button clicks
        img1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openAddExp();

            }
        });

        expListView();
    }

    public void expListView() {
        Cursor data = expdb.viewExpData();

        ArrayList<String> listExp = new ArrayList<>();
        while (data.moveToNext()) {
            listExp.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listExp);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();

                Cursor data1 = expdb.getExpenseID(name);

                //      int expID = -1;
                String expnme = "";
                String expCat = "";
                String expAmo = "";
                String Date = "";

                while (data1.moveToNext()) {
                    //  expID = data.getInt(0);
                    expnme = data1.getString(0);
                    expCat = data1.getString(1);
                    expAmo = data1.getString(2);
                    Date = data1.getString(3);

                }
                Intent intent = new Intent(AddExp.this, ExpUpdate.class);
                //     intent.putExtra("ID", expID);
                intent.putExtra("expnme", expnme);
                intent.putExtra("expcat", expCat);
                intent.putExtra("expamo", expAmo);
                intent.putExtra("expdat", Date);
                startActivity(intent);


            }
        });

        expsearch = findViewById(R.id.expsearchView);
        expsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                             @Override
                                             public boolean onQueryTextSubmit(String s) {
                                                 return false;
                                             }
                                             @Override
                                             public boolean onQueryTextChange(String expnme) {
                                                 Cursor data = expdb.searchExpData(expnme);
                                                 ArrayList<String> listExp = new ArrayList<>();
                                                 while (data.moveToNext()) {
                                                     listExp.add(data.getString(1));
                                                 }

                                                 ListAdapter adapter = new ArrayAdapter<String>(AddExp.this, android.R.layout.simple_list_item_1, listExp);
                                                 listview.setAdapter(adapter);

                                                 return true;
                                             }
                                         }


        );

    }

    public void openAddExp() {
        Intent intent1 = new Intent(this, ExpMng.class);
        startActivity(intent1);

    }


}