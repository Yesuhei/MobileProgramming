package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbAndroid,rbWeb,rbJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbAndroid = (RadioButton) findViewById(R.id.rbAndroid);
        rbWeb = (RadioButton) findViewById(R.id.rbWeb);
        rbJava = (RadioButton) findViewById(R.id.rbJava);

        rbAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Android", Toast.LENGTH_SHORT).show();
            }
        });
        rbWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Web", Toast.LENGTH_SHORT).show();
            }
        });
        rbJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Java", Toast.LENGTH_SHORT).show();
            }
        });
    }
}