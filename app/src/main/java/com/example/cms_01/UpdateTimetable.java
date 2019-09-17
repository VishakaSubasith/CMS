package com.example.cms_01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cms_01.DB.TimetableDBHelper;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateTimetable extends AppCompatActivity {

    private Button btnUpdate,btnDelete;
    TimetableDBHelper mydb;
    private EditText editable_id,editable_subject,editable_batch,editable_venue,editable_type,editable_date,editable_durationst,editable_durationto,editable_notice;

    private String subject;
    private String id;
    private String venue,date,durato,durast,notice;
    private String Batch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_timetable);


        btnUpdate = (Button) findViewById(R.id.button17);
        btnDelete = (Button) findViewById(R.id.button16);
        editable_subject = findViewById(R.id.editText25);
        editable_batch = findViewById(R.id.editText26);
        editable_venue = findViewById(R.id.editText27);
        //editable_type = findViewById(R.id.editText28);
        editable_date = findViewById(R.id.editText28);
        editable_durationst = findViewById(R.id.editText29);
        editable_durationto = findViewById(R.id.editText30);
        editable_notice = findViewById(R.id.editText31);

        mydb = new TimetableDBHelper(this);

        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        id = String.valueOf(receivedIntent.getIntExtra("id", -1)); //NOTE: -1 is just the default value

        //now get the subject we passed as an extra
        subject = receivedIntent.getStringExtra("subject");
        Batch = receivedIntent.getStringExtra("batch");
        venue = receivedIntent.getStringExtra("venue");
        date = receivedIntent.getStringExtra("date");
        durato = receivedIntent.getStringExtra("durato");
        durast = receivedIntent.getStringExtra("durast");
        notice = receivedIntent.getStringExtra("notice");

        //set the text to show the current selected name
        editable_subject.setText(subject);
        editable_batch.setText(Batch);
        editable_venue.setText(venue);
        editable_date.setText(date);
        editable_durationst.setText(durast);
        editable_durationto.setText(durato);
        editable_notice.setText(notice);
        //updatedata();

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deletedtask = mydb.deleteTask(editable_subject.getText().toString());

                if(deletedtask > 0){
                    toastMessage("Deleted");
                    Intent editScreenIntent1 = new Intent(UpdateTimetable.this, retrivedata.class);
                    startActivity(editScreenIntent1);


                }else{

                    toastMessage("Not deleted!");
                }
                /*mydb.deleteTask(id,subject);
                editable_subject.setText("");
                toastMessage("removed from database");
                Intent editScreenIntent1 = new Intent(UpdateTimetable.this, retrivedata.class);
                startActivity(editScreenIntent1);
                */
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = editable_subject.getText().toString();
                if(!task.equals("")){
                    boolean updatdtime = mydb.updateName(editable_subject.getText().toString(), editable_date.getText().toString(), editable_batch.getText().toString(), editable_venue.getText().toString(), editable_notice.getText().toString(), editable_durationst.getText().toString(), editable_durationto.getText().toString());
                    if(updatdtime == true){
                        toastMessage("update succussfully");
                        Intent editScreenIntent3 = new Intent(UpdateTimetable.this, retrivedata.class);
                        startActivity(editScreenIntent3);

                    }else{
                        toastMessage("You must enter a name");


                    }

                }

            }
        });
    }

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
}
/*public void updatedata(){
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate= mydb.updatedata(editable_subject.getText().toString(),
                               editable_batch.getText().toString(), editable_venue.getText().toString(),editable_date.getText().toString(),editable_durationst.getText().toString()
                        ,editable_durationto.getText().toString(),editable_type.getText().toString(),editable_notice.getText().toString());

                        if(isUpdate==true){
                            toastMessage("UPDATE SUCCESSFULL");
                        }else{
                            toastMessage("UPDATE NOT SUCCESSFULL");
                        }
                    }
                }
        );
}*/
    }
