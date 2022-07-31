package com.example.bloodbankdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_Act extends AppCompatActivity {
    EditText et_name,et_phne,et_email,et_pass,et_id;
    Button btn_update;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_);
        et_name= findViewById(R.id.et_name);
        et_phne= findViewById(R.id.et_phone);
        et_email= findViewById(R.id.et_email);
        et_pass= findViewById(R.id.et_pass1);
        et_id=findViewById(R.id.txt_id);
        btn_update=findViewById(R.id.btn_update);
        db=new DatabaseHelper(this);
    btn_update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name= et_name.getText().toString();
            String phone= et_phne.getText().toString();
            String pass= et_pass.getText().toString();
            String email= et_email.getText().toString();
            String id =et_id.getText().toString().trim();
            long id_temp= Long.parseLong(id);
            if(id_temp!=0){

            Boolean result = db.updateData(id,name,phone,pass,email);
                    if(result==true){
                        Toast.makeText(Update_Act.this, "data updated", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Update_Act.this, "error", Toast.LENGTH_SHORT).show();
                    }


            }
        }
    });
    }
}
