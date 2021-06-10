package com.example.gorecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText etUsername,etPassword,etConfirmPassword;
    Button registerBtn,chooseLoginBtn;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBHelper(this);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
//        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        chooseLoginBtn = (Button) findViewById(R.id.chooseLoginBtn);



        chooseLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();


                if(user.equals("") || pass.equals("")){
                    Toast.makeText(Register.this, "Buh talbariig boglono uu.", Toast.LENGTH_SHORT).show();
                }
                else{
                        Boolean checkuser = db.checkusername(user);
                        if(checkuser == false){
                            Boolean insert = db.insertData(user,pass);
                            if(insert == true){
                                Toast.makeText(Register.this, "Amjilttai burtgegdlee.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Register.this,MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Register.this, "Burtgel amjiltgui bolloo.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(Register.this, "Burtgeltei hereglegch baina.", Toast.LENGTH_SHORT).show();
                        }
                }
//                else{
//                    if(pass.equals(confirmpass)){
//                        Boolean checkuser = db.checkusername(user);
//                        if(checkuser == false){
//                            Boolean insert = db.insertData(user,pass);
//                            if(insert == true){
//                                Toast.makeText(Register.this, "Amjilttai burtgegdlee.", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(Register.this,MainActivity.class);
//                                startActivity(intent);
//                            }else{
//                                Toast.makeText(Register.this, "Burtgel amjiltgui bolloo.", Toast.LENGTH_SHORT).show();
//                            }
//                        }else{
//                            Toast.makeText(Register.this, "Burtgeltei hereglegch baina.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    Toast.makeText(Register.this, "Zuv nuuts ug oruulna uu.", Toast.LENGTH_SHORT).show();
//                }


            }
        });

    }
}