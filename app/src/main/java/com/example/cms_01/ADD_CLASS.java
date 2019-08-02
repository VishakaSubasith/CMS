package com.example.cms_01;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ADD_CLASS extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
   TextView text1;
   TextView text2;
   TextView text3;
   TextView text4;
   Button click;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__class);
        text1=findViewById(R.id.name);
        text2=findViewById(R.id.year);
        text3=findViewById(R.id.location);

       // text4=findViewById(R.id.days);



        click=(Button)findViewById(R.id.save);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.simpleSpinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Sunday");
        categories.add("Monday");
        categories.add("Tuesday");
        categories.add("Wednesday");
        categories.add("Thursday");
        categories.add("Friday");
        categories.add("Saturday");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(text1.getText())|| TextUtils.isEmpty(text2.getText())|| TextUtils.isEmpty(text3.getText())){
                    if(text1.length() == 0){

                            text1.setError("Please Fill Name");
                        }
                    else if(text2.length() == 0) {
                        text2.setError("Please Fill Year");
                    }
                    else if(text3.length() == 0) {
                        text3.setError("Please Fill Location");
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(),"Saved Sucsefully",Toast.LENGTH_LONG).show();
                }

            }

        });

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
