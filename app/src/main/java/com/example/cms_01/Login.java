package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

        EditText name;
        EditText pass;
        ImageView register;
        Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login);
        register=findViewById(R.id.imageView19);
    login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        validate(name.getText().toString(),pass.getText().toString());
    }
});

    }
    public void register(View v){
        Intent aaa = new Intent(Login.this,register.class);
        startActivity(aaa);
    }
    public void validate(String username, String password){

        if((username.equals("admin")) && (password.equals("1234"))){
            Intent intent = new Intent(Login.this,HomeNew.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Login Pass!!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Invalid Password or Username",Toast.LENGTH_LONG).show();
        }
    }


}
