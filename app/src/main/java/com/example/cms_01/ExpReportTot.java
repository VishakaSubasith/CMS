package com.example.cms_01;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.cms_01.DB.ExpenseDBHelper;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ExpReportTot extends AppCompatActivity {


    ListView listview;
    ExpenseDBHelper expdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_report_tot);

        expdb = new ExpenseDBHelper(this);
        listview = findViewById(R.id.expTotalView);

        expListView();

    }

    public void expListView() {

        String to="";
        String from="";


        Intent intent = getIntent();
        to = intent.getStringExtra("asf");
        from = intent.getStringExtra("asff");

        Cursor data = expdb.getDateExp(to,from);

        ArrayList<String> listExp = new ArrayList<>();
        while (data.moveToNext()) {
            listExp.add(data.getString(1));

        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listExp);
        listview.setAdapter(adapter);


    }
}
