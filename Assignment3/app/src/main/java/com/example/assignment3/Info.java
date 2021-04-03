package com.example.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Info extends AppCompatActivity{

    private TextView fname,phone,address;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        String ner = getIntent().getStringExtra("ner");
        String utas = getIntent().getStringExtra("utas");
        String hayg = getIntent().getStringExtra("hayg");


        fname = findViewById(R.id.fname);
        fname.setText(ner);

        phone = findViewById(R.id.phone);
        phone.setText(utas);

        address = findViewById(R.id.address);
        address.setText(hayg);

        back = (Button) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Info.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}