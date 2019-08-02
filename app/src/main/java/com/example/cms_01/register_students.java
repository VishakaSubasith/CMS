package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class register_students extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_students);

        Spinner spinner =findViewById(R.id.spinner);
        ArrayAdapter<String> adapter =new ArrayAdapter<>(register_students.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Batches));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapter);
    }
}
