package com.example.cms_01;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.cms_01.DB.TimetableDBHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

public class Insert_Activity extends AppCompatActivity {
    private  int year,month,day,hour,minute;
    private Calendar calander;

    SimpleDateFormat sdf=new SimpleDateFormat("YYYY/MM/dd hh:mm a");
    EditText editsubject,editbatch,editvenue,editdurationst,editdurationto,editdate,editnotice;
    Spinner edittype;
    Button save;
    TimetableDBHelper mydb;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_);

        calander=Calendar.getInstance(Locale.getDefault());
        year=calander.get(Calendar.YEAR);
        month=calander.get(Calendar.MONTH);
        day=calander.get(Calendar.DAY_OF_MONTH);
        hour=calander.get(Calendar.HOUR);
        minute=calander.get(Calendar.MINUTE);


        setTitle(R.string.lable4);
        mydb=new TimetableDBHelper(this);





        editsubject=findViewById(R.id.subject_edit);
        editbatch=findViewById(R.id.batch_edit);
        editvenue=findViewById(R.id.venue_edit);
        editdurationst=findViewById(R.id.durationst_edit);
        editdurationto=findViewById(R.id.durationto_edit);
        editdate=findViewById(R.id.date_edit);
        editnotice=findViewById(R.id.notice_edit);
        edittype=findViewById(R.id.type_spinner);

        editdate.setText("Selected Date: "+ Calendar.YEAR+"/"+ (Calendar.MONTH + 1)+"/"+Calendar.DAY_OF_MONTH);
        save=findViewById(R.id.savebtn);




        addtimetabledata();

      /*  viewData();
        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text=userlist.getItemAtPosition(i).toString();
                Toast.makeText(Insert_Activity.this,""+text,Toast.LENGTH_SHORT).show();
            }
        });

*/


       ////Spinner spinner = findViewById(R.id.spinner1);

        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
        //spinner.setOnItemClickListener(this);

    }

  /*  private void viewData() {
        Cursor cursor= mydb.viewData();

        if(cursor.getCount()==0){
            Toast.makeText(this,"no data to show",Toast.LENGTH_SHORT).show();

        }else{
            while(cursor.moveToNext()){
                listtask.add(cursor.getString(1));
            }
            adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listtask);
            userlist.setAdapter(adapter);

        }
    }*/
  public void btn_cancel() {
      Intent cancel = new Intent(Insert_Activity.this, retrivedata.class);
      startActivity(cancel);
  }

    public void showdate(View view){
            DatePickerDialog dpd=new DatePickerDialog(this,dateListener,year,month,day);
            dpd.show();

        }
        private DatePickerDialog.OnDateSetListener dateListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Toast.makeText(Insert_Activity.this,"year"+year,Toast.LENGTH_SHORT).show();
                Toast.makeText(Insert_Activity.this,"month"+month,Toast.LENGTH_SHORT).show();
                Toast.makeText(Insert_Activity.this,"day"+dayOfMonth,Toast.LENGTH_SHORT).show();
                editdate.setText( year+"/"+ (month + 1)+"/"+dayOfMonth);

            }
        };

        public void showtime(View view){
            TimePickerDialog tpd=new TimePickerDialog(this,timeListener,hour,minute,true);
            tpd.show();
        }
        private TimePickerDialog.OnTimeSetListener timeListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                editdurationst.setText(hourOfDay+":"+minute);
                editdurationto.setText(hourOfDay+":"+minute);

            }


        };




    public void addtimetabledata(){
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean inserted = mydb.insertdata(editsubject.getText().toString(), editbatch.getText().toString(), editvenue.getText().toString(), editdate.getText().toString(), editdurationst.getText().toString(), editdurationto.getText().toString(), edittype.getAdapter().toString(), editnotice.getText().toString());

                        if (inserted == true) {
                            Toast.makeText(Insert_Activity.this, "data inserted", Toast.LENGTH_LONG).show();

                            Intent intent2 = new Intent(Insert_Activity.this, retrivedata.class);
                            startActivity(intent2);

                        }
                        else
                            Toast.makeText(Insert_Activity.this, "data not inserted", Toast.LENGTH_LONG).show();

                    }

                }
        );
    }


}
