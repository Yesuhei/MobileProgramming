package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button leftBtn,rightBtn,bottomBtn;
    View leftLay,rightLay,bottomLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EditText editText = (EditText) findViewById(R.id.editText);
//        Button btn = (Button) findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String txt = editText.getText().toString();
//                Toast.makeText(MainActivity.this, txt , Toast.LENGTH_SHORT).show();
//            }
//        });
        leftBtn = (Button) findViewById(R.id.leftBtn);
        leftLay = findViewById(R.id.leftLay);
        leftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                leftLay.setBackgroundColor(color);
            }
        });
        rightBtn = (Button) findViewById(R.id.rightBtn);
        rightLay = findViewById(R.id.rightLay);
        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                rightLay.setBackgroundColor(color);
            }
        });
        bottomBtn = (Button) findViewById(R.id.bottomBtn);
        bottomLay = findViewById(R.id.bottomLay);
        bottomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                bottomLay.setBackgroundColor(color);
            }
        });
    }
}