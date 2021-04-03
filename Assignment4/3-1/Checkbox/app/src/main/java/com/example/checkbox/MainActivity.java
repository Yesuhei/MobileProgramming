package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox chAndroid,chWeb,chJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chAndroid = (CheckBox) findViewById(R.id.chAndroid);
        chWeb = (CheckBox) findViewById(R.id.chWeb);
        chJava = (CheckBox) findViewById(R.id.chJava);

        
        chAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chWeb.isChecked()){
                    chWeb.setChecked(false);
                }
                if(chJava.isChecked()){
                    chJava.setChecked(false);
                }
                if(chAndroid.isChecked()){
                    Toast.makeText(MainActivity.this, "Android", Toast.LENGTH_SHORT).show();
                }
            }
        });

        chWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chAndroid.isChecked()){
                    chAndroid.setChecked(false);
                }
                if(chJava.isChecked()){
                    chJava.setChecked(false);
                }
                if(chWeb.isChecked()){
                    Toast.makeText(MainActivity.this, "Web", Toast.LENGTH_SHORT).show();
                }
            }
        });

        chJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chWeb.isChecked()){
                    chWeb.setChecked(false);
                }
                if(chAndroid.isChecked()){
                    chAndroid.setChecked(false);
                }
                if(chJava.isChecked()){
                    Toast.makeText(MainActivity.this, "Java", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}