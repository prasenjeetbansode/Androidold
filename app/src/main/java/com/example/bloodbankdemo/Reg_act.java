package com.example.bloodbankdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Reg_act extends AppCompatActivity {
EditText et_name,et_phne,et_email,et_pass,et_passck;
Button btn_submit, btn_fetch;
DatabaseHelper db;
RadioGroup rg;
RadioButton rb1,rb2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_act);
        et_name= findViewById(R.id.et_name);
        et_phne= findViewById(R.id.et_phone);
        et_email= findViewById(R.id.et_email);
        et_pass= findViewById(R.id.et_pass);
        et_passck= findViewById(R.id.et_passck);
        btn_submit=findViewById(R.id.btn_sub);
        btn_fetch=findViewById(R.id.btn_fetch);
        rb1= findViewById(R.id.radioButton);
        rb2= findViewById(R.id.radioButton2);
        rg=findViewById(R.id.gender);
        db=new DatabaseHelper(this);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                String name= et_name.getText().toString();
                String phone= et_phne.getText().toString();
                String pass= et_pass.getText().toString();
                String email= et_email.getText().toString();
              String g="male";
                Boolean result = db.insertData(name,phone,pass,email,g);
             if(et_pass.getText().toString().trim().equals(et_passck.getText().toString().trim())){
                    if(result==true){
                        Toast.makeText(Reg_act.this, "DATA INSERTED", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Reg_act.this, "NOT INSERTED", Toast.LENGTH_SHORT).show();
                    }

               }
                else {
                        Toast.makeText(Reg_act.this, "Please Enter same password ", Toast.LENGTH_SHORT).show();
                    }
            }
        });

            btn_fetch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(Reg_act.this,Fetch_data.class);
                    startActivity(i);
                }
            });


    }
}
