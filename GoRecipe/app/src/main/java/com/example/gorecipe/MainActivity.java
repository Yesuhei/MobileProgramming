package com.example.gorecipe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button loginBtn,chooseRegisterBtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        chooseRegisterBtn = (Button) findViewById(R.id.chooseRegisterBtn);

        chooseRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();
                if(user.equals("") || pass.equals("")){
                    Toast.makeText(MainActivity.this, "Buh talbariig boglono uu.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkuserpass = db.checkusernamepassword(user,pass);
                    if(checkuserpass == true){
                        Toast.makeText(MainActivity.this, "Amjilttai nevterlee.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Home.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Username esvel password buruu baina.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}