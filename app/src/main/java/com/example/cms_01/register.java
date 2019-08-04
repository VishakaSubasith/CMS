package com.example.cms_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText text1;
    EditText text2;
    EditText text3;
    EditText text4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        text1 = findViewById(R.id.fname);
        text2 = findViewById(R.id.llname);
        text3 = findViewById(R.id.uname);
        text4 = findViewById(R.id.pw);


    }

    public void data(View v){
        Toast.makeText(getApplicationContext(),"Saved Sucsefully",Toast.LENGTH_LONG).show();
    }
}
