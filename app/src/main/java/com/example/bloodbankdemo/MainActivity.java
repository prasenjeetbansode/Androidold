package com.example.bloodbankdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button btn;
    Button btnlogin;
    TextInputEditText usertxt,passtxt;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin=findViewById(R.id.btn_login);
        b2=findViewById(R.id.button2);
        btn=findViewById(R.id.btn_login_show);
        usertxt=findViewById(R.id.et_user);
        passtxt=findViewById(R.id.et_pass);
        db= new DatabaseHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=usertxt.getText().toString().trim();
                String pass=passtxt.getText().toString().trim();
                if(db.checkuser(user,pass)){
                    Toast.makeText(MainActivity.this, "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                }












            }
        });
    }
}
