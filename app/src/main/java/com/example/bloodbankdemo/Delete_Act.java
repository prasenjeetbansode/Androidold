package com.example.bloodbankdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Delete_Act extends AppCompatActivity {
Button b1;
EditText et1;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_);
            b1=findViewById(R.id.btn_del);
            et1=findViewById(R.id.et_phone);
        db=new DatabaseHelper(this);
        b1=findViewById(R.id.btn_del);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no= et1.getText().toString().trim();
                int r=db.DeleteData(no);
            }
        });
    }
}
