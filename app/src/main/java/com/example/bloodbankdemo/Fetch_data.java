package com.example.bloodbankdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Fetch_data extends AppCompatActivity {
Button b1,btn_g;
TextView tv;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);
        b1=findViewById(R.id.b1);
       btn_g=findViewById(R.id.btn_getid);
        tv=findViewById(R.id.txt_v);
  db=new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor= db.getAllData();
                StringBuffer sb= new StringBuffer();
                if((cursor!= null) && (cursor.getCount()>0)){
                    while (cursor.moveToNext()){
                        sb.append("id : "+ cursor.getString(0)+ "\n");
                        sb.append("name : "+ cursor.getString(1)+ "\n");
                        sb.append("phone : "+ cursor.getString(2)+ "\n");
                        sb.append("Email : "+ cursor.getString(3)+ "\n");
                        sb.append("password : "+ cursor.getString(4)+ "\n");
                        sb.append("gender : "+ cursor.getString(5)+ "\n");
                           }

                 tv.setText(sb.toString());
                    Toast.makeText(Fetch_data.this, "data found", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Fetch_data.this, "data not found", Toast.LENGTH_SHORT).show();
                }
            }
        });

   btn_g.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent i=new Intent(Fetch_data.this,Update_Act.class);
           startActivity(i);
       }
   });




    }
}
